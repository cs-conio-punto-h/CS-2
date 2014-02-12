/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Symbols.V;
import Symbols.VN;
import Symbols.VT;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Cristian
 */        
public class Produccion {
    
    //Atributos.
    
    public VN antecedente;
    public List<V> consecuente;

    //Constructores.
    
    public Produccion(VN antecedente, List<V> consecuente) {
        this.antecedente = antecedente;
        this.consecuente = consecuente;
    }
    
    public Produccion(){
        this.antecedente = new VN("");
        this.consecuente = new ArrayList<V>();
    }
    
    //Getter & Setter.
    
    public VN getAntecedente() {
        return antecedente;
    }

    public void setAntecedente(VN antecedente) {
        this.antecedente = antecedente;
    }

    public List<V> getConsecuente() {
        return consecuente;
    }

    public void setConsecuente(List<V> consecuente) {
        this.consecuente = consecuente;
    }
    
    @Override
    public String toString () {
        String aux = "";
        for (V v : consecuente) {
            aux+=v + " ";
        }
        return antecedente + "::= " + aux;
    }
    
    @Override
    public boolean equals (Object o){
        Produccion p = null;
        try{
            p =(Produccion)o;
        } catch(ClassCastException c){
            System.err.println("Error de casteo.");
        }
        boolean consecuentesIguales = true;
        if (p.getConsecuente().size() != this.getConsecuente().size()) {
            consecuentesIguales=false;
        } else {
            for(int i = 0; i < this.getConsecuente().size(); i++) {
                if (!this.getConsecuente().get(i).equals(p.getConsecuente().get(i))) {
                    consecuentesIguales=false;
                }
            } 
        }
        return ( (this.getAntecedente().equals(p.getAntecedente())) && consecuentesIguales );
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.antecedente.hashCode();
        hash = 23 * hash + this.consecuente.hashCode();
        return hash;
    }
    
    @Override
    public Produccion clone(){
        return new Produccion(getAntecedente().clone(), clonarConsecuentes(getConsecuente()));
    }

    public List<V> clonarConsecuentes(List<V> consecuente) {
        List<V> toReturn = new ArrayList<V>();
        for(V cons: consecuente){
            if(cons instanceof VN){
                VN transf = (VN)cons;
                VN copia = transf.clone();
                toReturn.add(copia);
            } else {
                VT transf = (VT)cons;
                VT copia = transf.clone();
                toReturn.add(copia);
            }   
        }
        return toReturn;
    }
    
    
    public boolean consecuentesIguales (Collection<V> col) {
        boolean iguales = false;
        List<V> interno = (List<V>) consecuente;
        List<V> externo = (List<V>) col;
        for(int i = 0; i < interno.size(); i++) {
            try {
                if (!interno.get(i).equals(externo.get(i))) {
                    return false;
                }
            }
            catch (Exception ee) {
                return false;
            }
        }
        
        return true;
    }
    
    
      
}
