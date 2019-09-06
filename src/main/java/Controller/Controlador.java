/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.util.*;
import Model.ComboDefinidoList;
import Model.Plato;
import Model.Producto;
import Model.Bebida;
import Model.Adicional;
import Model.Combo;
import Model.Combo.ComboBuilder;

import Model.ComboFactory;


public class Controlador {
    public static ArrayList orden;
    public static Dictionary productos = new Hashtable(); 
    
    
    public Controlador(){
        orden = new ArrayList();
        initProductos();
        initPredefinidos();
        
        
        
    }
    
    
    public void initPredefinidos(){
        ArrayList<Producto> prod1 = new ArrayList<>();
        ArrayList<Producto> prod2 = new ArrayList<>();
        ArrayList<Producto> prod3 = new ArrayList<>();
        ArrayList<Producto> prod4 = new ArrayList<>();
        ArrayList<Producto> prod5 = new ArrayList<>();

        prod1.add((Producto)productos.get("hamburguesa"));
        prod1.add((Producto)productos.get("gaseosa"));
        prod1.add((Producto)productos.get("papas"));
        
        prod2.add((Producto)productos.get("pollo"));
        prod2.add((Producto)productos.get("gaseosa"));
        prod2.add((Producto)productos.get("papas"));
        
        prod3.add((Producto)productos.get("papas"));
        prod3.add((Producto)productos.get("gaseosa"));
        prod3.add((Producto)productos.get("pure"));
        
        prod4.add((Producto)productos.get("pizza"));
        prod4.add((Producto)productos.get("gaseosa"));
        
        prod5.add((Producto)productos.get("pizza"));
        prod5.add((Producto)productos.get("gaseosa"));
        prod5.add((Producto)productos.get("ensalada"));
        prod5.add((Producto)productos.get("tres leches"));
        
        ComboDefinidoList combo1 = new ComboDefinidoList(prod1);            //List Implementation de Prototype
        ComboDefinidoList combo2 = new ComboDefinidoList(prod2);
        ComboDefinidoList combo3 = new ComboDefinidoList(prod3);
        ComboDefinidoList combo4 = new ComboDefinidoList(prod4);
        ComboDefinidoList combo5 = new ComboDefinidoList(prod5);
        
        ComboFactory.addPrototype("Combo 1", combo1);           //Agrega en Factory de prototypes
        ComboFactory.addPrototype("Combo 2", combo2);
        ComboFactory.addPrototype("Combo 3", combo3);
        ComboFactory.addPrototype("Combo 4", combo4);
        ComboFactory.addPrototype("Combo 5", combo5);
        
    }
    
    public void agregarPredefinido(String nombre){          //pasa el nombre del combo predefinido y lo agrega a la orden
        orden.add(ComboFactory.getPrototype(nombre));
    }
    public void agregarComboBuilder(ArrayList<String> nombreProducto){          //pasa el nombre del combo predefinido y lo agrega a la orden
        
        ArrayList <Producto> listaProductos = new ArrayList();
        for(String nombre:nombreProducto){
            Producto p = (Producto)(productos.get(nombre));
            listaProductos.add(p);
                
        }
        ComboBuilder combo = new Combo.ComboBuilder();
        for(Producto prod:listaProductos){
            combo.addProducto(prod);

        }
        combo.build();
        orden.add(combo);
        
    }
    
    public void agregarModificado(String nombreOriginal, ArrayList<String> agregar){
        Combo c = (Combo)(ComboFactory.getPrototype(nombreOriginal));
        ArrayList<Producto> productosCombo = c.getProductos();
        
        for(String nombre:agregar){
            Producto p = (Producto)(productos.get(nombre));
            productosCombo.add(p);
                
        }
        c.setProductos(productosCombo);
        orden.add(c);
    }
    
    
    public void initProductos(){
        productos.put("hamburguesa",(Producto)(new Plato("P-01","Hamburguesa",1200)));
        productos.put("gaseosa",(Producto)(new Bebida("B-01","Gaseosa",1150)));
        productos.put("papas",(Producto)(new Adicional("A-01","Papas",1000)));
        productos.put("cafe",(Producto)(new Bebida("B-02","Cafe",700)));
        productos.put("natural",(Producto)(new Bebida("B-03","Natural",800)));
        productos.put("pollo",(Producto)(new Plato("P-02","Pollo",1100)));
        productos.put("pure",(Producto)(new Adicional("A-02","Pure",600)));
        productos.put("pizza",(Producto)(new Plato("P-03","Pizza",1200)));
        productos.put("tres leches",(Producto)(new Adicional("A-03","Tres Leches",1500)));
        productos.put("ensalada",(Producto)(new Adicional("A-04","Ensalada",1400)));
        productos.put("hot dog",(Producto)(new Plato("P-04","Hot Dog",1000)));
        
        
    }
    
    
    
    
    public static void main(String args[]) {
        

       
    }
    
    
}



