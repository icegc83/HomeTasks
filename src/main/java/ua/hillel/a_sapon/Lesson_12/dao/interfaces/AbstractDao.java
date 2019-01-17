package ua.hillel.a_sapon.Lesson_12.dao.interfaces;

import java.util.List;

public interface AbstractDao<T> {

    T create(T course);
    void update(T course);
    void delete(T course);
    T findbyId(Integer id);
    List<T> getAll();
}
