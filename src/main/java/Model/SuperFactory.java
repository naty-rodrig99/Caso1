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
public class SuperFactory implements IcomboFactoryMethod{
    
    
    @Override
    public void createCombo(String type){       //que retorne Combo
        if(type.equals("predefinido")){
            //haga esto
        }
        if (type.equals("El otro")){
            //hacer esto
            //taki taki rumba
        }
        
        return;
    }
}
