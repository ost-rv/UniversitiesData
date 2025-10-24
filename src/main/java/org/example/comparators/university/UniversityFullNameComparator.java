package org.example.comparators.university;

import org.apache.commons.lang3.StringUtils;
import org.example.interfaces.IUniversityComparator;
import org.example.models.University;

public class UniversityFullNameComparator implements IUniversityComparator {
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getFullName(), o2.getFullName());
    }
}
