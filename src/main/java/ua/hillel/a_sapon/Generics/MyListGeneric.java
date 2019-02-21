package ua.hillel.lesson10.generic;

import java.util.*;

import java.util.Iterator;
import java.util.function.*;

public class MyListGeneric<E> implements Collection<E> {

        private Node<E> head;



    @Override
    public int size() {
        int count =0;
        for(Node<E> node = head; node != null; node = node.next){
            count++;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
        public Iterator<E> iterator() {


            return new Iterator<E>() {
                Node<E> node = head;
                @Override
                public boolean hasNext() {
                    return node != null;
                }

                @Override
                public E next() {
                    E value = node.value;
                    node = node.next;
                    return null;

                }
            };
        }


        private static class Node<T>{
            private T value;
            private Node<T> next;

            public Node(T value, Node<T> next){
                this.value = value;
                this.next = next;

            }

            public T getValue(){
                return value;
            }

        }

        public boolean add(E e){
            head = new Node<>(e, head);
            return true;
        }

        public void print(){
            for(Node<E> node = head; node != null; node = node.next){
                System.out.print("\n " + node.value);
            }
        }

        public Node<E> tail(){
            Node<E> node = head;
            while( node != null){
                node = node.next;
            }
            return node;
        }

        public void iterate(Consumer<E> consumer){
            for(Node<E> node = head; node != null; node = node.next){
                consumer.accept(node.value);
            }
        }
}
