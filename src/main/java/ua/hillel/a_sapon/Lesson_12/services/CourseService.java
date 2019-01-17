package ua.hillel.a_sapon.Lesson_12.services;

import ua.hillel.a_sapon.Lesson_12.dao.interfaces.CourseDao;
import ua.hillel.a_sapon.Lesson_12.dao.staticDao.CourseDaoImpl;
import ua.hillel.a_sapon.Lesson_12.model.Course;
import ua.hillel.a_sapon.Lesson_12.model.Lesson;
import ua.hillel.a_sapon.Lesson_12.model.Student;

import java.util.List;

public class CourseService {
    Course crs;

    CourseService(Course cor){
        crs=cor;
    }

    private static CourseDaoImpl courseDao = new CourseDaoImpl();

    public static Course saveAllCource(Course course) {
        List<Lesson> lessons = course.getLessons();
        List<Student> students = course.getStudents();

        return courseDao.create(course);
    }
}
