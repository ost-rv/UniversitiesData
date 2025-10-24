package org.example.comparators.university;

import org.apache.commons.lang3.StringUtils;
import org.example.interfaces.IUniversityComparator;
import org.example.models.University;

public class UniversityIdComparator implements IUniversityComparator {
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getId(), o2.getId());
    }
}
