package ua.hillel.a_sapon.Lesson_6.model;

import java.util.List;

public class Task {
    private Topic topic;
    private Integer is;
    private String description;

    public Task(Integer is, String description) {
        //this.topic = topic;
        this.is = is;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "topic=" + topic +
                ", is=" + is +
                ", description='" + description + '\'' +
                '}';
    }

    public void setIs(Integer is) {
        this.is = is;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIs() {
        return is;
    }

    public String getDescription() {
        return description;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Topic getTopic() {
        return topic;
    }
}
