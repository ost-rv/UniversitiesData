package org.example.models;

import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    @SerializedName("full_name")
    @XmlElement(name = "studentName", required = true)
    String fullName;

    @SerializedName("university_id")
    @XmlElement(name = "universityId", required = true)
    String universityId;

    @SerializedName("current_course_number")
    @XmlTransient
    int currentCourseNumber;

    @SerializedName("avg_exam_score")
    @XmlElement(name = "avgScore", required = true)
    float avgExamScore;

    public Student() {
    }

    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", universityId='" + universityId + '\'' +
                ", currentCourseNumber=" + currentCourseNumber +
                ", avgExamScore=" + avgExamScore +
                '}';
    }

}
