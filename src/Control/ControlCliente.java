
package Control;

import Repository.ClienteRepository;
import java.util.List;
import objetosNegocio.Cliente;


public class ControlCliente {
    
    private ClienteRepository clienteR;

    public ControlCliente() {
        clienteR = new ClienteRepository();
    }
    
    public void insertarCliente(Cliente cliente){
        clienteR.insertarCliente(cliente);
    }
    
    public void actualizarCliente(Cliente cliente){
        clienteR.actualizarCliente(cliente);
    }
    
    public boolean eliminarCliente(Integer id){
        return clienteR.eliminarCliente(id);
    }
    
    public List<Cliente> consultarClientes(String nombre){
        return clienteR.consultarClientes(nombre);
    
    }
    
    public Cliente consultarCliente(Integer id){
        return clienteR.consultarCliente(id);
    }
    
    
    
}
