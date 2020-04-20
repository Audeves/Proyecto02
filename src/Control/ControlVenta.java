

package Control;

import Repository.VentaRepository;
import java.util.List;
import objetosNegocio.Venta;


public class ControlVenta {
    
   private VentaRepository ventaR;

    public ControlVenta() {
    
        ventaR = new VentaRepository();
    }
    
    public void insertarVenta(Venta venta){
        ventaR.insertarVenta(venta);
    }
    
    public void actualizarVenta(Venta venta){
        ventaR.actualizarVenta(venta);
    }
    
    public void eliminarVenta(Integer id){
        ventaR.eliminarVenta(id);
    }
    
    public Venta consultarVenta(Integer id){
       return ventaR.consultarVenta(id);
    }
    
    public List<Venta> consultarVentas(){
        return ventaR.consultarVentas();
    }
    
    public List<Venta> consultarVentasPorRango(String fechaInicio, String fechaFin, Integer id){
        return ventaR.consultarVentasPorRango(fechaInicio, fechaFin, id);
    }
    
    
    
}
