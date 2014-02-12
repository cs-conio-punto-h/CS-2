package ED;

import java.util.LinkedList;
import java.util.List;

public class Stack<E> {
    
    //Atributos
    protected List<E> stack;

    //Constructor
    public Stack() {
        this.stack = new LinkedList<E>();
    }

    //Métodos
    public E top() {
        return this.stack.get(this.stack.size() - 1);
    }

    public void push(E e) {
        this.stack.add(e);
    }

    public E pop() {
        E remove = this.stack.remove(this.stack.size() - 1);
        return remove;
    }

    public int size() {
        return this.stack.size();
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }
    
    @Override
    public String toString () {
        String aux = "";
        /*for (int i = this.size() - 1; i > 0; i++) {
            aux =
        }*/
        for (E e: this.stack) {
            aux += e/* + aux*/;
        }
        return aux;
    }
    
    public String toString2 () {
        String aux = "";
        /*for (int i = this.size() - 1; i > 0; i++) {
            aux =
        }*/
        for (E e: this.stack) {
            aux = e + aux;
        }
        return aux;
    }
}
