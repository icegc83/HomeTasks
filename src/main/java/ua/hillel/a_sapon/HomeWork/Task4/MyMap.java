package ua.hillel.a_sapon.HomeWork.Task4;

import java.util.*;

public class MyMap<E,K> implements Map {

    private int hashArraySize;
    private ArrayList<Node>[] hashArrayList;

    private static class Node<K,E>{
        private K key;
        private E value;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?, ?> node = (Node<?, ?>) o;
            return key.equals(node.key) &&
                    value.equals(node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

        public Node(K key, E value) {
            this.value = value;
            this.key = key;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }
    }

    public MyMap() {
        this(1000);
    }

    public MyMap(int hashArraySize) {
        this.hashArraySize = hashArraySize;
        hashArrayList = new ArrayList[hashArraySize];
    }

    public MyMap(E[] array)  {
        this(1000);
        for(E e : array) {
            this.put(e,e);
        }
    }

    /**
     * Returns the number of elements in this collection.
     */
    @Override
    public int size() {
        int counter =0;
        for (int i=0;i<hashArrayList.length;i++){
            if( (hashArrayList[i] != null) && (hashArrayList[i].size() > 0) ) {
                for(Node node : hashArrayList[i]){
                    ++counter;
                }
            }
        }
        return counter;
    }

    /**
     * Returns {@code true} if this collection contains no elements.
     */
    @Override
    public boolean isEmpty() {
        return !(this.size()>0);
    }

    /**
     * Returns {@code true} if this collection contains the specified key.
     * @return {@code true} if this collection contains the specified
     *         key
     */
    @Override
    public boolean containsKey(Object key) {
        if(key != null){
            int hash = key.hashCode();
            int pointer = hash % hashArrayList.length;

            if( (hashArrayList[pointer] != null) && (hashArrayList[pointer].size() > 0 ) ){
                for(Node node : hashArrayList[pointer]){
                    if(node.key.equals(key)){
                        return true;
                    }
                    else{
                    }
                }
            }
            else{}
        }
        else{
        }
        return false;
    }

    /**
     * Returns {@code true} if this map maps one or more keys to the
     * specified value.
     *
     */
    @Override
    public boolean containsValue(Object value) {
        if( value != null ){
            int i=0;
            while( i < hashArraySize ){
                if( (hashArrayList[i] != null) && (hashArrayList[i].size() > 0 ) ){
                    for(Node node : hashArrayList[i]){
                        if(node.value.equals(value)){
                            return true;
                        }
                        else{
                        }
                    }
                }
                i++;
            }
        }
        else{
        }
        return false;
    }

    /**
     * Returns the value to which the specified key is mapped,
     * or {@code null} if this map contains no mapping for the key.
     */
    @Override
    public Object get(Object key) {
        int hash = key.hashCode();
        int pointer = hash % hashArrayList.length;
        if ( (hashArrayList[pointer] != null) && (hashArrayList[pointer].size() > 0 ) ){
            return hashArrayList[pointer].get(0);
        }
        else {
            return null;
        }
    }

    /**
     * Associates the specified value with the specified key in this map
     * (optional operation).  If the map previously contained a mapping for
     * the key, the old value is added as second one with the same key.
     * @return
     */
    @Override
    public Object put(Object key, Object value) {
        if( (key != null) && (value != null) ){
            Node<K,E> node = new Node<K,E>((K)key,(E)value);
            int hash = key.hashCode();
            int pointer = (int)(hash % hashArrayList.length);
            if( (hashArrayList[pointer] != null) && (hashArrayList[pointer].size() ) > 0){
                hashArrayList[pointer].add(node);
                return hashArrayList[pointer].get(hashArrayList[pointer].size()-1);
            }
            else{
            }
            hashArrayList[pointer] = new ArrayList<>();
            hashArrayList[pointer].add(node);
            return hashArrayList[pointer].get(hashArrayList[pointer].size()-1);
        }
        else{
            return null;
        }
    }

