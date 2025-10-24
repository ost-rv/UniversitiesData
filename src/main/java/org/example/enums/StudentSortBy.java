package org.example.enums;

import org.example.comparators.student.StudentAvgExamScoreComparator;
import org.example.comparators.student.StudentCurrentCourseNumberComparator;
import org.example.comparators.student.StudentFullNameComparator;
import org.example.comparators.student.StudentUniversityIdComparator;
import org.example.interfaces.IStudentComparator;

public enum StudentSortBy {
    FULL_NAME(new StudentFullNameComparator()),
    UNIVERSITY_ID(new StudentUniversityIdComparator()),
    CURRENT_COURSE_NUMBER(new StudentCurrentCourseNumberComparator()),
    AVG_EXAM_SCORE(new StudentAvgExamScoreComparator());

    StudentSortBy(IStudentComparator comparator) {
        this.comparator = comparator;
    }

    IStudentComparator comparator;
    public IStudentComparator getComparator() {
        return comparator;
    }
}
