package ua.hillel.a_sapon.Lesson_6.model;

import java.util.List;

public class Course {
    private Integer id;
    private String description;
    private List<Lesson> lessons;
    private Teacher teacher;
    private List<Student> students;
    private List<Task> tasks;

    public Course(Integer id, String description, List<Lesson> lessons, Teacher teacher, List<Student> students, List<Task> tasks) {
        this.id = id;
        this.description = description;
        this.lessons = lessons;
        this.teacher = teacher;
        this.students = students;
        this.tasks = tasks;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public void setDescription(String description) {
        this.description = description;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Course(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", lessons=" + lessons +
                ", teacher=" + teacher +
                ", students=" + students +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course courses = (Course) o;

        if (id != null ? !id.equals(courses.id) : courses.id != null) return false;
        return description != null ? description.equals(courses.description) : courses.description == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public void showHomeWork(){
        for (Student student : students){
            List <HomeWork> homeWorkList = student.getHomeWork();
            for(HomeWork homework: homeWorkList){
                System.out.println(student + " " + homework);

            }        }
    }
}
