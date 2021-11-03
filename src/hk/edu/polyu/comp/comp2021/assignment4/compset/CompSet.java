package hk.edu.polyu.comp.comp2021.assignment4.compset;

import java.util.*;

class CompSet<T> {

    /** Each CompSet uses at most 1023 buckets.   */
    private static final int NUBMER_OF_BUCKETS = 1023;

    /** An array of buckets as the storage for each set. */
    private List<T>[] storage;

    public CompSet() {
        // Add missing code here
        storage = new List[NUBMER_OF_BUCKETS];
    }

    /**
     * Initialize 'this' with the unique elements from 'elements'.
     * Throw IllegalArgumentException if 'elements' is null.
     */
    public CompSet(List<T> elements) {
        // Add missing code here
        storage = new List[NUBMER_OF_BUCKETS];
        storage[0] = elements;
    }

    /**
     * Get the total number of elements stored in 'this'.
     */
    public int getCount() {
        // Add missing code here
        List<T> list = this.getElements();
        return list.size();
    }

    public boolean isEmpty() {
        List <T> list = this.getElements();
        return list.isEmpty();
    }

    /**
     * Whether 'element' is contained in 'this'?
     */
    public boolean contains(T element) {
        List <T> list = this.getElements();
        for (int i = 0; i< list.size();i++){
            if (list.get(i) == element ){
                return true;// Add missing code here
            }
        }
        return false;
    }

    /**
     * Get all elements of 'this' as a list.
     */
    public List<T> getElements() {
        List<T>[] a = new List[0];
        for (int i = 0; i<this.storage.length;i++){
            ;// Add missing code here
        }
        return null;
    }

    /**
     * Add 'element' to 'this', if it is not contained in 'this' yet.
     * Throw IllegalArgumentException if 'element' is null.
     */
    public void add(T element) {
        // Add missing code here

    }

    /**
     * Two CompSets are equivalent is they contain the same elements.
     * The order of the elements inside each CompSet is irrelevant.
     */
    public boolean equals(Object other){
        // Add missing code here
        return false;
    }

    /**
     * Remove 'element' from 'this', if it is contained in 'this'.
     * Throw IllegalArgumentException if 'element' is null.
     */
    public void remove (T element) {
        // Add missing code here

    }

    //========================================================================== private methods

    private int getIndex(T element) {
        return element.hashCode() % NUBMER_OF_BUCKETS;
    }

}


