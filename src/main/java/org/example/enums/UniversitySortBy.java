package org.example.enums;

import org.example.comparators.university.*;
import org.example.interfaces.IUniversityComparator;

public enum UniversitySortBy {
    FULL_NAME(new UniversityFullNameComparator()),
    SHORT_NAME(new UniversityShortNameComparator()),
    UNIVERSITY_ID(new UniversityIdComparator()),
    YEAR_OF_FOUNDATION(new UniversityYearOfFoundationComparator()),
    MAIN_PROFILE(new UniversityMainProfileComparator());


    UniversitySortBy(IUniversityComparator comparator) {
        this.comparator = comparator;
    }

    IUniversityComparator comparator;
    public IUniversityComparator getComparator() {
        return comparator;
    }

}
