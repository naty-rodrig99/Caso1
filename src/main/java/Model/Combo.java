/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.ArrayList;

public class Combo implements Icombo<Combo> {
    
    private ArrayList<Producto> productos = new ArrayList<>();
       
    public Combo(ArrayList<Producto> pro){
       
        this.productos = pro;
    }

    public Combo() {
    }

    public void setProductos(ArrayList<Producto> pro){
        this.productos = pro;
    }
    public ArrayList<Producto> getProductos(){
        return this.productos ;
    }
    
    
    
    @Override
    public Combo clone(){
        return new Combo(this.productos);
    }
    
    @Override
    public Combo deepClone(){
        return clone();
    }
    
    public static class ComboBuilder extends Combo implements IBuilder<Combo>{
    
        public ComboBuilder(String nombre,ArrayList<Producto> productos){

            super(productos);
        }

        public ComboBuilder(){

        }

        public ComboBuilder addProducto(Producto prod){
            super.getProductos().add((prod));
            return this;
        }
        
        

        @Override
        public Combo build() {
            return new Combo(super.getProductos());
        }

    }
    
    
    
     public static void main(String args[]) {
        
       //ComboBuilder c1 = new Combo.ComboBuilder().addPlato("1", "gato encebollado", 2200).addBebida("2", "fresco", 500).addAdicional("1", "cebolla", 100).build();
       //Producto p = (Producto)(new Plato("P-01","Hamburguesa",1200));
       //System.out.println("hola");
       
    }
}
