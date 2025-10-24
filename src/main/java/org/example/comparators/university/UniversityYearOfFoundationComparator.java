package org.example.comparators.university;

import org.example.interfaces.IUniversityComparator;
import org.example.models.University;

public class UniversityYearOfFoundationComparator implements IUniversityComparator {
    @Override
    public int compare(University o1, University o2) {
        return Integer.compare(o1.getYearOfFoundation(), o2.getYearOfFoundation());
    }
}
