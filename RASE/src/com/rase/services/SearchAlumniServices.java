package com.rase.services;

import java.util.ArrayList;

import com.rase.model.Students;

public interface SearchAlumniServices {

	ArrayList<Students> search(String firstName);

	Students searchStudent(String email);

}
