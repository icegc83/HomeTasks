package ua.hillel.a_sapon.Lesson_2;

/**
 * 1. Выведите первые 5 элементов массива, у которого размер 10
 * 2. Создайте массив размером n, элементами, которого будут числа от 1 до n
 * 3. Создайте массив размером n, элементами которого будут числа от n до 1
 * 4. Выведите элементы массива, которые делятся на 3 без остатка
 * 5. Выведите все четные элементы массива
 * 6. Найдите сумму элементов массива
 * 7. Найдите среднее арифметическое элементов массива
 * 8. Определите сумму минимального и максимального элементов массива
 * 9. Определите произведение всех нечетных элементов массива
 * 10. Определите позицию (индекс) элемента с числом n, если такого числа нет, выведите соответствующее сообщение
 */
public class Lesson_2
{
    public static void main(String[] args){

        System.out.println("\n --------------------------------");
        System.out.println("At start we are going to generate random array with the size 10x10 and Max value 50");
        /**/    ARREY Arr = new ARREY(10,50);   //Additional constructors ARREY()- random size , ARREY(MaxSize);
        Arr.PrintInt(); //Arr.Print() for double output

        System.out.println("\n --------------------------------");
        System.out.println("TASK 1:  Print out first 5 array's elements greater than 10");
        Arr.Print_N_Greater_Elements_Int(10,5); //Print out first counter array's values higher than specified value

        System.out.println("\n\n --------------------------------");
        System.out.println("TASK 2: Generate array of N size with elements from 1 до n ");
        System.out.println("So the new random array will be : \n");
        ARREY Arr2 = new ARREY (0,10,100);
        Arr2.PrintInt();
        System.out.println("\n Going to sort that array in Ascended way : \n");
        Arr2.SortAsc();
        Arr2.PrintInt();

        System.out.println("\n --------------------------------");
        System.out.println("TASK 3: Generate array of N size with elements from N tо 1 ");
        System.out.println("We are not going to create another array but instead old one will be sorted in Descended way : \n");
        Arr2.SortDesc();
        Arr2.PrintInt();

        System.out.println("\n --------------------------------");
        System.out.println("TASK 4: Print all elements which can be divided on 3 without remainder");
        System.out.println("And for the first 2 dimensional array such will be : \n");
        Arr.Print_N_Elements_Divide_Without_Remainder(3,-1);

        System.out.println("\n --------------------------------");
        System.out.println("TASK 5: Print all elements which are even");
        System.out.println("Again such operation ,and all further, will be done for the initial 2d array\n");
        Arr.Print_N_Elements_Divide_Without_Remainder(2,-1);

        System.out.println("\n --------------------------------");
        System.out.println("TASK 6: Get sum of all array's elements");
        System.out.println("And it's equal to: "+ (int)Arr.Sum());

        System.out.println("\n --------------------------------");
        System.out.println("TASK 7: Get an average of all array's elements");
        System.out.println("And it's equal to: "+ (int)Arr.Average());

        System.out.println("\n --------------------------------");
        System.out.println("TASK 8: Get Maximum and minimum among array's elements and their sum");
        System.out.println("Max Value of the array is: " + (int)Arr.GetMax());
        System.out.println("Min Value of the array is: " + (int)Arr.GetMin());
        System.out.println("Min and Max Sum of the array is: " + ((int)Arr.GetMin()+(int)Arr.GetMax()));


        System.out.println("\n --------------------------------");
        System.out.println("TASK 9: Get Multiplicaiton of all not even elements");
        System.out.println("It will be: " + Arr.MultiplyNotEven(2));

        System.out.println("\n --------------------------------");
        System.out.println("Task 10: Get an Index of particular element 2");
        int pos=(int)Arr.GetIndex(2);
        if (pos!=-1)
            System.out.println("Position is " + pos);
        else
            System.out.println("Unfortunately such element is not found");

        System.out.println("\n --------------------------------");
        System.out.println("\n Lets Get an Index of third element");
        System.out.println("Position is: " + (int) Arr.GetThirdElementIndex());

    }
}
