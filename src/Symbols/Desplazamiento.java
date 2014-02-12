/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbols;

/**
 *
 * @author Cristian
 */
public class Desplazamiento extends Move{
    
    public Desplazamiento(int estado) {
        super(estado);
    }
    
    public int getDesplazamiento () {
        return super.getMove();
    }
    
    @Override
    public String toString() {
        return "D" + super.getMove();
    }
}
