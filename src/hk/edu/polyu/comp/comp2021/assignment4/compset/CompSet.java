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
        if (elements == null) {
            throw new IllegalArgumentException();
        } 
        storage = new List[NUBMER_OF_BUCKETS];
        for (T element : elements) {
            if (!this.contains(element)) {
                int pos = getIndex(element);
                if (this.storage[pos] == null) {
                    storage[pos] = new ArrayList<T>();
                }
                storage[pos].add(element);
            }
        }
        
    }


    /**
     * Get the total number of elements stored in 'this'.
     */
    public int getCount() {
        int count=0;
        for (int i=0;i<NUBMER_OF_BUCKETS;i++){
            if (this.storage[i]!=null){
                count += this.storage[i].size();
            }
        }
        return count;
    }

    public boolean isEmpty() {
        int countEl =this.getCount();
        boolean isEmpty;
        if (countEl ==0){
            isEmpty= true;
        }
        else {
           isEmpty= false;
        }
        return isEmpty;
    }

    /**
     * Whether 'element' is contained in 'this'?
     */
    public boolean contains(T element) {
        if (element==null){
            return false;
        }
        int pos=this.getIndex(element);
        if (this.storage[pos]!=null){
            for (T elmt:storage[pos]){
                if (elmt==element){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Get all elements of 'this' as a list.
     */
    public List<T> getElements() {
        List<T> listElmt = new ArrayList<T>();
        for (int i=0;i<NUBMER_OF_BUCKETS;i++){
            if (this.storage[i]!=null){
                for (T elmt:storage[i]){
                    listElmt.add(elmt);
                }
            }
        }
        return listElmt;
    }

    /**
     * Add 'element' to 'this', if it is not contained in 'this' yet.
     * Throw IllegalArgumentException if 'element' is null.
     */
    public void add(T element) {
        if (element==null){
            throw new IllegalArgumentException();
        }
        if (!this.contains(element)) {
            int pos = getIndex(element);
            if (this.storage[pos] == null) {
                storage[pos] = new ArrayList<T>();
            }
            storage[pos].add(element);
        }

    }

    /**
     * Two CompSets are equivalent is they contain the same elements.
     * The order of the elements inside each CompSet is irrelevant.
     */
    public boolean equals(Object other){
        boolean isEqual=false;
        if (!(other ==null)){
            if(other.getClass()==getClass()){
                if (((CompSet<?>) other).isEmpty()&& this.isEmpty()){
                    isEqual= true;
                }
                List<T> listEl1=this.getElements();
                CompSet<T> other_Comp=(CompSet<T>) other;
                if( this.getCount()==other_Comp.getCount()){
                    for (T elmt: listEl1){
                        if(other_Comp.contains(elmt)){
                            isEqual=true;
                        }
                        else{
                            isEqual=false;
                        }
                    }
                }
            }
        }
        return isEqual;
    }

    /**
     * Remove 'element' from 'this', if it is contained in 'this'.
     * Throw IllegalArgumentException if 'element' is null.
     */
    public void remove (T element) {
        if (element==null){
            throw new IllegalArgumentException();
        }
        if (this.contains(element)) {
            int pos = getIndex(element);
            storage[pos].remove(element);
        }
    }

    //========================================================================== private methods

    private int getIndex(T element) {
        return element.hashCode() % NUBMER_OF_BUCKETS;
    }

}


