/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Symbols;

/**
 *
 * @author Cristian
 */
public class Move {
    protected final int estado;
    
    public Move(int estado) {
        this.estado = estado;
    }
    
    public int getMove () {
        return estado;
    }
}
