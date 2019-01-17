package ua.hillel.a_sapon.Lesson_12.model;

import ua.hillel.a_sapon.Lesson_12.model.Interface.DaoInterface;

public class Topic implements DaoInterface {
    private Integer id;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
