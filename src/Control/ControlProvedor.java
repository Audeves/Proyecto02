package Control;

import Repository.ProvedorRepository;
import java.util.List;
import objetosNegocio.Provedor;

public class ControlProvedor {

    private ProvedorRepository provedorR;

    public ControlProvedor() {
        provedorR = new ProvedorRepository();
    }

    public void insertarProvedor(Provedor provedor) {
        provedorR.insertarProvedor(provedor);
    }

    public void actualizarProvedor(Provedor provedor) {
        provedorR.actualizarProvedor(provedor);
    }

    public boolean eliminarProvedor(Integer id) {
        return provedorR.eliminarProvedor(id);
    }

    public List<Provedor> consultarProvedores(String nombre) {
        return provedorR.consultarProvedores(nombre);
    }

    public Provedor consultarProvedor(Integer id) {
        return provedorR.consultarProvedor(id);
    }


    
}
