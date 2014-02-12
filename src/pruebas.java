import Symbols.VT;
import java.io.File;
import java.util.Collection;
import java.util.LinkedList;

public class pruebas {

    private static final String desktop = "C:" + File.separator + "Users"
            + File.separator + System.getProperty("user.name") + File.separator + "Dropbox" + File.separator + "PL Practica" + File.separator + "Java (PRACTICA)" + File.separator;

    private static String devCadena(Collection<VT> c) {
        String aux = "";
        for (VT v : c) {
            aux += v.toString();
        }
        return aux;
    }

    private static Collection<VT> devColeccion(String... cadena) {
        Collection<VT> col = new LinkedList<VT>();
        for (String s : cadena) {
            col.add(new VT(s));
        }
        return col;
    }

    public static void main(String[] args) {
        Gramatica g = new Gramatica(desktop + "Gramatica_PR8.txt");
        AnalizadorAscendenteLR asLL = new AnalizadorAscendenteLR(g);
        Collection<VT> cadena = devColeccion("id","+","id","*","(","id","+","id",")","$");
        boolean analizar = asLL.analizar(cadena);
        System.out.print("La cadena " + devCadena(cadena));
        if (!analizar) {
            System.out.print(" no");
        }
        else {
            System.out.print(" SI");
        }
        System.out.println(" ha sido reconocida");
    }
}
