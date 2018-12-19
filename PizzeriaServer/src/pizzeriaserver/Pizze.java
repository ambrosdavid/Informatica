/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzeriaserver;

import java.util.HashMap;

/**
 *
 * @author David
 */
class Pizze {
    
    HashMap<String, Double> pizze=new HashMap<>();
    
    public Pizze(){
        
    }
    
    public void aggiungiPizza(String nome, Double costo){
        pizze.put(nome, costo);
    }
    
    public double ricavaCosto(String nome){
        
        return pizze.get(nome);
    }
    
}
