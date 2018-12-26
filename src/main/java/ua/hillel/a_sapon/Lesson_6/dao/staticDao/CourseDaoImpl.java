package ua.hillel.a_sapon.Lesson_6.dao.staticDao;

import ua.hillel.a_sapon.Lesson_6.dao.interfaces.CourseDao;
import ua.hillel.a_sapon.Lesson_6.model.Course;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CourseDaoImpl implements CourseDao {
    private static Map<Integer,Course> courses = new LinkedHashMap<>();
    private static int i=0;

    @Override
    public Object create(Object o) {
        return null;
    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public Object findById(Integer id) {
        return null;
    }

    @Override
    public List getAll() {
        return null;
    }
/*    @Override
    public List<Course> getAll() {

        return new ArrayList<>(courses.values());
    }

    @Override
    public Course create(Course course) {

        int id = i++;
        course.setId(id++);
        courses.put(id, course);
        return course;
    }

    @Override
    public void update(Course course) {
        Integer id = course.getId();
        courses.put(id,course);
    }

    @Override
    public void delete(Course course) {
        courses.remove(course.getId());
    }

    @Override
    public Course findById(Integer id) {
        return null;
    }*/
}
