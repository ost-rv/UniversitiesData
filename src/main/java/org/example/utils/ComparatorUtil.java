package org.example.utils;

import org.example.enums.StudentSortBy;
import org.example.enums.UniversitySortBy;
import org.example.interfaces.IStudentComparator;
import org.example.interfaces.IUniversityComparator;

public class ComparatorUtil {

    private ComparatorUtil() {
    }

    public static IStudentComparator getStudentComparator(StudentSortBy sortBy) {
        return sortBy.getComparator();
    }

    public static IUniversityComparator getUniversityComparator(UniversitySortBy sortBy) {
        return sortBy.getComparator();
    }
}
