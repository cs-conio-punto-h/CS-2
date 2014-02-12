/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Symbols.VN;
import Symbols.VT;
import Symbols.Aceptado;
import Symbols.Desplazamiento;
import Symbols.Reduccion;
import java.util.Collection;

/**
 *
 * @author Cristian
 */
public class ConfiguracionLR {
    protected Object [][] tablaAccion;
    protected int[][] tablaGoto;
    
    public ConfiguracionLR () {
        this.tablaAccion = new Object[12][6];
        this.rellenarTablaAccion();
        this.tablaGoto = new int [12][3];
        this.rellenarTablaGoto();
    }

    private void rellenarTablaAccion() {
        tablaAccion[0][0] = new Desplazamiento(5);
        tablaAccion[0][3] = new Desplazamiento(4);
        
        tablaAccion[1][1] = new Desplazamiento(6);
        tablaAccion[1][5] = new Aceptado();//"Aa";
        
        tablaAccion[2][1] = new Reduccion(2);
        tablaAccion[2][2] = new Desplazamiento(7);
        tablaAccion[2][4] = new Reduccion(2);
        tablaAccion[2][5] = new Reduccion(2);
        
        tablaAccion[3][1] = new Reduccion(4);
        tablaAccion[3][2] = new Reduccion(4);
        tablaAccion[3][4] = new Reduccion(4);
        tablaAccion[3][5] = new Reduccion(4);
        
        tablaAccion[4][0] = new Desplazamiento(5);
        tablaAccion[4][3] = new Desplazamiento(4);
        
        tablaAccion[5][1] = new Reduccion(6);
        tablaAccion[5][2] = new Reduccion(6);
        tablaAccion[5][4] = new Reduccion(6);
        tablaAccion[5][5] = new Reduccion(6);
        
        tablaAccion[6][0] = new Desplazamiento(5);
        tablaAccion[6][3] = new Desplazamiento(4);
        
        tablaAccion[7][0] = new Desplazamiento(5);
        tablaAccion[7][3] = new Desplazamiento(4);
        
        tablaAccion[8][1] = new Desplazamiento(6);
        tablaAccion[8][4] = new Desplazamiento(11);
        
        tablaAccion[9][1] = new Reduccion(1);
        tablaAccion[9][2] = new Desplazamiento(7);
        tablaAccion[9][4] = new Reduccion(1);
        tablaAccion[9][5] = new Reduccion(1);
        
        tablaAccion[10][1] = new Reduccion(3);
        tablaAccion[10][2] = new Reduccion(3);
        tablaAccion[10][4] = new Reduccion(3);
        tablaAccion[10][5] = new Reduccion(3);
        
        tablaAccion[11][1] = new Reduccion(5);
        tablaAccion[11][2] = new Reduccion(5);
        tablaAccion[11][4] = new Reduccion(5);
        tablaAccion[11][5] = new Reduccion(5);
        
    }
    
    private void rellenarTablaGoto () {
        
        tablaGoto[0][0] = 1;
        tablaGoto[0][1] = 2;
        tablaGoto[0][2] = 3;
        
        tablaGoto[4][0] = 8;
        tablaGoto[4][1] = 2;
        tablaGoto[4][2] = 3;
        
        tablaGoto[6][1] = 9;
        tablaGoto[6][2] = 3;
        
        tablaGoto[7][2] = 10;
        
    }
    
    @Override
    public String toString () {
        String aux = "Estado |           Acción            ||     Goto   \n";
        aux+=        "-------| id |  + |  * |  ( |  ) |  $ || E || T || F |\n";
        aux+=        "-----------------------------------------------------\n";
        for (int i = 0; i < 12; i++) {
            aux+=    "   " + i + "  " ;
            if(i < 10) {
                aux+=" ";
            }
            aux+="|";
            //Tabla Accion
            for (int j = 0; j < 6; j++) {
                if(tablaAccion[i][j] == null) {
                    aux+= "    |";
                }
                else {
                    if (tablaAccion[i][j].toString().length() < 3) {
                        aux += " " + tablaAccion[i][j] + " |";
                    }
                    else {
                        aux += " " + tablaAccion[i][j] + "|";
                    }
                }
            }
            //Tabla Goto
            for (int j = 0; j < 3; j++) {
                aux+="|";
                if(tablaGoto[i][j] == 0) {
                    aux+= "   |";
                }
                else {
                    if (tablaGoto[i][j] < 10) {
                        aux += " " + tablaGoto[i][j] + " |";
                    }
                    else {
                        aux += " " + tablaGoto[i][j] + "|";
                    }
                }
            }
            aux+="\n";
        }   
        return aux;
    }

    Object obtenerAccion(int estado, VT v, Collection<VT> listaVT) {
        String dato = v.getV();
        int i = 0;
        for(VT vv : listaVT) {
            if (dato.compareTo(vv.getV()) == 0) {
                return this.tablaAccion[estado][i];
            }
            i++;
        }
        return null;
    }

    int obtenerGOTO(int estado, VN A, Collection<VN> listaVN) {
        String dato = A.getV();
        int i = 0;
        for(VN vv : listaVN) {
            if (vv.getV().compareTo(dato) == 0) {
                break;
            }
            else {
                i++;
            }
        }
        return this.tablaGoto[estado][i];
    }
}