    /**
     * Removes the mapping for a key from this map if it is present
     * (optional operation).   More formally, if this map contains a mapping
     * from key {@code k} to value {@code v} such that
     * {@code Objects.equals(key, k)}, that mapping
     * is removed.
     */
    @Override
    public Object remove(Object key) {
        if(key != null) {
            int hash = key.hashCode();
            int pointer = hash % hashArrayList.length;
            if ( (hashArrayList[pointer] != null) && (hashArrayList[pointer].size() > 0 ) ){
                hashArrayList[pointer].clear();
                hashArrayList[pointer] = null;
            }
            else {
            }
            return true;
        }
        else {
        }
        return false;
    }

    /**
     * Copies all of the mappings from the specified map to this map
     * (optional operation).  The effect of this call is equivalent to that
     * of calling {@link #put(Object, Object) put(k, v)} on this map once
     * for each mapping from key {@code k} to value {@code v} in the
     * specified map.  The behavior of this operation is undefined if the
     * specified map is modified while the operation is in progress.
     */
    @Override
    public void putAll(Map m) {
        if (m != null){
            Set keySet = m.keySet();
            for(Object key : keySet){
                this.put(key, m.get(key));
            }
        }
        else{
        }
    }

    /**
     * Removes all of the mappings from this map (optional operation).
     * The map will be empty after this call returns.
     *
     * @throws UnsupportedOperationException if the {@code clear} operation
     *                                       is not supported by this map
     */
    @Override
    public void clear() {
        for(int i=0;i<hashArrayList.length;i++) {
            if(hashArrayList[i] != null) {
                hashArrayList[i].clear();
                hashArrayList[i] = null;
            }
        }
    }

    /**
     * Returns a {@link Set} view of the keys contained in this map.
     * The set is backed by the map, so changes to the map are
     * reflected in the set, and vice-versa.
     */
    @Override
    public Set keySet() {
        Set keySet = new HashSet();
        for(int i=0;i<hashArrayList.length;i++){
            if( (hashArrayList[i] != null) && (hashArrayList[i].size() > 0 ) ){
                for (Node node : hashArrayList[i]){
                    keySet.add(node.key);
                }
            }
        }
        return keySet;
    }

    /**
     * Returns a {@link Collection} view of the values contained in this map.
     * The collection is backed by the map, so changes to the map are
     * reflected in the collection, and vice-versa.  If the map is
     * modified while an iteration over the collection is in progress
     * (except through the iterator's own {@code remove} operation),
     * the results of the iteration are undefined.  The collection
     * supports element removal, which removes the corresponding
     * mapping from the map, via the {@code Iterator.remove},
     * {@code Collection.remove}, {@code removeAll},
     * {@code retainAll} and {@code clear} operations.  It does not
     * support the {@code add} or {@code addAll} operations.
     *
     * @return a collection view of the values contained in this map
     */
    @Override
    public Collection values() {
        Collection valuesList = new ArrayList();
        for(int i=0;i<hashArrayList.length;i++){
            if( (hashArrayList[i] != null) && (hashArrayList[i].size() > 0 ) ){
                for (Node node : hashArrayList[i]){
                    valuesList.add(node.value);
                }
            }
        }
        return valuesList;
    }

    /**
     * Returns a {@link Set} view of the mappings contained in this map.
     * The set is backed by the map, so changes to the map are
     * reflected in the set, and vice-versa.  If the map is modified
     * while an iteration over the set is in progress (except through
     * the iterator's own {@code remove} operation, or through the
     * {@code setValue} operation on a map entry returned by the
     * iterator) the results of the iteration are undefined.
     */
    @Override
    public Set<Entry> entrySet() {
        return null;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if(this.size() >0) {
            for (int i = 0; i < hashArrayList.length; i++) {
                if ((hashArrayList[i] != null) && (hashArrayList[i].size() > 0)) {
                    for (Node node : hashArrayList[i]) {
                        if (node != null) {
                            stringBuffer.append(node + " ");
                        }
                    }
                }
            }
        }
        else{
            stringBuffer.append("Map is empty");
        }
        return stringBuffer.toString();

//default implementation which we are not going to use
/*        return "MyMap{" +
                "hashArraySize=" + hashArraySize +
                ", hashArrayList=" + Arrays.toString(hashArrayList) +
                '}';*/
    }
}
