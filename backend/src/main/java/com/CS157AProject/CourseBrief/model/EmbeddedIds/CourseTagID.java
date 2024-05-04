package com.CS157AProject.CourseBrief.model.EmbeddedIds;

import jakarta.persistence.Embeddable;

@Embeddable
public class CourseTagID implements java.io.Serializable{
    private String courseID;
    private String tagID;

    public CourseTagID() {
    }

    public CourseTagID(String courseID, String tagID) {
        this.courseID = courseID;
        this.tagID = tagID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getTagID() {
        return tagID;
    }

    public void setTagID(String tagID) {
        this.tagID = tagID;
    }

    // equals() and hashCode() methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseTagID)) return false;
        CourseTagID that = (CourseTagID) o;
        return getCourseID().equals(that.getCourseID()) && getTagID().equals(that.getTagID());
    }

    @Override
    public int hashCode() {
        int result = getCourseID().hashCode();
        result = 31 * result + getTagID().hashCode();
        return result;
    }
}
