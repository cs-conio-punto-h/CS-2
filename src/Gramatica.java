import Symbols.V;
import Symbols.VN;
import Symbols.VT;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Gramatica {

    //Atributos.
    private Collection<VN> listaVN;
    private Collection<VT> listaVT;
    private Collection<Produccion> producciones;
    private VN simbInicial;
    private String path;

    //Constructores.
    public Gramatica(Collection<VN> listaVN, Collection<VT> listaVT, Collection<Produccion> producciones, VN simbInicial) {
        this.listaVN = listaVN;
        this.listaVT = listaVT;
        this.producciones = producciones;
        this.simbInicial = simbInicial;
    }

    
    public Gramatica(String path) {
        this.path = path;
        //Inicialización de variables.

        listaVN = new ArrayList<VN>();
        listaVT = new ArrayList<VT>();
        producciones = new ArrayList<Produccion>();
        simbInicial = new VN();

        //Lectura de fichero.

        LectorFichero lF = new LectorFichero(path);
        lF.analizarFichero(listaVN, listaVT, producciones, simbInicial);

    }

    //Getter & Setter.
    public Collection<VN> getListaVN() {
        return listaVN;
    }

    public void setListaVN(Collection<VN> listaVN) {
        this.listaVN = listaVN;
    }

    public Collection<VT> getListaVT() {
        return listaVT;
    }

    public void setListaVT(Collection<VT> listaVT) {
        this.listaVT = listaVT;
    }

    public Collection<Produccion> getProducciones() {
        return producciones;
    }

    public void setProducciones(Collection<Produccion> producciones) {
        this.producciones = producciones;
    }

    public VN getSimbInicial() {
        return simbInicial;
    }

    public void setSimbInicial(VN simbInicial) {
        this.simbInicial = simbInicial;
    }

    //Métodos.
    @Override
    public String toString() {
        return ("Lista de simbolos no terminales:\n" + listaVN.toString()
                + "\nLista de simbolos terminales:\n" + listaVT.toString()
                + "\nProducciones:\n" + mostrarProducciones()
                + "Simbolo inicial: " + simbInicial.toString());
    }

    private String mostrarProducciones() {
        String toReturn = "";
        for (Produccion p : producciones) {
            toReturn = toReturn + p.toString() + "\n";
        }
        return toReturn;
    }

    public Collection<Collection<V>> devolverConsecuentes(VN antecedente) {
        Collection<Collection<V>> cons = new ArrayList<Collection<V>>();
        for (Produccion p : producciones) {
            if (p.getAntecedente().equals(antecedente)) {
                cons.add(p.getConsecuente());
            }
        }
        return cons;
    }

    public Produccion obtenerProduccion(int n) {
        ArrayList<Produccion> oP = (ArrayList) this.producciones;
        return oP.get(--n);
    }

    public List<Produccion> obtenerProducionesConUnNoTerminalEnLosConsecuentes(VN v) {
        List<Produccion> l = new ArrayList<Produccion>();
        for (Produccion p : this.producciones) {
            if (p.getConsecuente().contains(v)) {
                l.add(p);
            }
        }
        return l;
    }
    
    
    public void addProduccion(int i, Produccion p) {
        ((ArrayList<Produccion>)this.producciones).add(i, p);
    }
    
    public void addVN (VN v) {
        this.listaVN.add(v);
    }
    
    public void addVT (VT v) {
        this.listaVT.add(v);
    }
    
    public String getPath() {
        return path;
    }
}
