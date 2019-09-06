/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.ArrayList;

public class Combo implements Icombo<Combo> {
    
    private ArrayList<Producto> productos;
       
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
    
        ComboBuilder(String nombre,ArrayList<Producto> productos){

            super(productos);
        }

        public ComboBuilder(){

        }

        public ComboBuilder addPlato(String codigo, String nombre, float precio){
            super.getProductos().add((Producto) new Plato(codigo,nombre,precio));
            return this;
        }
        
        public ComboBuilder addAdicional(String codigo, String nombre, float precio){
            super.getProductos().add((Producto) new Adicional(codigo,nombre,precio));
            return this;
        }
        
        public ComboBuilder addBebida(String codigo, String nombre, float precio){
            super.getProductos().add((Producto) new Bebida(codigo,nombre,precio));
            return this;
        }

        @Override
        public Combo build() {
            return new Combo(super.getProductos());
        }

    }
}
