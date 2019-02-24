package ua.hillel.a_sapon.HomeWork.Task4;

import java.util.Arrays;
import java.util.Iterator;

public class Task4 {
    public static void main(String ... args){

        System.out.println("---------------Implement Iterator for TreeSet----------------");
        System.out.println("-------------------------------------------------------------");

        MyMap myMap = new MyMap();
        MyMap anotherMyMap = new MyMap();
        myMap.put("a",1);
        myMap.put("b",2);
        myMap.put("c",3);
        myMap.put("d",4);
        myMap.put("e",5);


        System.out.println("\n Step 1:" +
                "We have created next Map:");
        System.out.println(anotherMyMap);
        System.out.println(myMap);

        System.out.println("\n Step 2:" +
                "Lets see their size");
        System.out.println(anotherMyMap.size());
        System.out.println(myMap.size());

        System.out.println("\n Step 3:" +
                "Lets define are they are empty");
        System.out.println(anotherMyMap.isEmpty());
        System.out.println(myMap.isEmpty());

        System.out.println("\n Step 4:" +
                "Lets define do they contains value 1");
        System.out.println(anotherMyMap.containsValue(1));
        System.out.println(myMap.containsValue(1));

        System.out.println("\n Step 5:" +
                "Lets define what value is behind key 'c' ");
        System.out.println(anotherMyMap.get("c"));
        System.out.println(myMap.get("c"));

        System.out.println("\n Step 6:" +
                "Lets add new value '35' for the same key 'c' ");
        System.out.println(anotherMyMap.put("c",35));
        System.out.println(myMap.put("c",35));

        System.out.println("\n Step 7:" +
                "Lets see what we have in result");
        System.out.println(anotherMyMap);
        System.out.println(myMap);

        System.out.println("\n Step 8:" +
                "and now we are going to remove elements by key 'c'");
        System.out.println(anotherMyMap.remove("c"));
        System.out.println(myMap.remove("c"));

        System.out.println("\n Step 9:" +
                "Lets see what we have in result");
        System.out.println(anotherMyMap);
        System.out.println(myMap);

        System.out.println("\n Step 10:" +
                "Last step is to clear everything and see the result");
        myMap.clear();
        anotherMyMap.clear();
        System.out.println(myMap);
        System.out.println(anotherMyMap);

        System.out.println("\n-------------------------------------------------------------");
        System.out.println("----------------------END OF THE GAME------------------------");
    }


}
