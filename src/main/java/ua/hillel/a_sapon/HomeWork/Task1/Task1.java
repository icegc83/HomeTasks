package ua.hillel.a_sapon.HomeWork.Task1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Task1 {
    public static void main(String ... args)
    {

        System.out.println("Create your own collection and implement interface Collection");
        System.out.println("-------------------------------------------------------------");

        MyCollection myCollection = new MyCollection();
        Integer[] arrayList = {1,2,3,4,5};
        MyCollection myCollectionInteger = new MyCollection(arrayList);

        System.out.println("\n Step 1:" +
                "We have created next arrays:");
        System.out.println(myCollection);
        System.out.println(myCollectionInteger);

        System.out.println("\n Step 2:" +
                "Lets see their size");
        System.out.println(myCollection.size());
        System.out.println(myCollectionInteger.size());

        System.out.println("\n Step 3:" +
                "Lets define are they are empty");
        System.out.println(myCollection.isEmpty());
        System.out.println(myCollectionInteger.isEmpty());

        System.out.println("\n Step 4:" +
                "Lets define do they contains 1");
        System.out.println(myCollection.contains(new Integer(1)));
        System.out.println(myCollectionInteger.contains(new Integer(1)));

        System.out.println("\n Step 5:" +
                "Lets convert second one to array");
        Object[] array;
        array = myCollectionInteger.toArray();
        System.out.println(Arrays.toString(array));

        System.out.println("\n Step 6:" +
                "Lets try the same thing but with 0 size array");
        Object[] array2 = new Integer[0];
        array2 = myCollectionInteger.toArray();
        System.out.println(Arrays.toString(array2));

        System.out.println("\n Step 7:" +
                "Lets add one more object with number 7 to both Mycollections");
        myCollection.add(7);
        myCollectionInteger.add(7);

        System.out.println(myCollection);
        System.out.println(myCollectionInteger);

        System.out.println("\n Step 8:" +
                "and now we are going to remove that element");
        myCollection.remove(7);
        myCollectionInteger.remove(7);

        System.out.println(myCollection);
        System.out.println(myCollectionInteger);

        System.out.println("\n Step 9:" +
                "lets test iterator");
        Iterator<Object> iterator = myCollectionInteger.iterator();
        while(iterator.hasNext()){
            Object o = iterator.next();
            System.out.print(o + "  ");
        }

        System.out.println("\n-------------------------------------------------------------");
        System.out.println("----------------------END OF THE GAME------------------------");


    }

}
