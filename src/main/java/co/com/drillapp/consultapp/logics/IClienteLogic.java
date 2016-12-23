package co.com.drillapp.consultapp.logics;

import co.com.drillapp.consultapp.models.Cliente;
import co.com.drillapp.consultapp.models.ClientePK;

public interface IClienteLogic {
	    
    public void save(Cliente cliente) throws Exception;
    
    public Cliente getById(ClientePK clientePK) throws Exception;

    public Cliente getByEmailContrasena(String email, String contrasena) throws Exception;

    public void edit(Cliente cliente) throws Exception;

    public void delete(ClientePK clientePK) throws Exception;

}
