package ua.hillel.a_sapon.Lesson_12.model;

import ua.hillel.a_sapon.Lesson_12.dao.staticDao.CourseDaoImpl;
import ua.hillel.a_sapon.Lesson_12.dao.staticDao.DaoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class University {

    private String description;

    private List<Teacher> teachers;
    DaoImpl<Teacher> daoImplTeacher = new DaoImpl();

    private List<Student> students;
    DaoImpl<Student> daoImplStudent = new DaoImpl();

    private List<Course> courses;
    DaoImpl<Course> daoImplCourses = new DaoImpl();

    private List<Task> tasks;
    DaoImpl<Task> daoImplTask = new DaoImpl();

    private List<HomeWork> homeWorks;
    DaoImpl<HomeWork> daoImplHomeWork = new DaoImpl();

    private List<Lesson> lessons;
    DaoImpl<Lesson> daoImplLesson = new DaoImpl();

    private List<Topic> topics;
    DaoImpl<Topic> daoImplTopic = new DaoImpl();


    //CourseDaoImpl dao = new CourseDaoImpl();

    @Override
    public String toString() {
        return "University{" +
                "\ndescription='" + description + '\'' +
                ", \nteachers=" + teachers +
                ", \nstudents=" + students +
                ", \ncourses=" + courses +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        University that = (University) o;

        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (teachers != null ? !teachers.equals(that.teachers) : that.teachers != null) return false;
        if (students != null ? !students.equals(that.students) : that.students != null) return false;
        if (courses != null ? !courses.equals(that.courses) : that.courses != null) return false;
        if (tasks != null ? !tasks.equals(that.tasks) : that.tasks != null) return false;
        if (homeWorks != null ? !homeWorks.equals(that.homeWorks) : that.homeWorks != null) return false;
        if (lessons != null ? !lessons.equals(that.lessons) : that.lessons != null) return false;
        return topics != null ? topics.equals(that.topics) : that.topics == null;
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (teachers != null ? teachers.hashCode() : 0);
        result = 31 * result + (students != null ? students.hashCode() : 0);
        result = 31 * result + (courses != null ? courses.hashCode() : 0);
        result = 31 * result + (tasks != null ? tasks.hashCode() : 0);
        result = 31 * result + (homeWorks != null ? homeWorks.hashCode() : 0);
        result = 31 * result + (lessons != null ? lessons.hashCode() : 0);
        result = 31 * result + (topics != null ? topics.hashCode() : 0);
        return result;
    }

    public University(String description) {

        this.description = description;

        teachers = IntStream.rangeClosed(1, 5)
                .mapToObj(x -> daoImplTeacher.create(new Teacher())
                ).collect(Collectors.toList());

        tasks = IntStream.rangeClosed(1, 5)
                .mapToObj(x -> daoImplTask.create(new Task(x, "Task " + x))
                ).collect(Collectors.toList());

        lessons = IntStream.rangeClosed(1, 5)
                .mapToObj(x -> daoImplLesson.create(new Lesson(x, "Lesson " + x))
                ).collect(Collectors.toList());

        homeWorks = getHomeWorks(lessons, tasks);

        students = IntStream.rangeClosed(1, 5)
                .mapToObj(x -> daoImplStudent.create(new Student(x, "Student " + x,
                        homeWorks))
                ).collect(Collectors.toList());

        topics = IntStream.rangeClosed(1,30)
                .mapToObj(x -> daoImplTopic.create(new Topic()))
                .collect(Collectors.toList());

        courses = IntStream.rangeClosed(1, 2)
                .mapToObj(x -> daoImplCourses.create(new Course("course " + x, lessons,
                        new Teacher(), students, tasks))
                ).collect(Collectors.toList());

    }

    private List<HomeWork> getHomeWorks(List<Lesson> lessons, List<Task> tasks)
    {
        int id = 1;
        List<HomeWork> result = new ArrayList<>();
        for (Lesson lesson : lessons) {
            for (Task task : tasks) {
                result.add(daoImplHomeWork.create(new HomeWork(id++, lesson
                        , task)));
            }
        }
        return result;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
        for(Teacher teach : this.teachers){
            daoImplTeacher.update(teach);
        }
    }

    public void setStudents(List<Student> students) {
        this.students = students;
        for(Student stdnt : this.students){
            daoImplStudent.update(stdnt);
        }
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
        for(Course crs : this.courses){
            daoImplCourses.update(crs);
        }
    }

    public String getDescription() {
        return description;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
