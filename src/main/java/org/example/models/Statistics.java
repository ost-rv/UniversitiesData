package org.example.models;

import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.*;
import org.example.enums.StudyProfile;

@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {

    @XmlElement(name = "universityProfile", required = true)
    @SerializedName("universityProfile")
    StudyProfile mainProfile;

    @XmlElement(name = "avgScore")
    @SerializedName("avgScore")
    Double avgExamScore;

    transient long countStudentByProfile;

    transient long countUniversityByProfile;

    transient String universityNames;

    public Statistics(StudyProfile mainProfile,
                      Double avgExamScore,
                      long countStudentByProfile,
                      long countUniversityByProfile,
                      String universityNames) {
        this.mainProfile = mainProfile;
        this.avgExamScore = avgExamScore;
        this.countStudentByProfile = countStudentByProfile;
        this.countUniversityByProfile = countUniversityByProfile;
        this.universityNames = universityNames;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    public Double getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(Double avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public long getCountStudentByProfile() {
        return countStudentByProfile;
    }

    public void setCountStudentByProfile(int countStudentByProfile) {
        this.countStudentByProfile = countStudentByProfile;
    }

    public long getCountUniversityByProfile() {
        return countUniversityByProfile;
    }

    public void setCountUniversityByProfile(int countUniversityByProfile) {
        this.countUniversityByProfile = countUniversityByProfile;
    }

    public String getUniversityNames() {
        return universityNames;
    }

    public void setUniversityNames(String universityNames) {
        this.universityNames = universityNames;
    }
}
