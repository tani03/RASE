package com.rase.services;

import com.rase.model.Students;

public interface ModifyServices {

	boolean updateDetails(Students students);
	boolean deleteDetails (String email);

}
