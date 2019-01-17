package ua.hillel.a_sapon.Lesson_12.dao.interfaces;

import ua.hillel.a_sapon.Lesson_12.model.Course;

import java.util.List;

public interface CourseDao extends AbstractDao<Course> {

    @Override
    public Course create(Course course);

    @Override
    public void update(Course course);

    @Override
    public void delete(Course course);

    @Override
    public Course findbyId(Integer id) ;

    @Override
    public List<Course> getAll();
}
