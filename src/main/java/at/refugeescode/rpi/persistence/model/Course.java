package at.refugeescode.rpi.persistence.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Course {
    @Id
    private String id;
    private String moodleCourseId;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMoodleCourseId() {
        return moodleCourseId;
    }

    public void setMoodleCourseId(String moodleCourseId) {
        this.moodleCourseId = moodleCourseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", moodleCourseId='" + moodleCourseId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
