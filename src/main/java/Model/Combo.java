/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.ArrayList;
/**
 *
 * @author derec
 */
public class Combo implements Icombo<Combo> {
    private Plato plato;
    private ArrayList<Bebida> bebida;
    private ArrayList<Adicional> adicional;
    
    public Combo(Plato pla,ArrayList<Bebida> beb, ArrayList<Adicional> adi){
        this.plato = pla;
        this.bebida = beb;
        this.adicional = adi;
    }
    public void setPlato(Plato p){
        this.plato = p;
    }
    public void setBebida(ArrayList<Bebida> b){
        this.bebida = b;
    }
    public void setAdicional(ArrayList<Adicional> a){
        this.adicional = a;
    }
    public Plato getPlato(){
        return this.plato;
    }
    public ArrayList<Bebida> getBebida(){
        return this.bebida ;
    }
    public ArrayList<Adicional> getAdicional(){
        return this.adicional;
    }
    
    @Override
    public Combo clone(){
        return new Combo(this.plato,this.bebida,this.adicional);
    }
    
    @Override
    public Combo deepClone(){
        return clone();
    }
}
