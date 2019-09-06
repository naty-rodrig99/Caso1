/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author derec
 */
import java.util.HashMap;   

public class ComboFactory {
   
    private static HashMap<String,Icombo> prototypes = new HashMap<>();       
    
    
    public static Icombo getPrototype(String prototypeName){           
         
        return prototypes.get(prototypeName).clone(); 
    }       
    
   
    public static void addPrototype(String prototypeName,Icombo prototype){   
        prototypes.put(prototypeName, prototype);   
    }
}
