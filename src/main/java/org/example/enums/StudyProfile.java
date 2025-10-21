package org.example.enums;

public enum StudyProfile {
    MEDICINE("Медицина"),
    PEDAGOGICAL("Педагогика"),
    ENGINEERING("Инженерия");

    private final String profileName;

    private StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
