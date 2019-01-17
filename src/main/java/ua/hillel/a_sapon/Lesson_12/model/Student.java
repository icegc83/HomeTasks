package ua.hillel.a_sapon.Lesson_12.model;

import ua.hillel.a_sapon.Lesson_12.model.Interface.DaoInterface;

import java.util.List;
import java.util.Objects;

public class Student implements DaoInterface {
    private Integer id;
    private String name;
    private List<HomeWork> homeWorkList;
    private String email;
    private String phone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(Integer id, String name, List<HomeWork> homeWorkList) {
        this.id = id;
        this.name = name;
        this.homeWorkList = homeWorkList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<HomeWork> getHomeWorkList() {
        return homeWorkList;
    }

    public void setHomeWorkList(List<HomeWork> homeWorkList) {
        this.homeWorkList = homeWorkList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void showHomeWorks() {
        for (HomeWork homeWork : homeWorkList) {
            System.out.println(homeWork);
        }
    }
}
