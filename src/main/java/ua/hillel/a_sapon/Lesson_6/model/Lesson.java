package ua.hillel.a_sapon.Lesson_6.model;

import java.util.List;
import java.util.stream.IntStream;

public class Lesson {
    private Integer id;
    private String description;

    public Lesson(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", topics=" + topics +
                '}';
    }

    private List<Topic> topics;

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public List<Topic> getTopics() {
        return topics;
    }
}
