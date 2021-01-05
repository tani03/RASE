package com.rase.services;

import com.rase.model.Course;
import com.rase.model.Students;

public interface RegisterServices {
	
	boolean checkEmailExist(String email);
	boolean registerStudents(Students students);

	boolean checkDuration(Course course, Students st);
}
