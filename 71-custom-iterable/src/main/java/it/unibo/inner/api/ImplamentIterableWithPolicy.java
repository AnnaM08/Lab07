package it.unibo.inner.api;

import java.util.Arrays;
import java.util.Iterator;

public class ImplamentIterableWithPolicy<T> implements IterableWithPolicy<T>{
    private int INITIAL = 0;/*primo elemento che deve iterare iterator*/
    private final T[] elements; /*List<T> elements; nel costruttore this.elements = List.of(vector) LISTA IMMUTABILE*/
    private Predicate<T> filter;
    
    /* costruttore a 1 arg:  con classe anonima*/
    public ImplamentIterableWithPolicy (T[] vector) {  
        this(vector, new Predicate<T>() {
            public boolean test(T x) {
                return true;
            }
        });
            //this.elements = Arrays.copyOf (vector , vector.length);
    }

    /* costruttore a 2 arg: */
    public ImplamentIterableWithPolicy(T[] vector, Predicate<T> filter) {
        this.elements = Arrays.copyOf(vector , vector.length);
        this.filter = filter;
    }
    public void setIterationPolicy(Predicate<T> filter) {
        
    }

    public Iterator<T> iterator() {
        return new IterableWithPolicyIterator(INITIAL);
    }
   
    private class IterableWithPolicyIterator implements Iterator<T> {/*se si vuole usare generico della outer class non mettere tipo generico della classe innestata perchè potrebbe essere diverso altrimenti*/
            
            private int current;

            IterableWithPolicyIterator(int current) {
                this.current = current;
            }
            public boolean hasNext() {
                return (this.current < elements.length);
            } 

            public T next() {
                return elements[this.current++];
            }
    }

    
}
