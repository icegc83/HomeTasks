package ua.hillel.a_sapon.Lesson_6.model;

import java.util.List;

public class Student {
    private Integer id;
    private String name;
    private List<HomeWork> homeWork;

    public Student(Integer id, String name, List<HomeWork> homeWork) {
        this.id = id;
        this.name = name;
        this.homeWork = homeWork;
    }

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", homeWork=" + homeWork +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != null ? !id.equals(student.id) : student.id != null) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        return homeWork != null ? homeWork.equals(student.homeWork) : student.homeWork == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (homeWork != null ? homeWork.hashCode() : 0);
        return result;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHomeWork(List<HomeWork> homeWork) {
        this.homeWork = homeWork;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<HomeWork> getHomeWork() {
        return homeWork;
    }
}
