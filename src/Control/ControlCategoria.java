/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Repository.CategoriaRepository;
import java.util.List;
import objetosNegocio.Categoria;

/**
 *
 * @author Luis
 */
public class ControlCategoria {
    
    private CategoriaRepository categoriaR;
    
    public ControlCategoria() {
        categoriaR = new CategoriaRepository();
    }
    
    public void insertarCategoria(Categoria categoria) {
        categoriaR.insertarCategoria(categoria);
    }
    
    public void actualizarCategoria(Categoria categoria) {
        categoriaR.actualizarCategoria(categoria);
    }
    
    public boolean eliminarCategoria(Integer id){
       return categoriaR.eliminarCategoria(id);
    }
    
    public Categoria consultarCategoria(Integer id){
       return categoriaR.consultarCategoria(id);
    }
    
    public List<Categoria> consultarCategorias(String nombre){
       return categoriaR.consultarCategorias(nombre);
    }
    
}
