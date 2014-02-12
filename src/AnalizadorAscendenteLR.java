import java.util.Collection;
import java.util.LinkedList;

import ED.Stack;
import Symbols.Aceptado;
import Symbols.Desplazamiento;
import Symbols.Reduccion;
import Symbols.VN;
import Symbols.VT;

/**
 *
 * @author Cristian
 */
public class AnalizadorAscendenteLR extends AnalizadorSintactico {
    private final Stack<Integer> stack;
    private int contador;
    private final ConfiguracionLR tabla;
    private LinkedList<VT> cV;
    
    public AnalizadorAscendenteLR(Gramatica g) {
        super(g);
        stack = new Stack<Integer>();
        contador = 0;
        tabla = new ConfiguracionLR();
        System.out.println(tabla);
    }

    @Override
    public boolean analizar(Collection<VT> c) {
        this.cV = (LinkedList)((LinkedList)c).clone();
        boolean salida = false;
        contador = cV.size();
        stack.push(0);   //Empezamos en el estado 0
        VT a = this.siguienteVT();
        int estadoActual = 0;
        System.out.println("EJECUCIÓN:");
        while (true) {
            estadoActual = stack.top();
            Object accion = null;
            try {
                accion = accion(estadoActual, a);
            }
            catch (Exception e) {
                System.out.println("");
                return false;
            }
            System.out.print(accion + " -->");
            if (accion instanceof Desplazamiento) {
                stack.push(((Desplazamiento) accion).getDesplazamiento());
                a = this.siguienteVT();
            }
            else if (accion instanceof Reduccion) {
                int nProduccion = ((Reduccion) accion).getReduccion();
                Produccion p = g.obtenerProduccion(nProduccion);
                int borrar = p.getConsecuente().size();
                for (int b = 0; b < borrar; b++) {
                    stack.pop();
                }
                int go_to = GOTO(stack.top(), p.getAntecedente());
                stack.push(go_to);
            }
            else if (accion instanceof Aceptado) {
                salida = true;
                break;
            }
            else {
                salida = false;
                break;
            }
            System.out.println("PILA: " + stack + "   CADENA: " + cV);
        }
        System.out.println("");
        return salida;
    }

    private VT siguienteVT() {
        if (cV.size() > 0) {
            VT v = cV.getFirst();
            cV.remove();
            return v;
        }
        else {
            return null;
        }
    }

    private Object accion(int estado, VT v) {
        return this.tabla.obtenerAccion(estado, v, g.getListaVT());
    }
    
    private int GOTO (int estado, VN A) {
        return this.tabla.obtenerGOTO(estado, A, g.getListaVN());
    }
}
