package ua.hillel.a_sapon.Lesson_6;


import ua.hillel.a_sapon.Lesson_6.model.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Создать структуру классов описывающих Хиллель, студентов и все что необходимо ...
 */


public class Lesson6 {
    public static void main(String args[]) {

        System.out.println("\n/*---------------------------------1----------------------------------------*/");
        System.out.println("TASK 1. Need to define structure of Hillel and everything related to it with students, teachers, etc ...");

        //List<Courses> courses = new ArrayList<>();
        List<Task> tasks = IntStream.rangeClosed(1,5)
                .mapToObj(x -> new Task(x,"Task" + x))
                .collect(Collectors.toList());

        List<Lesson> lessons = IntStream.rangeClosed(1,5)
                .mapToObj(x -> new Lesson(x, "Lesson" + x))
                .collect(Collectors.toList());

        List<Student> students = IntStream.rangeClosed(1,5)
                .mapToObj(x -> new Student(x, "student" + x, getHomeWork(lessons,tasks)))
                .collect(Collectors.toList());

        List<Course> courses = IntStream.rangeClosed(1, 2).mapToObj(x -> new Course(x,"courses " + x, lessons , new Teacher(), students, tasks)).collect(Collectors.toList());
        System.out.println(LocalTime.now());



/*
        Set<Student> students = IntStream.rangeClosed(1, 1000000).mapToObj(x -> new Student()).collect(Collectors.toList());
        System.out.println(LocalTime.now());
*/

        Set<Teacher> teachers = courses.stream().map(Course::getTeacher).collect(Collectors.toSet());
        System.out.println(LocalTime.now());



        System.out.println(LocalTime.now());

        for(Course crs : courses){
            crs.showHomeWork();
            System.out.println("--------------------------");
            System.out.println("--------------------------");

        }
        System.out.println();



        // or
        //List<Teacher> teachers = courses.stream().map(Courses::getTeacher).distinct().collect(Collectors.toList());


    }
    //Person -> Employee, Student, Teacher, Visitor

    private static List<HomeWork> getHomeWork(
                List<Lesson> lessons,
                List<Task> tasks){
        int id = 1;
        List<HomeWork> result = new ArrayList<>();
        for(Lesson lesson : lessons){
            for(Task task : tasks){
                result.add(new HomeWork(id++, lesson, task));
            }
        }
        return result;
    }

    private static List<HomeWork> getHomework2(
            List<Lesson> lessons,
            List<Task> tasks){
        int id=1;
        List<HomeWork> collect = lessons.stream()
                .flatMap(lesson -> tasks.stream()
                    .map(task -> new HomeWork(lesson, task)))
                .collect(Collectors.toList());
        for(HomeWork homeWork : collect){
            homeWork.setId(id++);
        }
        return collect;
    }


}
