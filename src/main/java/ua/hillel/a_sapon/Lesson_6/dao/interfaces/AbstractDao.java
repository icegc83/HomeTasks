package ua.hillel.a_sapon.Lesson_6.dao.interfaces;

import ua.hillel.a_sapon.Lesson_6.model.Course;

import java.util.List;

interface AbstractDao<T> {
    T create(T t);
    void update(T t);
    void delete(T t);
    T findById(Integer id );
    List<T> getAll();
}
