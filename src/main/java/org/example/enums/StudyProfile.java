package org.example.enums;

public enum StudyProfile {
    MEDICINE("Медицина"),
    PEDAGOGICAL("Педагогика"),
    ENGINEERING("Инженерия"),
    PHYSICS("Физический"),
    LINGUISTICS("Лингвистический"),
    MATHEMATICS("Математический");

    private final String profileName;

    private StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
