/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

public class ComboDefinidoList implements IComboDefinidoList,Icombo {
    private String comboName;
    private ArrayList<Producto> productos = new ArrayList(); 
    
    public ComboDefinidoList(String comboName, ArrayList<Producto> productos) {           
        this.comboName = comboName; 
        this.productos = productos;
    }              
    
    /** GET and SET */   
    public void setProducts(ArrayList<Producto> productos) {       
        this.productos = productos;
    }

    public void setListName(String comboName) {
        this.comboName= comboName;
    }

    public String getListName() {
        return comboName;
    }

    public ArrayList<Producto> getProducts() {
        return productos;
    }
    
    
    

    @Override
    public ComboDefinidoList clone() {
        ComboDefinidoList clone = 
                new ComboDefinidoList(comboName,productos);
        
        return clone;       
    }
    
    @Override
    public ComboDefinidoList deepClone() {
        ArrayList<Producto> cloneProducts = new ArrayList<>();
        for(Producto com : this.productos){
            Producto cloneItem = com.clone();
            cloneProducts.add(cloneItem);
        }
        ComboDefinidoList clone = new ComboDefinidoList(comboName,cloneProducts);
        
        return clone;
    }

 
    
    

    void addProductItem(Producto item) {
        productos.add(item);
    }

}
