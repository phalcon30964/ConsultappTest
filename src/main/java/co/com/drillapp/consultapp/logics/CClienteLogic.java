package co.com.drillapp.consultapp.logics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.drillapp.consultapp.daos.IClienteDAO;
import co.com.drillapp.consultapp.models.Cliente;
import co.com.drillapp.consultapp.models.ClientePK;

@Service
@Scope("singleton")
public class CClienteLogic implements IClienteLogic {

	@Autowired
	private IClienteDAO clienteDAO;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void save(Cliente cliente) throws Exception {
		validarCliente(cliente);
		if (validarSiExisteCliente(cliente) || clienteDAO.getByEmail(cliente.getEmail()) != null) {
			throw new Exception("Ya existe un cliente con el mismo id o email");
		}
		clienteDAO.persist(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente getById(ClientePK clientePK) throws Exception {
		if (clientePK == null || clientePK.getIdentificacion() == null || clientePK.getIdentificacion() == null) {
			throw new Exception("Introduzca una identificación válida");
		}
		return clienteDAO.getById(clientePK);
	}


	@Transactional(readOnly = true)
	public Cliente getByEmailContrasena(String email, String password) throws Exception {
		Cliente cliente = clienteDAO.getByEmailPassword(email, password);
		if (cliente == null) {
			throw new Exception("Email o contraseña inválidos");
		}
		return cliente;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void edit(Cliente cliente) throws Exception {
		validarCliente(cliente);
		if (!validarSiExisteCliente(cliente)) {
			throw new Exception("No existe cliente");
		}
		clienteDAO.merge(cliente);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(ClientePK clientePK) throws Exception {
		if (clientePK == null || clientePK.getIdentificacion() == null || clientePK.getIdentificacion() == null || getById(clientePK)==null) {
			throw new Exception("No existe cliente");
		}
		clienteDAO.remove(clientePK);
	}

	/**
	 * Metodo encargado de validar condiciones del objeto cliente
	 */
	public void validarCliente(Cliente cliente) throws Exception {

		if (cliente == null) {
			throw new Exception("Cliente invalido");
		}
		if (cliente.getNombres() == null || cliente.getApellidos()==null|| cliente.getEmail() == null
				|| cliente.getFechaNacimiento() == null || cliente.getPassword() == null
				|| cliente.getPassword().isEmpty() || cliente.getClientePK() == null
				|| cliente.getClientePK().getIdentificacion() == null
				|| cliente.getClientePK().getTipoIdentificacion() == null) {
			throw new Exception("Faltan datos importantes del cliente");
		}
	}

	/**
	 * Metodo encargado de validar condiciones del objeto cliente
	 */
	public boolean validarSiExisteCliente(Cliente cliente) throws Exception {
		return getById(cliente.getClientePK()) != null;
	}

}
