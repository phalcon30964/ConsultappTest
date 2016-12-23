package co.com.drillapp.consultapp.logics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.drillapp.consultapp.daos.IMediopagoDAO;
import co.com.drillapp.consultapp.models.Mediopago;
import co.com.drillapp.consultapp.models.MediopagoPK;

@Service
@Scope("singleton")
public class CMediopagoLogic implements IMediopagoLogic {
	
	@Autowired
    private IMediopagoDAO mediopagoDAO;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void save(Mediopago mediopago) throws Exception {
		validarMediopago(mediopago);
		if(validarSiExisteMediopago(mediopago)){
			throw new Exception("Ya existe medio de pago");
		}
		mediopagoDAO.persist(mediopago);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void edit(Mediopago mediopago) throws Exception {
		validarMediopago(mediopago);
		if(!validarSiExisteMediopago(mediopago)){
			throw new Exception("No existe medio de pago");
		}
		mediopagoDAO.merge(mediopago);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(MediopagoPK mediopagoPk) throws Exception {
		if (mediopagoPk == null || getById(mediopagoPk) == null) {
			throw new Exception("No existe medio de pago");
		}
		mediopagoDAO.remove(mediopagoPk);
	}

	@Override
	@Transactional(readOnly = true)
	public Mediopago getById(MediopagoPK mediopagoPk) throws Exception {
		if (mediopagoPk == null) {
			throw new Exception("No existe medio de pago");
		}
		return mediopagoDAO.getById(mediopagoPk);
	}
	
	/**
	 * Metodo encargado de validar condiciones del objeto Mediopago
	 */
	private void validarMediopago(Mediopago mediopago) throws Exception{
		if(mediopago==null||
		   mediopago.getMediopagoPK().getNumeroTarjeta().isEmpty()||mediopago.getMediopagoPK().getNumeroTarjeta()==null ||
		   mediopago.getMediopagoPK().getIdentificacionCliente().isEmpty()||mediopago.getMediopagoPK().getIdentificacionCliente()==null ||
		   mediopago.getMediopagoPK().getTipoIdentificacionCliente().isEmpty()||mediopago.getMediopagoPK().getTipoIdentificacionCliente()==null ||
		   mediopago.getCodigoSeguridad().isEmpty()|| mediopago.getCodigoSeguridad() ==null ||
		   mediopago.getFechaCaducidad() == null){
			throw new Exception("Medio de pago invalido");
		}
	}
	
	/**
	 * Metodo encargado de validar condiciones del objeto Mediopago 
	 */
	private boolean validarSiExisteMediopago(Mediopago mediopago)throws Exception{
		return getById(mediopago.getMediopagoPK())!=null;		
	}
	
}
