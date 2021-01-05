package com.rase.services;
import java.util.List;
import com.rase.model.College;
import com.rase.model.Course;

public interface AdminCollegeServices {
	boolean checkCollegeNameExists(String collegeName, int collegeId);
	boolean addCollegeDetails(College college, Course course);
	boolean removeCollege(int collegeId);
	
	
	

}
