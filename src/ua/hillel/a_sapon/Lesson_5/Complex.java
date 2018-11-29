package ua.hillel.a_sapon.Lesson_5;

import java.util.concurrent.CompletionService;

/**
 * Class of complex numbers
 */
public class Complex {
    private double number;
    private double img;

    /**
    * Complex number zero constructor
    */
    Complex(){
        number=0;
        img=0;
    }

    /**
     * Complex number real numbers constructor
     */
    Complex(double number){
        this.number=number;
    }

    /**
     * Full scope constructor for number+i*img
     */
    Complex(double number, double img){
        this.number=number;
        this.img=img;
    }




}
