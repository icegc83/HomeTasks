package ua.hillel.a_sapon.Lesson_6.model;

public class Topic {
    private Integer id;
    private Lesson lesson;

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", lesson=" + lesson +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Integer getId() {
        return id;
    }

    public Lesson getLesson() {
        return lesson;
    }
}
