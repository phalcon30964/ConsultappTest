package co.com.drillapp.consultapp.delegado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import co.com.drillapp.consultapp.logics.ICalificacionClienteLogic;
import co.com.drillapp.consultapp.logics.ICalificacionProfesionalLogic;
import co.com.drillapp.consultapp.logics.ICategoriaLogic;
import co.com.drillapp.consultapp.logics.IClienteLogic;
import co.com.drillapp.consultapp.logics.IConsultaLogic;
import co.com.drillapp.consultapp.logics.IMediopagoLogic;
import co.com.drillapp.consultapp.logics.IProfesionalLogic;
import co.com.drillapp.consultapp.logics.ISubcategoriaLogic;
import co.com.drillapp.consultapp.logics.ITituloLogic;
import co.com.drillapp.consultapp.logics.ITransaccionLogic;
import co.com.drillapp.consultapp.models.Categoria;
import co.com.drillapp.consultapp.models.Cliente;
import co.com.drillapp.consultapp.models.ClientePK;
import co.com.drillapp.consultapp.models.Mediopago;
import co.com.drillapp.consultapp.models.MediopagoPK;
import co.com.drillapp.consultapp.models.Subcategoria;
import co.com.drillapp.consultapp.models.SubcategoriaPK;

@Component("DelegadoDeNegocio")
@Scope("singleton")
public class CDelegadoDeNegocio implements IDelegadoDeNegocio {


	// @Autowired
	// private IConsultaLogic consultaLogic;

	// @Autowired
	// private IProfesionalLogic profesionalLogic;
	// @Autowired
	// private ITituloLogic tituloLogic;
	// @Autowired
	// private ITransaccionLogic transaccionLogic;
	@Autowired
	private IMediopagoLogic mediopagoLogic;
	@Autowired
	private IClienteLogic clienteLogic;
	@Autowired
	private ICategoriaLogic categoriaLogic;
	@Autowired
	private ISubcategoriaLogic subcategoriaLogic;
	
	//Medio Pago---------------------------------------------

	@Override
	public void saveMediopago(Mediopago mediopago) throws Exception {
		System.out.println(
				"Entro a delegado de negocio---------------------------------------------------------------------------");	
		mediopagoLogic.save(mediopago);
	}

	@Override
	public void editMediopago(Mediopago mediopago) throws Exception {
		System.out.println(
				"Entro a delegado de negocio---------------------------------------------------------------------------");
		mediopagoLogic.edit(mediopago);
	}

	@Override
	public void deleteMediopago(MediopagoPK mediopagoPk) throws Exception {
		System.out.println(
				"Entro a delegado de negocio---------------------------------------------------------------------------");
		mediopagoLogic.delete(mediopagoPk);
	}

	@Override
	public Mediopago getMediopagoById(MediopagoPK mediopagoPk) throws Exception {
		System.out.println(
				"Entro a delegado de negocio---------------------------------------------------------------------------");
		return mediopagoLogic.getById(mediopagoPk);
	}

	
	//Cliente---------------------------------------------

	@Override
	public void saveCliente(Cliente cliente) throws Exception {
		System.out.println(
				"Entro a delegado de negocio---------------------------------------------------------------------------");
		clienteLogic.save(cliente);		
	}

	@Override
	public void editCliente(Cliente cliente) throws Exception {
		System.out.println(
				"Entro a delegado de negocio---------------------------------------------------------------------------");
		clienteLogic.edit(cliente);	
	}

	@Override
	public void deleteCliente(ClientePK clientePK) throws Exception {
		System.out.println(
				"Entro a delegado de negocio---------------------------------------------------------------------------");
		clienteLogic.delete(clientePK);
	}

	@Override
	public Cliente getClienteById(ClientePK clientePK) throws Exception {
		System.out.println(
				"Entro a delegado de negocio---------------------------------------------------------------------------");
				return clienteLogic.getById(clientePK);
	}

	@Override
	public Cliente getClienteByEmailContrasena(String email, String password) throws Exception {
		System.out.println(
				"Entro a delegado de negocio---------------------------------------------------------------------------");
				return clienteLogic.getByEmailContrasena(email, password);
	}

	//Categoria---------------------------------------------

	@Override
	public void saveCategoria(Categoria categoria) throws Exception {
		System.out.println(
				"Entro a delegado de negocio---------------------------------------------------------------------------");
		categoriaLogic.save(categoria);
	}

	@Override
	public void editCategoria(Categoria categoria) throws Exception {
		System.out.println(
				"Entro a delegado de negocio---------------------------------------------------------------------------");
		categoriaLogic.edit(categoria);
	}
	
	@Override
	public void deleteCategoriaById(int id) throws Exception {
		System.out.println(
				"Entro a delegado de negocio---------------------------------------------------------------------------");
		categoriaLogic.deleteById(id);
	}

	@Override
	public Categoria getCategoriaById(int id) throws Exception {
		System.out.println(
				"Entro a delegado de negocio---------------------------------------------------------------------------");
		return categoriaLogic.getById(id);
	}

	@Override
	public List<Categoria> getCategoriaAll() throws Exception {
		System.out.println(
				"Entro a delegado de negocio---------------------------------------------------------------------------");
		return categoriaLogic.getAll();
	}

	
	//Subcategoria----------------------------------------------

	@Override
	public void saveSubcategoria(Subcategoria subcategoria) throws Exception {
		System.out.println(
				"Entro a delegado de negocio---------------------------------------------------------------------------");
		subcategoriaLogic.save(subcategoria);

	}

	@Override
	public void editSubcategoria(Subcategoria subcategoria) throws Exception {
		System.out.println(
				"Entro a delegado de negocio---------------------------------------------------------------------------");
		subcategoriaLogic.edit(subcategoria);
		
	}

	@Override
	public void deleteSubcategoriaById(SubcategoriaPK subcategoriaPK) throws Exception {
		System.out.println(
				"Entro a delegado de negocio---------------------------------------------------------------------------");
		subcategoriaLogic.deleteById(subcategoriaPK);
		
	}

	@Override
	public Subcategoria getSubcategoriaById(SubcategoriaPK subcategoriaPK) throws Exception {
		System.out.println(
				"Entro a delegado de negocio---------------------------------------------------------------------------");
		return subcategoriaLogic.getById(subcategoriaPK);
	}

	@Override
	public List<Subcategoria> getSubcategoriaByIdCategoria(int idCat) throws Exception {
		System.out.println(
				"Entro a delegado de negocio---------------------------------------------------------------------------");
		return subcategoriaLogic.getByIdCategoria(idCat);
	}







}
