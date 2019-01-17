package ua.hillel.a_sapon.Lesson_12;


/*
        Создать систему классов школы Hillel.
        В системе должны присутствовать курсы,студенты,преподаватели,
         уроки, темы уроков,
        задания .
        Предусмотреть что преподаватель может вести несколько курсов и студент
        может посещать несколько курсов. Также создать методы для просмотра
        выполненных заданий для студента и для преподавателя по студентам.
*/


import ua.hillel.a_sapon.Lesson_12.dao.staticDao.CourseDaoImpl;
import ua.hillel.a_sapon.Lesson_12.dao.staticDao.DaoImpl;
import ua.hillel.a_sapon.Lesson_12.model.*;
import ua.hillel.a_sapon.Lesson_12.model.Interface.DaoInterface;
import ua.hillel.a_sapon.Lesson_12.services.CourseService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Task> tasks = IntStream.rangeClosed(1, 5)
                .mapToObj(x -> new Task(x, "Task " + x)
                ).collect(Collectors.toList());

        List<Lesson> lessons = IntStream.rangeClosed(1, 5)
                .mapToObj(x -> new Lesson(x, "Lesson " + x)
                ).collect(Collectors.toList());

        List<Student> students = IntStream.rangeClosed(1, 5)
                .mapToObj(x -> new Student(x, "Student " + x,
                        getHomeworks(lessons, tasks))
                ).collect(Collectors.toList());

      /*  List<Course> courses = IntStream.rangeClosed(1, 2)
                .mapToObj(x ->
                        new Course(x, "course " + x, lessons,
                                new Teacher(), students, tasks)
                ).collect(Collectors.toList());

        courses.forEach(course -> {
            Course course1 = CourseService.saveAllCource(course);
            System.out.println(course1);
        });

        System.out.println("---------------------");
        CourseDaoImpl courceDao = new CourseDaoImpl();
        Course course = courceDao.findbyId(11);
        System.out.println(course);*/

       /* for (Course cours : courses) {
            cours.showHomework();
            System.out.println("------------------------");
            System.out.println("------------------------");
        }
        System.out.println();*/
        /*System.out.println(LocalTime.now());
        List<Teacher> teachers =
                courses.stream()
                        .map(Course::getTeacher)
                        .distinct()
                        .collect(Collectors.toList());
        System.out.println(LocalTime.now());*/




        //CourseDaoImpl dao = new CourseDaoImpl();
        DaoImpl<Course> daoImpl = new DaoImpl();

        /*List<Course> coursesDao = IntStream.rangeClosed(1, 2)
                .mapToObj(x -> dao.create(new Course("course " + x, lessons,
                        new Teacher(), students, tasks))
                ).collect(Collectors.toList());

        System.out.println("------------------------");
        System.out.println("------------------------");
        coursesDao.forEach(crs -> {
            Course course2 = CourseService.saveAllCource(crs);
            System.out.println(course2);
        });*/


       List<Course> coursesDaoImpl = IntStream.rangeClosed(1, 2)
                .mapToObj(x -> daoImpl.create(new Course("course " + x, lessons,
                        new Teacher(), students, tasks))
                ).collect(Collectors.toList());

        System.out.println("------------------------");
        System.out.println("------------------------");
        coursesDaoImpl.forEach(crs2 -> {
            Course course3 = CourseService.saveAllCource(crs2);
            System.out.println(course3);
        });


        University university = new University("The greatest one");
        System.out.println("-----------U-------------");
        System.out.println("-----------U-------------");
        System.out.println(university);

    }

    private static List<HomeWork> getHomeworks(
            List<Lesson> lessons,
            List<Task> tasks) {
        int id = 1;
        List<HomeWork> result = new ArrayList<>();
        for (Lesson lesson : lessons) {
            for (Task task : tasks) {
                result.add(new HomeWork(id++, lesson
                        , task));
            }
        }
        return result;
    }

    private static List<HomeWork> getHomeworks2(
            List<Lesson> lessons,
            List<Task> tasks) {
        int id = 1;
        List<HomeWork> collect = lessons.stream()
                .flatMap(lesson -> tasks.stream()
                        .map(task -> new HomeWork(lesson, task)))
                .collect(Collectors.toList());
        for (HomeWork homeWork : collect) {
            homeWork.setId(id++);
        }
        return collect;

    }



}
