package ua.hillel.a_sapon.Lesson_5;

import ua.hillel.a_sapon.Lesson_5.Complex;

/**
 * Создать класс Комплексных чисел
 */


public class Lesson_5 {
    public static void main(String[] args)
    {
        System.out.println("\n/*---------------------------------1----------------------------------------*/");
        System.out.println("TASK 1. Create class of Complex numbers and override all required methods");

        System.out.println("Lets perfrom some verification");
        Complex cmplx_1 = new Complex(5,6);
        Complex cmplx_2 = new Complex(-3,4);

        System.out.println("\nInitials Complex numbers are:" +
                "\n 1: " + cmplx_1.toString() +
                "\n 2: " + cmplx_2.toString() );

        System.out.println("\nLets see Img part of Complex 1 and Number part of Complex2 \n" +
                "\n1: " + cmplx_1.getImg() +
                "\n2: " + cmplx_2.getNumber() );

        System.out.println("\nLets find a sum of such " +
                "\nsum: " + cmplx_1.sum(cmplx_2));

        System.out.println("\nWhat about substraction " +
                "\nsubstruction: " + cmplx_1.substract(cmplx_2));

        System.out.println("\nNext is multiplication "+
                "\nmultiplication: " + cmplx_1.multiply(cmplx_2));

        System.out.println("\n... Divsion " +
                "\ndivision: " + cmplx_1.divideOn(cmplx_2));

        System.out.println("\n ... lets find Exponentiation for both complex number and power rate equal to 2 "+
                "\n1: " + cmplx_1.power(2) +
                "\n2: " + cmplx_2.power(2) );

        System.out.println("\n ... abs whih will be required for logical functions verification "+
                "\n1: " + cmplx_1.abs() +
                "\n2: " + cmplx_2.abs() );

        System.out.println("\n and as for the logical functions " +
                "\n let start with greater" +
                "\ncmplx_1 > cmplx_2  is " + cmplx_1.greater(cmplx_2) );

        System.out.println("\n next step is less or equal " +
                "\ncmplx_1 < cmplx_2 is " + cmplx_1.lessOrEqual(cmplx_2));

        System.out.println("\n\nLooks like ok for me" +
                "\n so wont be going further. " +
                "\n thank you for your attention and time");
    }
}
