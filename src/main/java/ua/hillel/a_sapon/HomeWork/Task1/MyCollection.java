package ua.hillel.a_sapon.HomeWork.Task1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MyCollection implements Collection
{
    private Object[] object;

    @Override
    public String toString() {
        return "MyCollection{" +
                "object=" + Arrays.toString(object) +
                '}';
    }

    /**
     * Default Constructor for creation of an empty MyCollection
     */
    public MyCollection() {
        this.object = new Object[0];
    }

    /**
     * Constructor of MyCollection with defined array of Objects as an input
     * @param o collection which should be taken as a basis on Mycollection creation
     */
    public MyCollection(Object[] o) {
        //not null Object[]
        if(o != null) {
            this.object = new Object[o.length];
            //we are going to copy all references on Objects instead of linking object to the same Object[]
            for(int i=0; i<o.length ; i++) {
                this.object[i] = o[i];
            }
        }
        //nul Object[]
        else{
            this.object = new Object[0];;
        }
    }

    /**
     * Returns the number of elements in this collection.  If this collection
     * contains more than {@code Integer.MAX_VALUE} elements, returns
     * {@code Integer.MAX_VALUE}.
     *
     * @return the number of elements in this collection
     */
    @Override
    public int size() {
        return this.object.length;
    }

    /**
     * Returns {@code true} if this collection contains no elements.
     * @return {@code true} if this collection contains no elements
     */
    @Override
    public boolean isEmpty() {
        return !( ( this.size() > 0 ) && (object[0] != null) );
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
        if (o != null) {
            for (Object obj : this.object) {
                if (obj.equals(o)) {
                    return true;
                }
            }
            return false;
        }
        else {
            return false;
        }
    }

    /**
     * Returns an iterator over the elements in this collection.
    */
    @Override
    public Iterator iterator() {
        return new Iterator() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < object.length;
            }

            @Override
            public Object next() {
                if (index == object.length) {
                    throw new IndexOutOfBoundsException();
                } else {
                    Object value = object[index];
                    index++;
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
        //We dont want to violate our collection so we'll return a copy of such
        int length = this.object.length;
        Object[] newObj = new Object[length];

        for (int i=0; i < length; i++){
            newObj[i] = object[i];
        }

        return newObj;
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

        int length = this.object.length;
        int i = length;
        Object[] newObj;

        if (a != null) {
            //Lets define if there is an empty space at the end of our collection
            while ((i > 0) && (object[i - 1] == null)) {
                --i;
            }

            if ((i < length) && (i > 0)) {
                if (i >= a.length) {
                    newObj = a;
                } else {
                    newObj = new Object[i];
                }

                for (int j = 0; j < i; j++) {
                    newObj[j] = object[j];
                }
                return newObj;
            } else {//bellow
            }
        }

        newObj = new Object[length];
        for (int j = 0; j < length; j++) {
            newObj[j] = object[j];
        }
        return newObj;

    }

    /**
     * Add specified element to the Collection. Duplicates are allowed.
     * @param o
     * @return false in case if Collection cannot be extended
     */
    @Override
    public boolean add(Object o) {
        if (o != null) {
            int length = object.length;

            //Lets define if there is an empty space to add new element
            if (length != 0) {
                int i = length;
                while ((i > 0) && (object[i - 1] == null)) {
                    --i;
                }
                if (i < length) {
                    object[i] = o;
                    return true;
                }
            }
            //we are going to increase size of the array and copy all elements into it
            {
                Object[] obj2;

                if( ((length + 1) * 1.5) == Integer.MAX_VALUE){
                    if ( (length + 1) == Integer.MAX_VALUE){ return false;}
                    else{
                        obj2 = new Object[(length + 1)];
                    }
                }
                else {
                    obj2 = new Object[(int) ((length + 1) * 1.5)];
                }

                for (int i = 0; i < length; i++) {
                    obj2[i] = object[i];
                    object[i] = null;
                }
                obj2[length] = o;
                object = obj2;
                return true;
            }
        }
        else {
        }
        return false;
    }

    /**
     * Removes a single instance of the specified element from this
     * collection
     */
    @Override
    public boolean remove(Object o) {
        if (o != null) {
            int length = object.length;

            //at first we would need to locate o
            int i = 0;
            while ((i < length) && (!object[i].equals(o))) {
                ++i;
            }
            //if such is located we going to remove it and transfer everything to the right from it to the left for one position
            if (i < length) {
                object[i] = null;
                for (; (i + 1) < length; i++) {
                    object[i] = object[i + 1];
                    object[i + 1] = null;
                }
                return true;
            }
            //in case if such element is not found we return false
            else {
                return false;
            }
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
     * Adds all of the elements in the specified collection to this collection.
    */
    @Override
    public boolean addAll(Collection c) {
        if (c != null) {
            for (Object obj : c) {
                this.add(obj);
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
    public boolean removeAll(Collection c) {
        //to eliminate number of operations we can re-write this part of code by replacing all elements with null and transfer all elements to the left
        // but I'm lazy and will use code which is already written
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
    @Override
    public boolean retainAll(Collection c) {
        if( c!= null) {
            Object[] newObj = new Object[c.size()];
            int i=0;

            for (Object obj : c){
                if(this.contains(obj)){
                    newObj[i] = obj;
                    i++;
                }
                else{}
            }

            object = newObj;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Removes all of the elements from this collection (optional operation).
     * The collection will be empty after this method returns.
     */
    @Override
    public void clear() {
        for(Object obj : object){
            obj = null;
        }
        object = new Object[0];
    }

    /**
     * Returns an array containing all of the elements in this collection,
     * using the provided {@code generator} function to allocate the returned array.
    */
    @Override
    public Object[] toArray(IntFunction generator) {

        if (generator != null)
        {
            int length = object.length;
            Object[] newObj = new Object[length];
            for (int i = 0; i < length; i++) {
                try {
                    newObj[i] = generator.apply((Integer) object[i]);
                } catch (Exception e) {
                    return new Object[0];
                }
            }
            return newObj;
        }
        else{
            return new Object[0];
        }
    }

    /**
     * Removes all of the elements of this collection that satisfy the given
     * predicate.
     */
    @Override
    public boolean removeIf(Predicate filter) {
        if(filter != null)
        {
            //all this must be done at copy to have an ability for rollback but we assume
            // that it's more than enough to have it as it is
            try {
                for (Object o : object) {
                    if (filter.test(o)) {
                        this.remove(o);
                    } else {
                    }
                }
                return true;
            }
            catch(Exception e){
                return false;
            }
        }
        else{
            return false;
        }
    }

    /**
     * Not implemented
     * Always
     * @return null
     */
    @Override
    public Spliterator spliterator() {
        return null;
    }

    /**
     * Not implemented
     * Always
     * @return null
     */
    @Override
    public Stream stream() {
        //return StreamSupport.stream(spliterator(), false);
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyCollection that = (MyCollection) o;
        return Arrays.equals(object, that.object);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(object);
    }

    /**
     * Not implemented
     * Always
     * @return null
     */
    @Override
    public Stream parallelStream() {
        return null;
    }
}
