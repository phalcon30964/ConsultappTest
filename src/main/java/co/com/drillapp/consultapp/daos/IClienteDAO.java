package co.com.drillapp.consultapp.daos;

import co.com.drillapp.consultapp.models.Cliente;
import co.com.drillapp.consultapp.models.ClientePK;

public interface IClienteDAO {
	
	public void persist(Cliente obj) throws Exception;
	
	public void merge(Cliente obj) throws Exception;
	
	public void remove(ClientePK obj) throws Exception;
	
	public Cliente getById(ClientePK obj) throws Exception;
	
	public Cliente getByEmail(String email) throws Exception;

	public Cliente getByEmailPassword(String email, String password) throws Exception;

}
