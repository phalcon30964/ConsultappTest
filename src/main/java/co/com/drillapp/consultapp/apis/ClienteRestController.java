package co.com.drillapp.consultapp.apis;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.drillapp.consultapp.delegado.IDelegadoDeNegocio;
import co.com.drillapp.consultapp.dtos.ClienteDTO;
import co.com.drillapp.consultapp.dtos.ErrorDTO;
import co.com.drillapp.consultapp.dtos.SubcategoriaDTO;
import co.com.drillapp.consultapp.models.Cliente;
import co.com.drillapp.consultapp.models.ClientePK;
import co.com.drillapp.consultapp.models.Subcategoria;
import co.com.drillapp.consultapp.models.SubcategoriaPK;

@RestController
@RequestMapping("/cliente")
public class ClienteRestController {

	private Logger log = LoggerFactory.getLogger(ClienteRestController.class);

	@Autowired
	private IDelegadoDeNegocio delegadoDeNegocio;

	@RequestMapping(value = "/get/{identificacion}/{tipoIdentificacion}", method = RequestMethod.GET)
	public ClienteDTO get(@PathVariable("identificacion") String id, @PathVariable("tipoIdentificacion") String tipoId)
			throws Exception {
		
		System.out.println(
				"Entro a get-----------------------------------------------------------------------------------------------------");
		try {
			Cliente cliente = delegadoDeNegocio.getClienteById(new ClientePK(id, tipoId));
			if (cliente == null) {
				throw new Exception("No existe cliente");
			}
			return parseCliente(cliente);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}
	
	@RequestMapping(value = "/signin/{email}/{contrasena}", method = RequestMethod.GET)
	public ClienteDTO signin(@PathVariable("email") String email, @PathVariable("contrasena") String contrasena)
			throws Exception {
		System.out.println(
				"Entro a singin-----------------------------------------------------------------------------------------------------");
		try {
			Cliente cliente = delegadoDeNegocio.getClienteByEmailContrasena(email, contrasena);
			if (cliente == null) {
				throw new Exception("Usuario o contraseña invalidos");
			}
			return parseCliente(cliente);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}


	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(@RequestBody ClienteDTO clienteDTO) throws Exception {
		System.out.println(
				"Entro a post-----------------------------------------------------------------------------------------------------");
		try {
			delegadoDeNegocio.saveCliente(parseClienteDTO(clienteDTO));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}
	

	@RequestMapping(value = "/savePicture", method = RequestMethod.POST)
	public void savePic(@RequestBody File pic) throws Exception {
	System.out.println("Entro al post-----------------------------------------------------------------------------------------------------");
	}

	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	public void edit(@RequestBody ClienteDTO clienteDTO) throws Exception {
		System.out.println(
				"Entro a put-----------------------------------------------------------------------------------------------------");
		try {
			delegadoDeNegocio.editCliente(parseClienteDTO(clienteDTO));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@RequestMapping(value = "/delete/{identificacion}/{tipoIdentificacion}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("identificacion") String identificacion,
			@PathVariable("tipoIdentificacion") String tipoIdentificacion) throws Exception {
		System.out.println(
				"Entro al delete-----------------------------------------------------------------------------------------------------");
		try {
			delegadoDeNegocio.deleteCliente(new ClientePK(identificacion, tipoIdentificacion));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	public ClienteDTO parseCliente(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setIdentificacion(cliente.getClientePK().getIdentificacion());
		clienteDTO.setTipoIdentificacion(cliente.getClientePK().getTipoIdentificacion());
		clienteDTO.setEstado(cliente.getEstado());
		clienteDTO.setNombres(cliente.getNombres());
		clienteDTO.setApellidos(cliente.getApellidos());
		clienteDTO.setEmail(cliente.getEmail());
		clienteDTO.setPassword(cliente.getPassword());
		clienteDTO.setTelefono(cliente.getTelefono());
		clienteDTO.setFechaNacimiento(cliente.getFechaNacimiento());
		clienteDTO.setUrlFoto(cliente.getUrlFoto());
		return clienteDTO;
	}

	public Cliente parseClienteDTO(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		ClientePK clientePK = new ClientePK();
		clientePK.setIdentificacion(clienteDTO.getIdentificacion());
		clientePK.setTipoIdentificacion(clienteDTO.getTipoIdentificacion());
		cliente.setClientePK(clientePK);
		cliente.setEstado(clienteDTO.getEstado());
		cliente.setNombres(clienteDTO.getNombres());
		cliente.setApellidos(clienteDTO.getApellidos());
		cliente.setEmail(clienteDTO.getEmail());
		cliente.setPassword(clienteDTO.getPassword());
		cliente.setTelefono(clienteDTO.getTelefono());
		cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());
		cliente.setUrlFoto(clienteDTO.getUrlFoto());
		return cliente;
	}

	@RequestMapping("*")
	@ResponseBody
	public ErrorDTO fallbackMethod() {
		ErrorDTO error = new ErrorDTO();
		error.setDescription("Service does not exist");
		return error;
	}

	@ExceptionHandler({ Exception.class })
	public ErrorDTO handleException(Exception e) {
		ErrorDTO error = new ErrorDTO();
		error.setDescription(e.getMessage());
		return error;
	}

}
