package org.example.comparators.student;

import org.apache.commons.lang3.StringUtils;
import org.example.interfaces.IStudentComparator;
import org.example.models.Student;

public class StudentUniversityIdComparator implements IStudentComparator {
    @Override
    public int compare(Student o1, Student o2) {
        return StringUtils.compare(o1.getUniversityId(), o2.getUniversityId());
    }
}
