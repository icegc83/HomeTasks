package ua.hillel.a_sapon.Lesson_13;

import ua.hillel.a_sapon.Lesson_12.model.University;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;
import java.util.Set;

public class DayFoWeek {

    public static void main(String[] args){

        LocalDate today=LocalDate.now();

        LocalDate nextFriday = today.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println(nextFriday);
        DayOfWeek dayOfWeek = today.getDayOfWeek();
        System.out.println(dayOfWeek);
        LocalDate leapYear = LocalDate.now();
        System.out.println(leapYear);

/*
        Scanner scann = new Scanner(System.in);
        String s = scann.nextLine();
*/
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY/M/D");
        System.out.println(today.format(dateTimeFormatter));


        LocalDate parse = LocalDate.parse("2018-12-19");
        System .out.println(LocalDate.now());

        System.out.println("-------LocalDateTime-------");
        LocalDateTime localDateTime = LocalDateTime.now();
        dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println(localDateTime);
        System.out.println(localDateTime.format(dateTimeFormatter));

        University university = new University("The Best");
        LocalTime lT = LocalTime.of(19,15);
//        String stringLT2 = (String) LocalTime.parse("19:20").format("HH:MM");
        LocalTime lT2 = LocalTime.parse("19:20",DateTimeFormatter.ofPattern("HH:mm"));
        System.out.println(lT + "  \t" + lT2);
/*        ZonedDateTime zonedDateTimeOur = ZonedDateTime.now();
        Set<String> setZoneID = ZoneId.getAvailableZoneIds();
        for(gZId : setZoneID){
            System.out.println(gZId);
        }
        ZonedDateTime zonedDateTime = ZonedDateTime.now(new ZoneId);
    */


    Period period = Period.between(LocalDate.of(1983,03,10), LocalDate.now());
    long days = period.getDays();
    long years = period.getYears();
    long months = period.getMonths();

    System.out.println("Days:" + days + " Months:" + months + " Years:" + years);
    System.out.println("DaysInTotal:" + ChronoUnit.DAYS.between(LocalDate.of(1983,03,10), LocalDate.now()));
    System.out.println("MonthsInTotal:" + ChronoUnit.MONTHS.between(LocalDate.of(1983,03,10), LocalDate.now()));
    System.out.println("YearsInTotal:" + ChronoUnit.YEARS.between(LocalDate.of(1983,03,10), LocalDate.now()));

    System.out.println("Days in year" + ChronoUnit.DAYS.between(LocalDate.of(2018,12,31),LocalDate.of(2017,12,31)));
    System.out.println("Days in year" + ChronoUnit.MINUTES);
    /*System.out.println("Minutes in year" +ChronoUnit.MINUTES.between());*/





    }
}
