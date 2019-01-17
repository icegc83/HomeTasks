package ua.hillel.a_sapon.Lesson_12.model;

import ua.hillel.a_sapon.Lesson_12.model.Interface.DaoInterface;

import java.util.Objects;

public class Task implements DaoInterface {
    private Integer id;
    private String description;
    private Topic topic;

    public Task(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) &&
                Objects.equals(description, task.description) &&
                Objects.equals(topic, task.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, topic);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", topic=" + topic +
                '}';
    }
}


