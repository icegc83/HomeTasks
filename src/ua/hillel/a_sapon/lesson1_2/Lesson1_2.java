package ua.hillel.a_sapon.lesson1_2;

/**
 * TASK: Initialize array of NxN (10x10) size with random values
 *
 */

public class Lesson1_2 {

    public static void main(String[] args)
    {
        System.out.println("TASK: Initialize array of NxN (10x10) size with random values");
        System.out.println("\n For this we are going to use two methods. \n " +
                "FIRST METHOD is with straight 10x10 array declaration \n " +
                "and \n" +
                "SECOND METHOD (just for fun) with simple random size class initialization");

        System.out.println("\n METHOD 1:");
        System.out.println("___________________________________\n");

        /**
         * METHOD 1
         * Straight 10x10 array declaration with filling in such with random int values from 1 up to 100
         */
        //Initializing array of 10x10 size
        int[][] Array;
        Array = new int [10][10];

        //implemented loop for each to fill in int Array by random values from 1 up to 100
        for (int x=0;x<Array.length;x++)
        {
            for (int y=0;y<Array[x].length;y++) {
                Array[x][y] = (int)(Math.random()*99+1);
                System.out.print(Array[x][y] + "\t");
            }
            System.out.print("\n");
        }

        /**
         * METHOD 2
         * Random NxN array declaration, where N<20 , with filling in such with random int values from 1 up to 100
         */
        System.out.println("\n METHOD 2:");
        System.out.println("___________________________________");

        //Getting random array size
        int array_size = (int)(Math.random()*20+1);
        System.out.printf("\n  Our Array will be of %d x %d size \n", array_size, array_size);

        //Lets initialize specially created class ARREY with all required functionality
        ARREY Arr = new ARREY(array_size,array_size);   //Additional constructors ARREY()- random size , ARREY(MaxSize);
        Arr.PrintInt(); //Arr.Print() for double output


    }
}
