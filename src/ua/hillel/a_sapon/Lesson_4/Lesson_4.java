package ua.hillel.a_sapon.Lesson_4;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 1. Пользователь вводит отсортированный массив чисел и еще одно число. Требуется сформировать новый отсортированый массив
 * котрый соостоит из исходного и нового числа.
 *
 * 2. даны 10 баночек с таблетками и известно что все кроме одной содержат таблетки весом 10 миллиграмм одна содержит
 * таблетки весом 11 миллиграм.
 * Так же даны медицинские весы которые показываю точный вес.
 * Придумать и описать как с помощью одного взвешивания определить баночку в которой нестандарный вес таблеток.
 *
 * 3. вывести простые числа. простое число это число которое делится только на себя и на 1.
 * начало 1 2 3 5 11 13
 *
 * 4. дан массив 8*8 запоненный нулями и единицами который отображает шахматную доску.
 *
 * 0 - клетка пуста
 * 1 - клетка заполнена турой. (тура бьет по вертикали и горизонтали)
 *
 * проверить что все фигуры не бьют одна другую.
 *
 * 5. Вывести последовательно числа фибоначи .
 * В третьем задании пропущена 7-ка
 */

public class Lesson_4 {
    public static void main(String[] args) {
        System.out.println("\n/*---------------------------------1----------------------------------------*/");
        System.out.println("TASK 1. User performs input of the sorted numbers array + one number. You need to create new sorted array which consist off original array and added number");

        Scanner input = new Scanner(System.in);
        System.out.println(" Please define array with of 10 int or double elements");
        double[] initial_array = new double[10];
        for (int i = 0; i < 10; i++) {
            System.out.printf("\n Please enter [%d] element:", i + 1);
            initial_array[i] = input.nextDouble();
        }
        System.out.println("Please specify one additional item which must be added to the array");
        double added_number = input.nextDouble();

        //Lets sort initial array just to be sure that start conditions are ok
        Arrays.sort(initial_array);

        //Lets add additional number but first we would need to find mediane and define by binary search where to element should be placed
        int mediane = initial_array.length / 2;
        int old_mediane = 0;

        while ((mediane != old_mediane) && (mediane < initial_array.length))
        {
            if (initial_array[mediane] < added_number) {
                old_mediane = mediane + 1;
                mediane = (initial_array.length - old_mediane) / 2 + old_mediane;
            }
            else {
            mediane = (mediane - old_mediane) / 2 + old_mediane;
            }
        }

        //creating new archive
        double[] new_array = new double[11];

        //coping first part of the archive
        for (int x=0;x<=mediane;x++)
        {
            new_array[x]=initial_array[x];
        }

        //putting in element
        if (added_number<initial_array[mediane])
        {
            new_array[mediane]=added_number;
            new_array[mediane+1]=initial_array[mediane];
        }
        else{
            new_array[mediane+1]=added_number;
        }

        // copying second part of teh archive
        for (int x=mediane+2;x<new_array.length;x++)
        {
            new_array[x]=initial_array[x-1];
        }

        //Lets print out results
        System.out.println("\n Lets have results:");
        System.out.println(Arrays.toString(new_array));



        System.out.println("\n/*---------------------------------2----------------------------------------*/");
        System.out.println("TASK 2. you have 10 jars with weight of tablets 10grm in each of those except one jar in which tablets have weight 11grm. " +
                "Try to find by one measurement which jar contains 11grm tablets");
        int[] tablets=new int[]{10,10,10,10,10,10,11,10,10,10};
        //we are going to take proportionally tablets from each can 1 from first 2 from second and so on.
        // After that we'll divide sum of such on 10 and that will be a number of the required can.
        System.out.println("we have next initial array of jars " + Arrays.toString(tablets));
        double sum=0;

        for (int i=0;i<tablets.length;i++){
            sum += tablets[i]*(i+1);
        }
        System.out.println("To find that jar we'll take from each jar number of tablets which correspond to the jar's index" +
                "after that we'll measure total weight and will find remainder from division on 10" +
                "That will be our required number");
        System.out.printf("so the can is number %d ", (int)(sum%10)   );



        System.out.println("\n/*---------------------------------3----------------------------------------*/");
        System.out.println("TASK 3. Print our prime numbers such as 1 2 3 5 11 13 etc");

        System.out.println("Please define range for which you would like to get Prime numbers");
        int range = input.nextInt();
        StringBuffer prime_Numbers=new StringBuffer();
        prime_Numbers.append(1).append(" ");
        for (int i=0;i<range;i++){
            int counter=0;
            for(int x=i;x>0;x--){
                if(i%x==0){
                    counter++;
                }
            }
            if(counter == 2)
            {
                prime_Numbers.append(i).append(" ");
            }
        }
        System.out.println("Result is "+ prime_Numbers);

        System.out.println("\n/*---------------------------------4----------------------------------------*/");
        System.out.println("TASK 4.We have an array of 8x8 size as a chess table.  ");
        int[][] chess_table=new int [][]{
                {0,0,0,1,0,0,0,1},
                {0,0,0,0,0,0,1,0},
                {0,0,0,0,0,1,0,0},
                {0,0,0,0,1,0,0,0},
                {0,0,0,1,0,0,0,0},
                {0,0,1,0,0,0,0,0},
                {0,1,0,0,0,0,0,0},
                {1,0,0,0,0,0,0,0}};

        System.out.println("Lets see out array");
        Print_out_2dArray(chess_table);
        /*
        StringBuffer chess=new StringBuffer();
        for(int x=0;x<8;x++){
            for (int y=0;y<8;y++){
                chess.append(chess_table[y][x]).append(" ");
            }
            chess.append("\n");
        }
        System.out.println(chess);8*/

        System.out.println("Lets verify what is going on with the chess board");
        int marker=3;

        for(int z=0;z<8;z++){
            for (int l=0;l<8;l++)
            {
                if (chess_table[l][z] == 1){
                    sum=0;
                    for(int i=0;i<8;i++){
                        sum = sum + chess_table[i][z]+chess_table[l][i];
                    }
                    if (sum > 2){chess_table[l][z]=3;}
                }

            }
        }

        System.out.println("Lets see our array after verification ");
        Print_out_2dArray(chess_table);

        System.out.println("\n/*---------------------------------5----------------------------------------*/");
        System.out.println("TASK 5. Print out Fibonacci sequence");
        System.out.println("Please define amount of Fibonacci sequence elements whcih you would like to get visualized");
        int range_Fib=input.nextInt();
        StringBuffer fibonacci_Numbers = new StringBuffer();
        fibonacci_Numbers.append(0).append(" ").append(1).append(" ");

        BigDecimal fib_a=new BigDecimal(0);
        BigDecimal fib_b=new BigDecimal(1);
        for (int i =2; i< range_Fib;i++){

            fib_b = fib_b.add(fib_a);
            fibonacci_Numbers.append(fib_b.toString()).append(" ");
            fib_a=fib_b.subtract(fib_a);
        }

        System.out.println("Our desired result is : \n" + fibonacci_Numbers);

    }

    static void Print_out_2dArray(int[][] chess_table){
        StringBuffer chess_String=new StringBuffer();
        for(int x=0;x<8;x++){
            for (int y=0;y<8;y++){
                chess_String.append(chess_table[y][x]).append(" ");
            }
            chess_String.append("\n");
        }
        System.out.println(chess_String);
    } 
}
