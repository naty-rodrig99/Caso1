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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.ComboFactory;
import View.Vista;


public class Controlador implements ActionListener {
    public static ArrayList<String> comandos ;
    public static ArrayList<Combo> orden;
    public static Dictionary productos = new Hashtable(); 
    private Vista vista;
    
    
    public Controlador(Vista v){
        orden = new ArrayList();
        comandos = new ArrayList();
        initProductos();
        initPredefinidos();
        this.vista = v;
        this.vista.btnCombo1.addActionListener(this);
        this.vista.btnCombo2.addActionListener(this);
        this.vista.btnCombo3.addActionListener(this);
        this.vista.btnCombo4.addActionListener(this);
        this.vista.btnCombo5.addActionListener(this);
        this.vista.btnAdd.addActionListener(this);
        this.vista.btnCrear.addActionListener(this);
        this.vista.btnPapas.addActionListener(this);
        this.vista.btnPure.addActionListener(this);
        this.vista.btnTresleches.addActionListener(this);
        this.vista.btnCafe.addActionListener(this);
        this.vista.btnNatural.addActionListener(this);
        this.vista.btnGaseosa.addActionListener(this);
        this.vista.btnPollo.addActionListener(this);
        this.vista.btnPizza.addActionListener(this);
        this.vista.btnHamburguesa.addActionListener(this);
        this.vista.btnBorrar.addActionListener(this);
  
    }
    public void iniciarVista(){
    vista.setVisible(true);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== vista.btnCombo1 ){
            comandos.add("Combo 1");
        }
        else{
            if(e.getSource()== vista.btnCombo2 ){
                comandos.add("Combo 2");
            }
            if(e.getSource()== vista.btnCombo3 ){
                comandos.add("Combo 3");
            }
            if(e.getSource()== vista.btnCombo4){
                comandos.add("Combo 4");
            }
            if(e.getSource()== vista.btnCombo5 ){
                comandos.add("Combo 5");
            }
            if(e.getSource()== vista.btnPapas){
                comandos.add("papas");
            }
            if(e.getSource()== vista.btnPure ){
                comandos.add("pure");
            }
            if(e.getSource()== vista.btnTresleches){
                comandos.add("tres leches");
            }
            if(e.getSource()== vista.btnCafe){
                comandos.add("cafe");
            }
            if(e.getSource()== vista.btnNatural){
                comandos.add("natural");
            }
            if(e.getSource()== vista.btnGaseosa){
                comandos.add("gaseosa");
            }
            if(e.getSource()== vista.btnPizza){
                comandos.add("pizza");
            }
            if(e.getSource()== vista.btnPollo){
                comandos.add("pollo");
            }
            if(e.getSource()== vista.btnPapas){
                comandos.add("papas");
            }
            if(e.getSource()== vista.btnAdd){
                if(comandos.size()==1){
                    Controlador.agregarPredefinido(comandos.get(0));
                }
                else{
                    String name = comandos.get(0);
                    comandos.remove(0);
                    Controlador.agregarModificado(name, comandos);
                }
            }
            if(e.getSource() == vista.btnCrear){
                Controlador.agregarComboBuilder(comandos);
            }
            if(e.getSource() == vista.btnBorrar){
                comandos.clear();
                orden.clear();
                vista.jTextFactura.setText("");
            }
            if(e.getSource() == vista.btnTotal){
                String p = imprimirPrecios();
                vista.jTextFactura.setText(p);
            }
        }
        
        
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
    
    public static void agregarPredefinido(String nombre){          //pasa el nombre del combo predefinido y lo agrega a la orden
        orden.add((Combo)ComboFactory.getPrototype(nombre));
    }
    public static void agregarComboBuilder(ArrayList<String> nombreProducto){          //pasa el nombre del combo predefinido y lo agrega a la orden
        
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
    
    public static void agregarModificado(String nombreOriginal, ArrayList<String> agregar){
        Combo c = (Combo)(ComboFactory.getPrototype(nombreOriginal));
        ArrayList<Producto> productosCombo = c.getProductos();
        
        for(String nombre:agregar){
            Producto p = (Producto)(productos.get(nombre));
            productosCombo.add(p);
                
        }
        c.setProductos(productosCombo);
        orden.add(c);
    }
    public void limpiarOrden(){
        orden.clear();
    }
    
    public String imprimirPrecios(){
        String print="";
        int total=0;
        for(Combo c:orden){
           for(Producto p:c.getProductos()){
               print+="Nombre:"+p.getNombre()+"\nCodigo:"+p.getCodigo()+"\nPrecio:"+p.getPrecio()+"\n\n";
               total+=p.getPrecio();
           } 
        }
        print+="Total: "+total;
        return print;
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
        Vista vista = new Vista();
        Controlador controlador = new Controlador(vista);
        controlador.iniciarVista();

       
    }
    
    
}



