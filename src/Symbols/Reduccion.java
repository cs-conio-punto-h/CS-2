/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbols;

/**
 *
 * @author Cristian
 */
public class Reduccion extends Move{
    
    public Reduccion (int estado) {
        super(estado);
    }
    
    public int getReduccion () {
        return super.getMove();
    }
    
    @Override
    public String toString () {
        return "R" + super.getMove();
    }
}