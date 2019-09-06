package Model;


public class Producto implements Icombo {
    private String codigo;
    private String nombre;
    private int precio;
    
    public Producto(String cod,String nom,int pre){
        this.codigo= cod;
        this.nombre= nom;
        this.precio= pre;
        
    }
    public void setCodigo(String cod){
        this.codigo = cod;
    }
    public void setNombre(String nom){
        this.nombre = nom;
    }
    public void setPrecio(int pre){
        this.precio = pre;
    }
    public String getCodigo(){
        return this.codigo;
    }
    public String getNombre(){
        return this.nombre ;
    }
    public int getPrecio(){
        return this.precio;
    }
     @Override
    public Producto clone() {
        return new Producto(this.codigo,this.nombre, this.precio);
    }
    
    @Override
    public Producto deepClone() {
        return clone();  
    }
    
    
            
}


