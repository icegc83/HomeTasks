package ua.hillel.a_sapon.Lesson_3;

import java.math.BigDecimal;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 1. Написать метод считающий сколько в строке встречается определеный символ.
 * Посчитать в ваших инициалах из первой задачи сколько пробелов и звездочек.
 *
 * 2. Пользователь вводит целое десятичное число, требуется посчитать кольчиство едениц в двоичном предствлении этого числа.
 * пример 11 (десятичное) = 1011 (двоичное) программа должна вывести 3
 * подсказка Integer.toBinaryString
 * попробовать выполнить эту задачу без использования перевода в бинарную строку.
 *
 * 3. Реализавать в ItelliJ IDEA. Создать две ветки репозитория. В одной реализовать метод проверки является ли строка палидромом.
 * запаковать все в jar файл. Во ворой ветке "пристыковать" полученный в первой ветке jar файл и вызвать метод и вывести
 * результат. "Смёржить" эти две ветки.
 *
 * Палидромом считается строка которая читается сначала и с конца одинаково (пропуская пробелы и знаки табуляции).
 * к примеру «А роза упала на лапу Азора»
 *
 * 4. Реализовать программу собственного пенсионного накопления.
 * Изначально вы вклываете некоторую сумму в банк и каждый месяц пополняете данную сумму на фиксированую сумму.
 * Посчитать сколько будет ваш депозит на момент выхода на пенсию. Банк считает проценты по месяцам исходя из процентной ставки в год.
 * к примеру ставка 18% годовых. доход за месяц если вклад был 1000грн = 1000*18%/12.
 * Дополнительно по желанию можно посчитать если вклаываемая сумма будет расти каждый месяц и процентная ставка
 * уменьшаться каждый год.
 *
 * 5. Если у вас вызывается не отдельный метод по заданиям лекции 2 и лекции 1.
 * организовать все с вызовом отдельный методов с получением результата этого метода.
 *
 * 6. Переделать задачи лекции 2 с использованием IntStream. (По желанию)
 * Некоторые задачи которые используют строки не обязательно делать до следующего занятия. Строки пройдем в следующем занятии. Тогда и сделаем.
 */

public class Lesson_3 {

    void polyndromeVerifier(String string1)
    {

    }

