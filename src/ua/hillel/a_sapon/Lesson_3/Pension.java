package ua.hillel.a_sapon.Lesson_3;

import java.math.BigDecimal;

public class Pension {
    double initial_deposit=0;
    double fixed_refill=0;
    double year_rate=0;
    int months_to_pension=0;


    /**
     * Constructor Pension(double ,double ,double ,int )
     * @param initial_deposit - initial deposit to the bank
     * @param fixed_refill - fixed rate of each month refill
     * @param year_rate - bank's rate per year
     * @param months_to_pension - amount of months till pension
     */
    Pension(double initial_deposit, double fixed_refill,double year_rate,int months_to_pension){
        if(initial_deposit>0)
            this.initial_deposit=initial_deposit;
        else
            this.initial_deposit=0;

        if(fixed_refill>0)
            this.fixed_refill=fixed_refill;
        else
            this.fixed_refill=0;

        if(year_rate>0)
            if (year_rate<100)
                this.year_rate=year_rate;
            else
                this.year_rate=100;
        else
            this.year_rate=0;

        if (months_to_pension>0)
            this.months_to_pension=months_to_pension;
        else
            this.months_to_pension=0;
    }

    String Get_Deposite_Value_onPension_Start(){
        BigDecimal full_deposite = new BigDecimal(initial_deposit);
        for (int i =0; i<months_to_pension;i++)
        {
            full_deposite = full_deposite.add(BigDecimal.valueOf(fixed_refill));
            full_deposite = full_deposite.multiply(BigDecimal.valueOf((100+year_rate/24)/100));

        }

        return full_deposite.toBigInteger().toString();
    }


}