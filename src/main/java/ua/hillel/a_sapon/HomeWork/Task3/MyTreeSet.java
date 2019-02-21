package ua.hillel.a_sapon.HomeWork.Task3;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class MyTreeSet<E> implements Collection {

    private Node<E> head;


    private static class Node<T>{
        private T value;
        private Node<T> left;
        private Node<T> right;

        public Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getLeft() {
            return left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    /*Constructors somewhere here*/

    public MyTreeSet() {
        this.head = null;
    }

    public MyTreeSet(E[] array)  {
        for(E e : array) {
            this.add(e);
        }
    }

    /**
     * Returns the number of elements in this collection.
     */
    @Override
    public int size() {
        Node<E> node = this.head;
        if (head != null){
            return  size(node);
        }
        else {
            return -1;
        }
    }

    private int size(Node<E> node){
        int count =0;
        if(node.right != null) { count += size(node.right);}
        if(node.left != null) { count += size(node.left);}
        count += 1;

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
            return contains(head,o);
        }
        else{return false;}
    }

    private boolean contains(Node<E> e, Object o){
        boolean result = false;
        if(e != null) {
            if (e.value.equals(o)) {
                result = true;
            } else {
                if ( (e.right != null) && ((int) e.value < (int)o) ) {
                    result = result || contains(e.right, o);
                }
                if ( (e.left != null) && ((int)e.value > (int)o ) ) {
                    result = result || contains(e.left, o);
                }
            }
            return result;
        }
        else{
            return false;
        }
    }

    /**
     * Returns an iterator over the elements in this collection.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> node = head;

            Node<E>[] levelArray = new Node[1];
            int pointer=0;
            {
                levelArray[0]=node;
            }

            private int nextLayerCounter(){
                int count=0;
                for(int i=0; i<levelArray.length;i++){
                    if(levelArray[i].left != null){count++;}
                    if(levelArray[i].right != null){count++;}
                }
                return count;
            }

            @Override
            public boolean hasNext() {
                int count = nextLayerCounter();

                if( (pointer + 1 < levelArray.length) || ( count > 0) ) {
                    return true;
                }
                else{
                    return false;
                }
            }

            @Override
            public E next() {

                if( (pointer + 1 < levelArray.length) ){
                    pointer++;
                    return levelArray[pointer-1].value;
                }
                if ( (pointer + 1 == levelArray.length) ){
                    Node<E>[] levelArrayTmp = new Node[nextLayerCounter()];
                    int c=0;
                    for(int i=0; i<levelArray.length;i++){
                        if(levelArray[i].left != null) {
                            levelArrayTmp[c]=levelArray[i].left;
                            ++c;
                        }
                        if(levelArray[i].right != null) {
                            levelArrayTmp[c]=levelArray[i].right;
                            ++c;
                        }
                    }
                    E value = levelArray[pointer].value;
                    levelArray = levelArrayTmp;
                    pointer =0;

                    return value;
                }
                if( (pointer + 1 > levelArray.length) ){
                    throw new IndexOutOfBoundsException();
                }
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

        if (head == null) { return new Object[0];}
        Node<E> node = head;
        ArrayList<E> list = new ArrayList();
        list.addAll(toArray(node));
        return list.toArray();
    }

    private ArrayList toArray(Node<E> node){
        ArrayList intrList = new ArrayList();
        if(node.right != null) {
            intrList.addAll( toArray(node.right) );
        }
        if(node.left != null) {
            intrList.addAll( toArray(node.left) );
        }


        intrList.add((E)node.value);
        return intrList;
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
        if(o == null){
            return false;
        }
        else{
            if (head == null){
                head = new Node(o);
                return true;
            }
            Node<E> node = head;
            return add(o,node);
        }
    }

    private boolean add(Object o, Node<E> node){
        //For Generic approach I think that maybe Comparator should be implemented here...
        if( (int) node.value > (int)o ){
            if(node.left != null){
                add(o,node.left);
            }
            else{
                try{
                    Node<E> newNode= new Node((E)o);
                    node.left = newNode;
                }
                catch(Exception e){return false;}
            }
        }
        if( (int) node.value < (int)o ){
            if(node.right != null){
                add(o,node.right);
            }
            else{
                try {
                    Node<E> newNode = new Node((E) o);
                    node.right = newNode;
                }
                catch(Exception e){return false;}
            }
        }

        return true;
    }


    /**
     * Removes a single instance of the specified element from this
     * collection
     */
    @Override
    public boolean remove(Object o) {
        if(o == null){
            return false;
        }
        else{
            Node<E> node = head;
            Node<E> parentNode = null;
            return remove(o,node,parentNode);
        }
    }

    private boolean remove(Object o, Node<E> node, Node<E> parentNode){
        if(node.value.equals(o)){
            //will be done later
            if(parentNode != null) {
                if ((int) parentNode.value > (int) node.value) {
                    parentNode.left = null;
                }
                if ((int) parentNode.value < (int) node.value) {
                    parentNode.right = null;
                }
                ArrayList arrayList = new ArrayList();
                if (node.left != null) {
                    arrayList.addAll(getNodesBellow(node.left));
                }
                if (node.right != null) {
                    arrayList.addAll(getNodesBellow(node.right));
                }
                this.addAll(arrayList);
            }
            else{
                this.head = null;
            }
            return true;
        }
        else{
            if( ((int)node.value < (int)o) && (node.right != null) ) {
                return remove(o, node.right,node);
            }
            if( ((int)node.value > (int)o) && (node.left != null) ){
                return remove(o, node.left,node);
            }
            return false;
        }
    }

    private ArrayList getNodesBellow(Node<E> node){
        ArrayList arrayList = new ArrayList();
        if(node.left!=null){arrayList.addAll(getNodesBellow(node.left));}
        if(node.right!=null){arrayList.addAll(getNodesBellow(node.right));}

        arrayList.add(node.value);
        return arrayList;
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
        head = null;
    }


    /**
     * Retains only the elements in this collection that are contained in the
     * specified collection (optional operation).  In other words, removes from
     * this collection all of its elements that are not contained in the
     * specified collection.
     */
    @Override
    public boolean retainAll(Collection c) {
        return false;
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

    @Override
    public String toString() {
        return "MyTreeSet{" +
                "head=" + head +
                '}';
    }
}
