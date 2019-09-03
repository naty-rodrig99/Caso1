package Model;


public class Producto {
    private String codigo;
    private String nombre;
    private Float precio;
    
    public Producto(String cod,String nom,Float pre){
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
    public void setPrecio(Float pre){
        this.precio = pre;
    }
    public String getCodigo(){
        return this.codigo;
    }
    public String getNombre(){
        return this.nombre ;
    }
    public Float getPrecio(){
        return this.precio;
    }
            
}


