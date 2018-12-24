package ua.hillel.a_sapon.Lesson_6.model;

public class HomeWork {
    private Integer id;
    private Lesson lesson;
    private Task task;

    public HomeWork(Lesson lesson, Task task) {
        this.lesson = lesson;
        this.task = task;
    }

    public HomeWork(Integer id, Lesson lesson, Task task) {
        this.id = id;
        this.lesson = lesson;
        this.task = task;
    }

    private int mark;

    @Override
    public String toString() {
        return "\nHomeWork{" +
                "id=" + id +
                ", lesson=" + lesson +
                ", task=" + task +
                ", mark=" + mark +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public Task getTask() {
        return task;
    }

    public int getMark() {
        return mark;
    }

    public Integer getId() {
        return id;
    }
}
