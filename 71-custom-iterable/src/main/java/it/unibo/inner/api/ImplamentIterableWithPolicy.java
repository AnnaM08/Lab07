package it.unibo.inner.api;

import java.util.Arrays;
import java.util.Iterator;

public class ImplamentIterableWithPolicy<T> implements IterableWithPolicy<T>{
    
    private /*why not static*/ T[] elements;
    /* costruttore: */
    public ImplamentIterableWithPolicy (T[] vector) {
            this.elements = Arrays.copyOf (vector , vector.length);
    }

    public void setIterationPolicy(Predicate<T> filter) {
        
    }

    public Iterator<T> iterator() {
        return new this.IterableWithPolicyIterator();
    }
   
    private static class IterableWithPolicyIterator<T> implements Iterator<T> {
            public boolean hasNext() {

            } 
    }

    
}
