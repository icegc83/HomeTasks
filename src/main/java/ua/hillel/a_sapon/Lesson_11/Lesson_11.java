package ua.hillel.a_sapon.Lesson_11;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Lesson_11 {

    static public void main(String args[])
    {
            System.out.println("----------1. Реализовать рекурсивную функцию выпрямления списка.---------");

            List<Object>    list = List.of(1,2,List.of(4,5),6,List.of(7,8,9,List.of(10,11)));
            List<Object>    result = flatten(list);


            System.out.println("Initially we have such List: ");
            System.out.println(list);
            System.out.println("Result of flatten method: ");
            System.out.println(result);





            System.out.println("-------2. Реализовать  задания урока 2 с использованием коллекций\t.-------");



            System.out.println("-------3. В задаче  по дизайн классов школы заметь массивы на коллекции с добавлением в эти списки объектов. --------");



            System.out.println("-------4. реализовать кэш путем наследования LinkedHashMap переопределения метода removeEldestEntry. Кэш может хранить ограниченный набор записей к примеру только 100 записей. -------");



            System.out.println("-------5. Дан список с числами и еще одно число. Определить  за один проход можно ли из двух чисел в списке составить  число.\n" +
                    "к примеру List.of(8,3,4,5,1) и число 13 программа должна вывести индексы 0 и 3 \n" +
                    "если 20 - то программа должна сообщить то такой комбинации нет.\n -------");

            List<Integer> numbersList = List.of(8,3,4,5,1);
            Integer keyNumber = 13;

            System.out.println("Initial Conditions: ");
            System.out.println("List of numbers: " + numbersList);
            System.out.println("keyNumber: " + keyNumber);

            TreeMap<Integer,Integer> mapElements = new TreeMap<>();

            int i = 0;
            boolean flag = true;
            while( (numbersList.size() > i) && (flag) ){

               /* if(numbersList.get(i) <= keyNumber) {*/

                    mapElements.put( i, (keyNumber - numbersList.get(i)) );

                    if( mapElements.containsValue( numbersList.get(i) ) ){
                        flag = false;
                        System.out.printf("key1 %d, value1: %d, key2 %d, value2: %d ", i, numbersList.get(i), numbersList.get(i), mapElements.get(numbersList.get(i)) );
                    }
                /*}*/
                i++;
            }

            if (flag == true) {
                System.out.println("No elements are found");
            }

/*
            List<Integer> accum = new ArrayList<>();
            for (Integer o: numbersList){
                accum.add(o);
                for
            }
*/


    }

    static private List<Object> flatten( List<Object> list)
    {
        ArrayList<Object> objects = new ArrayList<>();
        for (Object o : list )
        {
            if (o instanceof List) {
                objects.addAll(flatten((List<Object>) o));
            }
            else{
                objects.add(o);
            }
        }

        return objects;
    }
/*
    static private List<Object> flattenTail( List<Object> list)
    {
        return flattenTail(list, new ArrayList<>());
    }

    static private List<Object> flattenTail( List<Object> list, List<Object> accum)
    {

        ArrayList<Object> objects = new ArrayList<>();
        for (Object o : list )
        {
            if (o instanceof List) {
                objects.addAll(flatten((List<Object>) o));
            }
            else{
                objects.add(o);
            }
        }

        return objects;
    }*/



}
