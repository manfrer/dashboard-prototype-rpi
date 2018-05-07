package at.refugeescode.rpi.persistence.model;

import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;

public class EnrolledCourse {
    private String id;
    private String courseId;
    private String userId;

    public EnrolledCourse() {
    }

    public EnrolledCourse(String courseId, String userId) {
        this.courseId = courseId;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "EnrolledCourse{" +
                "id='" + id + '\'' +
                ", courseId='" + courseId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