    public static void main(String[] args) {

        System.out.println("\n/*---------------------------------1----------------------------------------*/");
        System.out.println("TASK 1. Написать метод считающий сколько в строке встречается определеный символ.\n" +
                "Посчитать в ваших инициалах из первой задачи сколько пробелов и звездочек.\n");

        String task1String = "__________________________________________\n" +
                "________*_____________***********_________\n" +
                "_______*_*___________**__________*________\n" +
                "______*___*__________**___________________\n" +
                "_____*_____*_________**___________________\n" +
                "____*********________**___________________\n" +
                "___*_________*_______**__________*________\n" +
                "__*___________*_0_____***********__0______\n" +
                "__________________________________________";

        System.out.println("Initial input for the task 1 was next \n" + task1String);
        Task4 task4= new Task4();
        task4.CountSymbols(task1String);

        System.out.println("\n/*---------------------------------2----------------------------------------*/");
        System.out.println("TASK 2. Пользователь вводит целое десятичное число, требуется посчитать кольчиство едениц в двоичном предствлении этого числа.\n" +
                "пример 11 (десятичное) = 1011 (двоичное) программа должна вывести 3\n" +
                "подсказка Integer.toBinaryString\n" +
                "попробовать выполнить эту задачу без использования перевода в бинарную строку.\n" +
                "\n");
        System.out.println("Please enter number:");
        Scanner input = new Scanner(System.in);
        int inputNumber = input.nextInt();
        //input.close();
        task4.Count_Binaries_with_StringUsage(inputNumber);
        task4.CountBinaries(inputNumber);

        System.out.println("\n/*----------------------------------3---------------------------------------*/");
        System.out.println("TASK 3. Реализавать в ItelliJ IDEA. Создать две ветки репозитория. В одной реализовать метод проверки является ли строка палидромом.\n" +
                "запаковать все в jar файл. Во ворой ветке \"пристыковать\" полученный в первой ветке jar файл и вызвать метод и вывести\n" +
                "результат. \"Смёржить\" эти две ветки.\n" +
                "\n" +
                "Палидромом считается строка которая читается сначала и с конца одинаково (пропуская пробелы и знаки табуляции).\n" +
                "к примеру «А роза упала на лапу Азора»\n");
        System.out.println("NOT DONE yet");

        System.out.println("\n/*----------------------------------4---------------------------------------*/");
        System.out.println("TASK 4. Реализовать программу собственного пенсионного накопления.\n" +
                "Изначально вы вклываете некоторую сумму в банк и каждый месяц пополняете данную сумму на фиксированую сумму.\n" +
                "Посчитать сколько будет ваш депозит на момент выхода на пенсию. Банк считает проценты по месяцам исходя из процентной ставки в год.\n" +
                "к примеру ставка 18% годовых. доход за месяц если вклад был 1000грн = 1000*18%/12.\n" +
                "Дополнительно по желанию можно посчитать если вклаываемая сумма будет расти каждый месяц и процентная ставка\n" +
                "уменьшаться каждый год.\n");

        Scanner input2 = new Scanner(System.in);
        System.out.println("Please define initial deposit :");
        double initial_deposit=input2.nextDouble();
        System.out.println("Please define fixed refill per month on your deposit :");
        double fixed_refill=input2.nextDouble();
        System.out.println("Please define interest rate of the bank :");
        double year_rate=input2.nextDouble();
        System.out.println("Please define months till the end of your pension :");
        int months_to_pension=input2.nextInt();
        input2.close();

        Pension pension= new Pension( initial_deposit,  fixed_refill, year_rate, months_to_pension);
        System.out.println("In result next deposit is going to wait for you "+ pension.Get_Deposite_Value_onPension_Start());

        System.out.println("\n/*----------------------------------5---------------------------------------*/");
        System.out.println("TASK 5. Если у вас вызывается не отдельный метод по заданиям лекции 2 и лекции 1.\n" +
                "организовать все с вызовом отдельный методов с получением результата этого метода.\n");
        System.out.println("DONE: Implemented initially with such approach");

        System.out.println("\n/*----------------------------------6---------------------------------------*/");
        System.out.println("TASK 6. Переделать задачи лекции 2 с использованием IntStream. (По желанию)\n" +
                "Некоторые задачи которые используют строки не обязательно делать до следующего занятия. Строки пройдем в следующем занятии. Тогда и сделаем. ");
        System.out.println("Lets generate at first an array of 100 \n");
        IntStream.range(1,100).map(j->j*j).forEach(x-> System.out.print(x+" "));

        System.out.println("\n\nTASK 6.1:  Print out first 5 array's elements greater than 10");
        IntStream.iterate(0,j->j+10).filter( x-> (x > 10)).limit(5).forEach(x->System.out.print(x+" "));

        System.out.println("\n\nTASK 6.2: Generate array of N size with elements from 1 до n \n");
        IntStream.iterate(0,i->i+1).limit(10).forEach(x->System.out.print(x+" "));

        System.out.println("\n\nTASK 6.3: Generate array of N size with elements from N tо 1 \n");
        IntStream.iterate(10,i->i-1).limit(10).forEach(x->System.out.print(x+" "));

        System.out.println("\n\nTASK 6.4: Print all elements which can be divided on 3 without remainder for array j->j*j");
        IntStream.range(1,100).map(j->j*j).filter(x-> x%3==0).forEach(x->System.out.print(x+" "));

        System.out.println("\n\nTASK 6.5: Print all elements which are even for array j->j*j");
        IntStream.range(1,100).map(j->j*j).filter(x->x%2==0).forEach(x->System.out.print(x+" "));

        System.out.println("\n\nTASK 6.6: Get sum of all array's elements for array j->j*j");
        int intSTR6_sum = IntStream.range(1,100).map(j->j*j).sum();
        System.out.println(" Sum is "+ intSTR6_sum);

        System.out.println("\n\nTASK 6.7: Get an average of all array's elements for array j->j*j");
        int intSTR7_everage = IntStream.range(1,100).map(j->j*j).sum()/100;
        System.out.println(" Average value is "+ intSTR7_everage);

        System.out.println("\n\nTASK 6.8: Get Maximum and minimum among array's elements and their sum for array j->j*j");
        int max = IntStream.range(1,100).map(j->j*j).max().getAsInt();
        int min = IntStream.range(1,100).map(j->j*j).min().getAsInt();
        System.out.println(" Max is " + max);
        System.out.println(" Min is " + min);
        System.out.println(" Max Min sum  is " + (max+min));

        System.out.println("\n\nTASK 6.9: Get Multiplicaiton of all not even elements for array j->j*j");
        BigDecimal bigDecimal = new BigDecimal(1);
        int[] int_array = IntStream.range(1,100).map(j->j*j).filter(x -> x%2 ==0).toArray();
        for (int arr_element: int_array)
        {
            bigDecimal = bigDecimal.multiply(new BigDecimal(arr_element));
        }
        System.out.println("Multiplication of all elements is " + bigDecimal.toBigInteger().toString());

        /*System.out.println("\n\nTask 6.10: Get an Index of particular element 2");
        System.out.println(" Max is " + IntStream.range(1,100).map(j->j*j).findAny());
*/



    }

}
