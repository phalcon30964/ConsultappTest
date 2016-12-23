package co.com.drillapp.consultapp.apis;

import java.util.ArrayList;
import java.util.List;

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
import co.com.drillapp.consultapp.dtos.CategoriaDTO;
import co.com.drillapp.consultapp.dtos.ErrorDTO;
import co.com.drillapp.consultapp.models.Categoria;

@RestController
@RequestMapping("/categoria")
public class CategoriaRestController {

	private Logger log = LoggerFactory.getLogger(CategoriaRestController.class);

	@Autowired
	private IDelegadoDeNegocio delegadoDeNegocio;
	
	
	/**
	 * Metodo que devuelve todas las categorias de la aplicacion
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getall")
	public List<CategoriaDTO> getall () throws Exception {
		System.out.println(
				"Entro a getall-----------------------------------------------------------------------------------------------------");
		List<Categoria> categorias = delegadoDeNegocio.getCategoriaAll();
		if (categorias == null) {
			throw new Exception("No existe la categoria");
		}
		List<CategoriaDTO> categoriasDTO = new ArrayList<CategoriaDTO>();
		for (int i = 0; i < categorias.size(); i++) {
			CategoriaDTO categoriaDTO = new CategoriaDTO();
			categoriaDTO.setIdCategoria(categorias.get(i).getIdCategoria());
			categoriaDTO.setNombreCategoria(categorias.get(i).getNombreCategoria());
			categoriaDTO.setDescripcion(categorias.get(i).getDescripcion());
			categoriasDTO.add(categoriaDTO);
		}
		return categoriasDTO;
	}
	
	/**
	 * Metodo que devuelve una categoria segun su id
	 * @param idCat
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/get/{idCategoria}", method = RequestMethod.GET)
	public CategoriaDTO get(@PathVariable("idCategoria") int idCat) throws Exception {
		System.out.println(
				"Entro a get-----------------------------------------------------------------------------------------------------");
		Categoria categoria = delegadoDeNegocio.getCategoriaById(idCat);
		if (categoria == null) {
			throw new Exception("No existe la categoria");
		}

		CategoriaDTO categoriaDTO = new CategoriaDTO();

		categoriaDTO.setIdCategoria(categoria.getIdCategoria());
		categoriaDTO.setNombreCategoria(categoria.getNombreCategoria());
		categoriaDTO.setDescripcion(categoria.getDescripcion());

		return categoriaDTO;
	}
	
	/**
	 * Metodo que guarda un categoria en la base de datos
	 * 
	 * @param categoriaDTO
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(@RequestBody CategoriaDTO categoriaDTO) throws Exception {
		System.out.println(
				"Entro a post-----------------------------------------------------------------------------------------------------");
		try {
			Categoria categoria = new Categoria();
			categoria.setIdCategoria(categoriaDTO.getIdCategoria());
			categoria.setNombreCategoria(categoriaDTO.getNombreCategoria());
			categoria.setDescripcion(categoriaDTO.getDescripcion());
			delegadoDeNegocio.saveCategoria(categoria);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * Metodo que se encarga de editar una categoriasegun su id
	 * 
	 * @param categoriaDTO
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	public void edit(@RequestBody CategoriaDTO categoriaDTO) throws Exception {
		System.out.println(
				"Entro a put-----------------------------------------------------------------------------------------------------");
		try {
			Categoria categoria = new Categoria();
			categoria.setIdCategoria(categoriaDTO.getIdCategoria());
			categoria.setNombreCategoria(categoriaDTO.getNombreCategoria());
			categoria.setDescripcion(categoriaDTO.getDescripcion());
			delegadoDeNegocio.editCategoria(categoria);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * Metodo que se encarga de borrar una categoriasegun su id
	 * 
	 * @param categoriaDTO
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete/{idCategoria}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("idCategoria") int idCat) throws Exception {
		System.out.println(
				"Entro al delete-----------------------------------------------------------------------------------------------------");
		try {
			delegadoDeNegocio.deleteCategoriaById(idCat);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}
	
	
	@RequestMapping("*")
	@ResponseBody
	public ErrorDTO fallbackMethod(){
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
