package ua.hillel.a_sapon.HomeWork.Task2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Task2 {
    public static void main(String ... args){

        System.out.println("-------------Implement Iterator for Linked List--------------");
        System.out.println("-------------------------------------------------------------");


        MyList myList = new MyList();
        Integer[] arrayList = {1,2,3,4,5};
        MyList myListArray = new MyList(arrayList);

        System.out.println("\n Step 1:" +
                "We have created next arrays:");
        System.out.println(myList);
        System.out.println(myListArray);

        System.out.println("\n Step 2:" +
                "Lets see their size");
        System.out.println(myList.size());
        System.out.println(myListArray.size());

        System.out.println("\n Step 3:" +
                "Lets define are they are empty");
        System.out.println(myList.isEmpty());
        System.out.println(myListArray.isEmpty());

        System.out.println("\n Step 4:" +
                "Lets define do they contains 1");
        System.out.println( myList.contains(1) );
        System.out.println( myListArray.contains(1) );

        System.out.println("\n Step 5:" +
                "Lets convert second one to array");
        Object[] array;
        array = myListArray.toArray();
        System.out.println(Arrays.toString(array));

        System.out.println("\n Step 6:" +
                "Lets try the same thing but with 0 size array");
        Object[] array2 = new Integer[0];
        array2 = myListArray.toArray();
        System.out.println(Arrays.toString(array2));

        System.out.println("\n Step 7:" +
                "Lets add one more object with number 7 to both MyLists");
        myList.add(7);
        myListArray.add(7);

        System.out.println(myList);
        System.out.println(myListArray);

        System.out.println("\n Step 8:" +
                "and now we are going to remove that element");
        myList.remove(7);
        myListArray.remove(7);

        System.out.println(myList);
        System.out.println(myListArray);

        System.out.println("\n Step 9:" +
                "lets test iterator");
        Iterator<Object> iterator = myListArray.iterator();
        StringBuffer stringBuffer = new StringBuffer();
        Object o = new Object();
        while(iterator.hasNext()){
            o = iterator.next();
            stringBuffer.append(o.toString() + " ");
        }
        o = iterator.next();
        stringBuffer.append(o.toString() + " ");
        System.out.println(stringBuffer);


        System.out.println("\n-------------------------------------------------------------");
        System.out.println("----------------------END OF THE GAME------------------------");


    }
}
