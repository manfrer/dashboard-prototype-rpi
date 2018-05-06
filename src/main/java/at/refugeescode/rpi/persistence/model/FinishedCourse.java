package at.refugeescode.rpi.persistence.model;

public class FinishedCourse {
    private String id;
    private String courseId;
    private String userId;

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
