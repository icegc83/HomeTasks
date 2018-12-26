package ua.hillel.a_sapon.Lesson_12.dao.staticDao;

import ua.hillel.a_sapon.Lesson_12.dao.interfaces.AbstractDao;
import ua.hillel.a_sapon.Lesson_12.model.Course;
import ua.hillel.a_sapon.Lesson_12.model.Interface.DaoInterface;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DaoImpl<T extends DaoInterface> implements AbstractDao<T> {
    //not static ... static will cause an error

    private Map<Integer, T> t =
            new LinkedHashMap<>();
    static private int i = 70;

    @Override
    public T create(T t) {
        int id = i++;
        t.setId(id);
        this.t.put(id, t);
        return t;
    }

    @Override
    public void update(T t) {
        Integer id = t.getId();
        this.t.put(id, t);
    }

    @Override
    public void delete(T t) {
        this.t.remove(t.getId());
    }

    @Override
    public T findbyId(Integer id) {
        return this.t.get(id);
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(this.t.values());
    }
}
