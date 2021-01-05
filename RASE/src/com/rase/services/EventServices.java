package com.rase.services;

import java.util.List;
import com.rase.model.Events;

public interface EventServices {

	public List<Events> getAllEvents();
	public boolean addEvent(Events event);
	public boolean removeEvent(String eventId);
	public boolean setUserEvents(String email, String eventId);
	public List<Events> getUserEvents(String email);
	public boolean removeUserEvent(String email, String eventId);
	Events getEvent(String eventId);
}
