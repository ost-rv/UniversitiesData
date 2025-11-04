package org.example.models;

import org.example.enums.StudyProfile;

import java.util.Optional;

public class Statistics {
    StudyProfile mainProfile;
    Optional<Double> avgExamScore;
    long countStudentByProfile;
    long countUniversityByProfile;
    String universityNames;

    public Statistics(StudyProfile mainProfile,
                      Optional<Double> avgExamScore,
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

    public Optional<Double> getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(Optional<Double> avgExamScore) {
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
