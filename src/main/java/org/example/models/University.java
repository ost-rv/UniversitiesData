package org.example.models;

import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.*;
import org.example.enums.StudyProfile;

@XmlAccessorType(XmlAccessType.FIELD)
public class University {

    @SerializedName("id")
    @XmlElement(name = "universityId", required = true)
    String id;

    @SerializedName("universityName")
    @XmlElement(name = "universityId", required = true)
    String fullName;

    @SerializedName("short_name")
    @XmlTransient
    String shortName;

    @SerializedName("year_of_foundation")
    @XmlTransient
    int yearOfFoundation;

    @SerializedName("main_profile")
    @XmlElement(name = "universityProfile", required = true)
    StudyProfile mainProfile;

    public University() {
    }

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    @Override
    public String toString() {
        return "University{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", mainProfile=" + mainProfile +
                '}';
    }
}
