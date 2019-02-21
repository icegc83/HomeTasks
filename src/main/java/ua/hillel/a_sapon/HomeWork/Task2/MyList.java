package ua.hillel.a_sapon.HomeWork.Task2;


import java.util.Collection;
import java.util.Iterator;

public class MyList<E> implements Collection<E> {

    private Node<E> head;

    private static class Node<T>{
        private T value;
        private Node<T> next;

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }

        public Node(T value, Node<T> next){
            this.value = value;
            this.next = next;
        }

        /*public T getValue(){
            return value;
        }*/
    }

    public MyList(Node<E> head) {
        this.head = head;
    }

    public MyList() {
        this.head = null;
    }

    public MyList(E[] array)  {
        for(E e : array) {
            this.add(e);
        }
    }

    /**
     * Returns the number of elements in this collection.
     */
    @Override
    public int size() {
        Integer count=0;
        Node<E> node = this.head;
        if(node == null) {return -1;}

        while(node!=null){
            node = node.next;
            ++count;
        }

        return count;
    }

    /**
     * Returns {@code true} if this collection contains no elements.
     */
    @Override
    public boolean isEmpty() {
        return  (head == null);
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
        if(o != null)
        {
            Node<E> node = head;
            while(node != null){
                if (node.value.equals(o)) {return true;}
                node = node.next;
            }
            return false;
        }
        else{return false;}
    }

    /**
     * Returns an iterator over the elements in this collection.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Node<E> node = head;

            @Override
            public boolean hasNext() {
                return (node.next != null);
            }

            @Override
            public E next() {
                if (node == null) {throw new IndexOutOfBoundsException();}
                else {
                    E value = node.value;
                    node = node.next;
                    return value;
                }
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

        if (head == null) { return new Object[0];}
        Node<E> node = head;
        int length = this.size();
        Object[] array = new Object[length];

       for (int i=0; i< length; i++){
           array[i]=node.value;
           node=node.next;
        }

        return array;
    }

    /**
     * Returns an array containing all of the elements in this collection;
     * the runtime type of the returned array is that of the specified array.
     * If the collection fits in the specified array, it is returned therein.
     * Otherwise, a new array is allocated with the runtime type of the
     * specified array and the size of this collection.
     */
    @Override
    public <T> T[] toArray(T[] a) {
        //On implementation we do not care if a is empty or not
        int length = this.size();
        Node<E> node = head;

        if (a != null) {
            if (head == null) {
                return a;
            }
            else{
                if(a.length >= length){
                }
                else{
                    a = (T[]) new Object[length];
                }
            }
        }
        else{
            a = (T[]) new Object[length];
        }

        for (int i=0; i<length; i++){
            a[i] = (T) node.value;
            node = node.next;
        }
        return a;
    }

    /**
     * Add specified element to the Collection. Duplicates are allowed.
     * @param e
     * @return false in case if Collection cannot be extended
     */
    @Override
    public boolean add(E e) {
        head = new Node<>(e, head);
        return true;
    }

    /**
     * Removes a single instance of the specified element from this
     * collection
     */
    @Override
    public boolean remove(Object o) {
        if (o == null) {return false;}
        else {
            if (!this.contains(o)) {
                return false;
            } else {
                Node<E> node = head;

                if(node.value.equals(o)){
                    head = node.next;
                    return true;
                }

                while ( node.next != null ){
                    if( node.next.value.equals(0) ){
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;
                }
                return false;
            }
        }
    }

    /**
     * Returns {@code true} if this collection contains all of the elements
     * in the specified collection.
     * */
    @Override
    public boolean containsAll(Collection<?> c) {
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
     * Adds all of the elements in the specified collection to this collection.
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c != null) {
            for (Object obj : c) {
                this.add((E)obj);
            }
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * Removes all of this collection's elements that are also contained in the
     * specified collection (optional operation).  After this call returns,
     * this collection will contain no elements in common with the specified
     * collection.
     */
    @Override
    public boolean removeAll(Collection<?> c) {
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
     * Retains only the elements in this collection that are contained in the
     * specified collection (optional operation).  In other words, removes from
     * this collection all of its elements that are not contained in the
     * specified collection.
     */
    public boolean retainAll(Collection<?> c) {
        if( c!= null) {

            Node<E> node;
            MyList myList = new MyList();
            for (Object obj : c){
                if(this.contains(obj)){
                    myList.add(obj);
                }
                else{}
            }

            this.setHead( myList.getHead() );
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
        Node<E> node = head;
        Node<E> prv;
        while(node.next != null){
            prv = node;
            node = node.next;
            prv.value = null;
            prv.next = null;
        }
        node.value = null;
        head = null;
    }


    public Node<E> getHead() {
        return head;
    }

    private void setHead(Node<E> head) {
        this.head = head;
    }

    @Override
    public String toString() {
        Node<E> node = head;
        StringBuffer stringBuffer = new StringBuffer();

        if(node != null){
            return node.toString();
        }
        else{
            return "List is not initialized";
        }

    }
}


