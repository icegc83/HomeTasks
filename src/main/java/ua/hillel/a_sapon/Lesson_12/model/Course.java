package ua.hillel.a_sapon.Lesson_12.model;

import ua.hillel.a_sapon.Lesson_12.model.Interface.DaoInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Course implements DaoInterface {
    private Integer id;
    private String description;
    private List<Lesson> lessons;
    private Teacher teacher;
    private List<Student> students;
    private List<Task> tasks;


    public Course(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Course(
                  String description,
                  List<Lesson> lessons,
                  Teacher teacher,
                  List<Student> students,
                  List<Task> tasks) {

        this.description = description;
        this.lessons = lessons;
        this.teacher = teacher;
        this.students = students;
        this.tasks = tasks;
    }

    public Course(Integer id,
                  String description,
                  List<Lesson> lessons,
                  Teacher teacher,
                  List<Student> students,
                  List<Task> tasks) {
        this.id = id;
        this.description = description;
        this.lessons = lessons;
        this.teacher = teacher;
        this.students = students;
        this.tasks = tasks;
    }

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

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) &&
                Objects.equals(description, course.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    public void showHomework() {

        for (Student student : students) {
            List<HomeWork> homeWorkList = student.getHomeWorkList();
            for (HomeWork homeWork : homeWorkList) {
                System.out.println(student + " " + homeWork);
            }
        }
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
