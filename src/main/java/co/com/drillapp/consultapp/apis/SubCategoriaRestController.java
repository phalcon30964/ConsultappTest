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
import co.com.drillapp.consultapp.dtos.SubcategoriaDTO;
import co.com.drillapp.consultapp.models.Categoria;
import co.com.drillapp.consultapp.models.Subcategoria;
import co.com.drillapp.consultapp.models.SubcategoriaPK;

@RestController
@RequestMapping("/subcategoria")
public class SubCategoriaRestController {
	
	private Logger log = LoggerFactory.getLogger(SubCategoriaRestController.class);
	
	@Autowired
	private IDelegadoDeNegocio delegadoDeNegocio;
	
	/**
	 * Metodo que se encarga de devolver el listado de todas las subtcategorias segun el Id de categoria padre.
	 * 
	 * 21474 CATEGORIAS POSIBLES, MAXIMO
	 * 100000 SUBCATEGORIAS POR CATEGORIA POSIBLES, MAXIMO
	 * @param idCat
	 * @return List<SubcategoriaDTO> subcategorias de la categoria padre
	 * @throws Exception No existen subcategorias para la categoria seleccionada
	 */
	@RequestMapping(value = "/getByCategoria/{idCategoria}", method = RequestMethod.GET)
	public List<SubcategoriaDTO> getByCategoria (@PathVariable("idCategoria") int idCat) throws Exception {
		System.out.println(
				"Entro a getByCategoria-----------------------------------------------------------------------------------------------------");
		List<Subcategoria> subcategorias = delegadoDeNegocio.getSubcategoriaByIdCategoria(idCat);
		if (subcategorias == null) {
			throw new Exception("No existen subcategorias para la categoria seleccionada");
		}
		List<SubcategoriaDTO> subcategoriasDTO = new ArrayList<SubcategoriaDTO>();
		for (int i = 0; i < subcategorias.size(); i++) {
			subcategoriasDTO.add(parseSubcategoria(subcategorias.get(i)));
		}
		return subcategoriasDTO;
	}
	
	/**
	 * Metodo que se encarga de devolver una subcategoria segun su id
	 * 
	 * 21474 CATEGORIAS POSIBLES, MAXIMO
	 * 100000 SUBCATEGORIAS POR CATEGORIA POSIBLES, MAXIMO
	 * @param idSubcat
	 * @return SubcategoriaDTO buscada.
	 * @throws Exception No existe la subcategoria
	 */
	@RequestMapping(value = "/get/{idCategoria}/{idSubcategoria}", method = RequestMethod.GET)
	public SubcategoriaDTO get (@PathVariable("idCategoria") int idCat,@PathVariable("idSubcategoria") int idSubcat) throws Exception {
		System.out.println(
				"Entro a get-----------------------------------------------------------------------------------------------------");
		Subcategoria subcategoria = delegadoDeNegocio.getSubcategoriaById(new SubcategoriaPK(idSubcat,idCat));
		if (subcategoria == null) {
			throw new Exception("No existe la subcategoria");
		}
		return parseSubcategoria(subcategoria);
	}
	
	/**
	 * Metodo que se encarga de guardar una subcategoria
	 * 
	 * @param subcategoriaDTO
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(@RequestBody SubcategoriaDTO subcategoriaDTO) throws Exception {
		System.out.println(
				"Entro a post-----------------------------------------------------------------------------------------------------");
		try {
			delegadoDeNegocio.saveSubcategoria(parseSubcategoriaDTO(subcategoriaDTO));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * Metodo que se encarga de editar unas subcategoria
	 * 
	 * @param subcategoriaDTO
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	public void edit(@RequestBody SubcategoriaDTO subcategoriaDTO) throws Exception {
		System.out.println(
				"Entro a put-----------------------------------------------------------------------------------------------------");
		try {
			delegadoDeNegocio.editSubcategoria(parseSubcategoriaDTO(subcategoriaDTO));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * Metodo que se encarga de borrar la sucategoria identificada por el id parametro
	 * @param idCat
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete/{idCategoria}/{idSubcategoria}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("idCategoria") int idCat,@PathVariable("idSubcategoria") int idSubcat) throws Exception {
		System.out.println(
				"Entro al delete-----------------------------------------------------------------------------------------------------");
		try {
			delegadoDeNegocio.deleteSubcategoriaById(new SubcategoriaPK(idSubcat,idCat));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}
	
	/**
	 * Metodo que se encarga de convertir un objeto subcategoria en un objeto subcategoriaDTO
	 * 
	 * @param subcategoria a convertir.
	 * @return SubcategoriaDTO
	 */
	public SubcategoriaDTO parseSubcategoria(Subcategoria subcategoria) {
		SubcategoriaDTO subcategoriaDTO = new SubcategoriaDTO();
		subcategoriaDTO.setIdCategoria(subcategoria.getSubcategoriaPK().getIdCategoria());
		subcategoriaDTO.setIdSubcategoria(subcategoria.getSubcategoriaPK().getIdSubcategoria());
		subcategoriaDTO.setNombreSubcategoria(subcategoria.getNombreSubcategoria());
		subcategoriaDTO.setDescripcion(subcategoria.getDescripcion());
		return subcategoriaDTO;
	}
	
	/**
	 * Metodo que se encarga de convertir un objeto subcategoriaDTO en un objeto subcategoria
	 * 
	 * @param SubcategoriaDTO a convertir.
	 * @return Subcategoria
	 */
	public Subcategoria parseSubcategoriaDTO(SubcategoriaDTO subcategoriaDTO) {
		Subcategoria subcategoria = new Subcategoria();
		SubcategoriaPK subcategoriaPK = new SubcategoriaPK();
		subcategoriaPK.setIdCategoria(subcategoriaDTO.getIdCategoria());
		subcategoriaPK.setIdSubcategoria(subcategoriaDTO.getIdSubcategoria());
		subcategoria.setSubcategoriaPK(subcategoriaPK);
		subcategoria.setNombreSubcategoria(subcategoriaDTO.getNombreSubcategoria());
		subcategoria.setDescripcion(subcategoriaDTO.getDescripcion());
		return subcategoria;
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
