package ua.hillel.a_sapon.HomeWork.Task4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class MyMap<E> implements Collection {

    private Node<E> head;
    private int hashArraySize;
    private ArrayList<Node> [] hashArrayList;

    private static class Node<T>{
        private T value;
        private T key;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(value, node.value) &&
                    Objects.equals(key, node.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

        public Node(T value, T key) {
            this.value = value;
            this.key = key;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", key=" + key +
                    '}';
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void setKey(T key) {
            this.key = key;
        }

        public T getValue() {
            return value;
        }

        public T getKey() {
            return key;
        }
    }

    public MyMap() {
        this(1000);
    }

    public MyMap(int hashArraySize) {
        this.hashArraySize = hashArraySize;
        this.head = null;
        hashArrayList = new ArrayList[hashArraySize];
    }

    public MyMap(E[] array)  {
        this(1000);
        for(E e : array) {
            this.add(e);
        }
    }

    /**
     * Returns the number of elements in this collection.
     */
    @Override
    public int size() {
        int counter =0;
        for (int i=0;i<hashArrayList.length;i++){
            if(hashArrayList[i].size() > 0) {++counter;}
        }
        return 0;
    }

    /**
     * Returns {@code true} if this collection contains no elements.
     */
    @Override
    public boolean isEmpty() {
        return (this.size()>0);
    }

    /**
     * Returns {@code true} if this collection contains the specified element.
     * More formally, returns {@code true} if and only if this collection
     * contains at least one element {@code e} such that
     * {@code Objects.equals(o, e)}.
     * @return {@code true} if this collection contains the specified
     *         element
     */
    @Override
    public boolean contains(Object o) {
        for(int i=0;i<hashArrayList.length;i++){
            for(Node node: hashArrayList[i]){
                if( node.getValue().equals(o) ){return true;}
                else {}
            }
        }return false;
    }

    public boolean contains(Object o, Object k) {
        int hash = k.hashCode();
        int pointer = hash % hashArrayList.length;
        if(hashArrayList[pointer].size() > 0) {
            for (Node node : hashArrayList[pointer]) {
                if (node.getValue().equals(o)) {
                    return true;
                } else {
                }
            }
        }
        return false;
    }

    /**
     * Returns an iterator over the elements in this collection.  There are no
     * guarantees concerning the order in which the elements are returned
     * (unless this collection is an instance of some class that provides a
     * guarantee).
     *
     * @return an {@code Iterator} over the elements in this collection
     */
    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };
    }

    /**
     * Returns an array containing all of the elements in this collection.
     * If this collection makes any guarantees as to what order its elements
     * are returned by its iterator, this method must return the elements in
     * the same order. The returned array's {@linkplain Class#getComponentType
     * runtime component type} is {@code Object}.
     */
    @Override
    public Object[] toArray() {
        ArrayList resultArraylist = new ArrayList();
        for (int i=0;i<hashArrayList.length;i++){
            if(hashArrayList[i].size()>0){
                resultArraylist.addAll(hashArrayList[i]);
            }
            else{
            }
        }
        return resultArraylist.toArray();
    }

    /**
     * Returns an array containing all of the elements in this collection;
     * the runtime type of the returned array is that of the specified array.
     * If the collection fits in the specified array, it is returned therein.
     * Otherwise, a new array is allocated with the runtime type of the
     * specified array and the size of this collection.
     */
    @Override
    public boolean add(Object o) {
        if(o != null) {
            add(o,o);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Returns an array containing all of the elements in this collection;
     * the runtime type of the returned array is that of the specified array.
     * If the collection fits in the specified array, it is returned therein.
     * Otherwise, a new array is allocated with the runtime type of the
     * specified array and the size of this collection.
     */
    public boolean add(Object o, Object k) {
        if( o != null){
               Node<E> node = new Node<E>((E)o,(E)k);
               int hash = k.hashCode();
               int pointer = (int)(hash % hashArrayList.length);
               if(hashArrayList[pointer].size() > 0){
                    for(Node n : hashArrayList[pointer]){
                        if ( n.equals(node) ){ return true;}
                        else{//bellow
                        }
                    }
               }
               else{
                   //bellow
               }
               hashArrayList[pointer].add(node);
               return true;
        }
        else{
            return false;
        }
    }

    /**
     * Removes a single instance of the specified element from this
     * collection
     */
    @Override
    public boolean remove(Object o) {
        if(o != null) {
            for (int i = 0; i < hashArrayList.length; i++) {
                if(hashArrayList[i].size()>0){
                    for(Node node : hashArrayList[i]){
                        if(hashArrayList[i].contains(o)){
                            hashArrayList[i].remove(o);
                            return true;
                        }
                    }
                }
            }
        }
        else {
        }
        return false;
    }

    /**
     * Adds all of the elements in the specified collection to this collection
     * (optional operation).
     */
    @Override
    public boolean addAll(Collection c) {
        if (c != null) {
            for (Object obj : c) {
                if( this.add(obj) ){}
                else{return false;}
            }
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Removes all of the elements from this collection (optional operation).
     * The collection will be empty after this method returns.
     *
     * @throws UnsupportedOperationException if the {@code clear} operation
     *                                       is not supported by this collection
     */
    @Override
    public void clear() {
        for(int i=0;i<hashArrayList.length;i++) {
            hashArrayList[i].clear();
        }

    }

    /**
     * Retains only the elements in this collection that are contained in the
     * specified collection (optional operation).  In other words, removes from
     * this collection all of its elements that are not contained in the
     * specified collection.
     */
    @Override
    public boolean retainAll(Collection c) {
        for(Object obj : c){
            if(!this.contains(obj)){
                c.remove(obj);
            }
            else{}
        }
        return true;
    }

    /**
     * Removes all of this collection's elements that are also contained in the
     * specified collection (optional operation).  After this call returns,
     * this collection will contain no elements in common with the specified
     * collection.
     */
    @Override
    public boolean removeAll(Collection c) {
        if (c != null) {
            for (Object obj : c) {
                this.remove(obj);
            }
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Returns {@code true} if this collection contains all of the elements
     * in the specified collection.
     * */
    @Override
    public boolean containsAll(Collection c) {
        if (c != null) {
            for (Object obj : c) {
                if( this.contains(obj) ){}
                else{return false;}
            }
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Returns an array containing all of the elements in this collection;
     * the runtime type of the returned array is that of the specified array.
     * If the collection fits in the specified array, it is returned therein.
     * Otherwise, a new array is allocated with the runtime type of the
     * specified array and the size of this collection.
     */
    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

}
