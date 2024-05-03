package com.CS157AProject.CourseBrief.model.EmbeddedIds;

import jakarta.persistence.Embeddable;

@Embeddable
public class StarredCoursesID implements java.io.Serializable {
    private String courseID;
    private String userID;

    public StarredCoursesID() {
    }

    public StarredCoursesID(String courseID, String userID) {
        this.courseID = courseID;
        this.userID = userID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    // equals() and hashCode() methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StarredCoursesID)) return false;
        StarredCoursesID that = (StarredCoursesID) o;
        return getCourseID().equals(that.getCourseID()) && getUserID().equals(that.getUserID());
    }

    @Override
    public int hashCode() {
        int result = getCourseID().hashCode();
        result = 31 * result + getUserID().hashCode();
        return result;
    }
}
