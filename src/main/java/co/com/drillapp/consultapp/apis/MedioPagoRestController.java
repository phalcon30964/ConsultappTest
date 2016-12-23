package co.com.drillapp.consultapp.apis;

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

import co.com.drillapp.consultapp.delegado.IDelegadoDeNegocio;
import co.com.drillapp.consultapp.dtos.ClienteDTO;
import co.com.drillapp.consultapp.dtos.ErrorDTO;
import co.com.drillapp.consultapp.dtos.MediopagoDTO;
import co.com.drillapp.consultapp.models.Cliente;
import co.com.drillapp.consultapp.models.ClientePK;
import co.com.drillapp.consultapp.models.Mediopago;
import co.com.drillapp.consultapp.models.MediopagoPK;

@RestController
@RequestMapping("/mediopago")
public class MedioPagoRestController {

	private Logger log = LoggerFactory.getLogger(MedioPagoRestController.class);

	@Autowired
	private IDelegadoDeNegocio delegadoDeNegocio;

	@RequestMapping(value = "/get/{numeroTarjeta}/{identificacionCliente}/{tipoIdentificacionCliente}", method = RequestMethod.GET)
	public MediopagoDTO get(@PathVariable("numeroTarjeta") String numeroTarjeta,
			@PathVariable("identificacionCliente") String identificacionCliente,
			@PathVariable("tipoIdentificacionCliente") String tipoIdentificacionCliente) throws Exception {

		System.out.println(
				"Entro a get-----------------------------------------------------------------------------------------------------");
		try {
			Mediopago mediopago = delegadoDeNegocio
					.getMediopagoById(new MediopagoPK(numeroTarjeta, identificacionCliente, tipoIdentificacionCliente));
			if (mediopago == null) {
				throw new Exception("No existe Medio Pago");
			}
			return parseMediopago(mediopago);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(@RequestBody MediopagoDTO mediopagoDTO) throws Exception {
		System.out.println(
				"Entro a post-----------------------------------------------------------------------------------------------------");
		try {
			delegadoDeNegocio.saveMediopago(parseMediopagoDTO(mediopagoDTO));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	public void edit(@RequestBody MediopagoDTO mediopagoDTO) throws Exception {
		System.out.println(
				"Entro a put-----------------------------------------------------------------------------------------------------");
		try {
			delegadoDeNegocio.editMediopago(parseMediopagoDTO(mediopagoDTO));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@RequestMapping(value = "/delete/{numeroTarjeta}/{identificacionCliente}/{tipoIdentificacionCliente}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("numeroTarjeta") String numeroTarjeta,
			@PathVariable("identificacionCliente") String identificacionCliente,
			@PathVariable("tipoIdentificacionCliente") String tipoIdentificacionCliente) throws Exception {
		System.out.println(
				"Entro al delete-----------------------------------------------------------------------------------------------------");
		try {
			delegadoDeNegocio.deleteMediopago(new MediopagoPK(numeroTarjeta, identificacionCliente, tipoIdentificacionCliente));;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	public MediopagoDTO parseMediopago(Mediopago mediopago) {
		MediopagoDTO mediopagoDTO = new MediopagoDTO();
		mediopagoDTO.setNumeroTarjeta(mediopago.getMediopagoPK().getNumeroTarjeta());
		mediopagoDTO.setIdentificacionCliente(mediopago.getMediopagoPK().getIdentificacionCliente());
		mediopagoDTO.setTipoIdentificacionCliente(mediopago.getMediopagoPK().getTipoIdentificacionCliente());
		mediopagoDTO.setFechaCaducidad(mediopago.getFechaCaducidad());
		mediopagoDTO.setCodigoSeguridad(mediopago.getCodigoSeguridad());
		return mediopagoDTO;
	}

	public Mediopago parseMediopagoDTO(MediopagoDTO mediopagoDTO) {
		Mediopago mediopago = new Mediopago();
		MediopagoPK mediopagoPK = new MediopagoPK();
		mediopagoPK.setNumeroTarjeta(mediopagoDTO.getNumeroTarjeta());
		mediopagoPK.setIdentificacionCliente(mediopagoDTO.getIdentificacionCliente());
		mediopagoPK.setTipoIdentificacionCliente(mediopagoDTO.getTipoIdentificacionCliente());
		mediopago.setMediopagoPK(mediopagoPK);
		mediopago.setFechaCaducidad(mediopagoDTO.getFechaCaducidad());
		mediopago.setCodigoSeguridad(mediopagoDTO.getCodigoSeguridad());
		return mediopago;
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
