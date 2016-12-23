package co.com.drillapp.consultapp.delegado;

import java.util.List;

import co.com.drillapp.consultapp.models.Categoria;
import co.com.drillapp.consultapp.models.Cliente;
import co.com.drillapp.consultapp.models.ClientePK;
import co.com.drillapp.consultapp.models.Mediopago;
import co.com.drillapp.consultapp.models.MediopagoPK;
import co.com.drillapp.consultapp.models.Subcategoria;
import co.com.drillapp.consultapp.models.SubcategoriaPK;

public interface IDelegadoDeNegocio{
	
//	 	public void saveCliente(Cliente cliente) throws Exception;
//	    
//		public Cliente getByIdCliente(String identificacion, String tipoDoc) throws Exception;
//
//	    public Cliente getByEmailContrasenaCliente(String email, String contrasena) throws Exception;
//
//	    public void editCliente(Cliente cliente) throws Exception;
//
//	    public void deleteCliente(Cliente cliente) throws Exception;
//	    
//	    public void saveMedioPago(Mediopago mediopago) throws Exception;
//
//	    public void editMedioPago(Mediopago mediopago) throws Exception;
//
//	    public void deleteMedioPago(Mediopago mediopago) throws Exception;
//
//	    public Mediopago getByIdMedioPago(String numeroTarjeta, String identificacionCliente, String tipoIdentificacionCliente) throws Exception;
	
		//Medio Pago---------------------------------------------

		public void saveMediopago(Mediopago mediopago) throws Exception;
	
		public void editMediopago(Mediopago mediopago) throws Exception;
	
		public void deleteMediopago(MediopagoPK mediopagoPk) throws Exception;
	
		public Mediopago getMediopagoById(MediopagoPK mediopagoPk) throws Exception;

		//Cliente---------------------------------------------
		
		public void saveCliente(Cliente cliente) throws Exception;
		
		public void editCliente(Cliente cliente) throws Exception;
		
		public void deleteCliente(ClientePK clientePK) throws Exception;
		
		public Cliente getClienteById(ClientePK clientePK) throws Exception;
		
		public Cliente getClienteByEmailContrasena(String email, String password) throws Exception;
		
		//Categoria---------------------------------------------
	
		public void saveCategoria(Categoria categoria) throws Exception;

	    public void editCategoria(Categoria categoria) throws Exception;
	    
	    public void deleteCategoriaById(int id) throws Exception;

	    public Categoria getCategoriaById(int id) throws Exception;
	    
	    public List<Categoria> getCategoriaAll() throws Exception;
	    
		//Subcategoria----------------------------------------------
	 	public void saveSubcategoria(Subcategoria subcategoria) throws Exception;

	    public void editSubcategoria(Subcategoria subcategoria) throws Exception;
	    
	    public void deleteSubcategoriaById(SubcategoriaPK subcategoriaPK) throws Exception;
	    
	    Subcategoria getSubcategoriaById(SubcategoriaPK subcategoriaPK) throws Exception;

	    public List<Subcategoria> getSubcategoriaByIdCategoria(int idCat) throws Exception;
	    

}
