package org.example.interfaces;

import org.example.models.University;

import java.util.Comparator;

public interface IUniversityComparator extends Comparator<University> {
    @Override
    int compare(University o1, University o2);
}
