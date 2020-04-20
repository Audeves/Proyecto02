
package Control;

import Repository.relProductoVentasRepository;
import objetosNegocio.relProductoVentas;


public class ControlRelacionProductoVentas {
    
    private relProductoVentasRepository relProductoVentasR;

    public ControlRelacionProductoVentas() {
        relProductoVentasR = new relProductoVentasRepository();
    }
    
    public void insertarRelacion(relProductoVentas relacion){
        relProductoVentasR.insertarRelacion(relacion);
    }

    
    
    
}
