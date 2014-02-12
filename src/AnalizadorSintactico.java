import Symbols.VT;
import java.util.Collection;

public abstract class AnalizadorSintactico {
    protected Gramatica g;
    
    public AnalizadorSintactico (Gramatica g) {
        this.g = g;
    }
            
    public abstract boolean analizar(Collection<VT> cV);
}