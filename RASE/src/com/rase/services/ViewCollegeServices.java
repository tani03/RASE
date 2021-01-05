package com.rase.services;

import java.util.ArrayList;

import com.rase.model.College;
import com.rase.model.Course;

public interface ViewCollegeServices {
	ArrayList<College> sendCollege();

	ArrayList<College> sendCollegeList();

	ArrayList<Course> sendCourseListOfCollege(int collegeId);
	
	
}
