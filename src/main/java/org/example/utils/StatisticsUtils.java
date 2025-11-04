package org.example.utils;

import org.example.enums.StudyProfile;
import org.example.models.Statistics;
import org.example.models.Student;
import org.example.models.University;

import java.util.*;
import java.util.stream.Collectors;

public class StatisticsUtils {

    public static List<Statistics> collectStatistics(List<Student> studentList, List<University> universityList) {

        List<Statistics> result = new ArrayList<>();

        var profileList = universityList.stream()
                    .map(University::getMainProfile)
                    .distinct()
                    .toList();

        for(StudyProfile profile : profileList) {

            var universityListByProfile = universityList.stream()
                    .filter(u -> u.getMainProfile() == profile)
                    .toList();

            Optional<Double> avgExamScore = Optional.of(studentList.stream()
                    .filter(s -> universityListByProfile.stream().anyMatch(u -> u.getId().equals(s.getUniversityId())))
                    .collect(Collectors.averagingDouble(Student::getAvgExamScore)));

            long countStudentByProfile = studentList.stream()
                    .filter(s -> universityListByProfile.stream().anyMatch(u -> u.getId().equals(s.getUniversityId())))
                    .count();

            long countUniversityByProfile = universityListByProfile.size();

            String universityNames = universityListByProfile.stream()
                    .map(University::getShortName)
                    .collect(Collectors.joining(", "));

            result.add(new Statistics(profile,
                    avgExamScore,
                    countStudentByProfile,
                    countUniversityByProfile,
                    universityNames));
        }
        return result;
    }
}
