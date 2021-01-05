package com.rase.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rase.dao.DbConnection;
import com.rase.model.Events;
import com.rase.services.EventServices;

public class EventServicesImplementation implements EventServices {

	private static Connection connection= DbConnection.getConnection();
	
	@Override
	public List<Events> getAllEvents() {
		List<Events> events = new ArrayList<Events>();
		try(PreparedStatement prepStatement = connection.prepareStatement("SELECT * from events")) {
		ResultSet result = prepStatement.executeQuery();
		while(result.next()) {
			Events event = new Events();
			event.setEventId(result.getString("event_id"));
			event.setEventName(result.getString("event_name"));
			event.setCreatedOn(result.getDate("created_on"));
			event.setEventDate(result.getDate("event_date"));
			event.setLocation(result.getString("location"));
			events.add(event);
		}
		}
		catch(Exception e) {
			events = null;
			return events;
		}
		return events;
	}

	@Override
	public boolean addEvent(Events event) {
		
		try(PreparedStatement prepStatement = connection.prepareStatement("insert into events values (?,?,?,?,?)")) {
			prepStatement.setString(1, event.getEventId());
			prepStatement.setString(2, event.getEventName());
			prepStatement.setDate(3, event.getCreatedOn());
			prepStatement.setDate(4, event.getEventDate());
			prepStatement.setString(5,event.getLocation());
			
			if( prepStatement.executeUpdate() != 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public List<Events> getUserEvents(String email) {
		List<Events> events = new ArrayList<Events>();
		try(PreparedStatement prepStatement = connection.prepareStatement("Select * from events where event_id in (Select event_id from event_attend_by_students where email_id = (?)) ")) {
			prepStatement.setString(1, email);
			ResultSet result = prepStatement.executeQuery();
			while(result.next()) {
				Events event = new Events();
				event.setEventId(result.getString("event_id"));
				event.setEventName(result.getString("event_name"));
				event.setCreatedOn(result.getDate("created_on"));
				event.setEventDate(result.getDate("event_date"));
				event.setLocation(result.getString("location"));
				events.add(event);
			}
		}
		catch(Exception e) {
			events = null;
			return events;
		}
		return events;
	}

	@Override
	public boolean setUserEvents(String email, String eventId) {
		boolean response = false;
		try(PreparedStatement prepStatement = connection.prepareStatement("insert into event_attend_by_students values (?,?)")) {
			prepStatement.setString(1, email);
			prepStatement.setString(2, eventId);
			if( prepStatement.executeUpdate() != 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return response;
	}

	@Override
	public boolean removeEvent(String eventId) {
		boolean response = false;
		try(PreparedStatement prepStatement = connection.prepareStatement("delete from events where event_id=(?)")) {
			prepStatement.setString(1, eventId);
			if( prepStatement.executeUpdate() != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return response;
	}

	@Override
	public boolean removeUserEvent(String email, String eventId) {
		boolean response = false;
		try(PreparedStatement prepStatement = connection.prepareStatement("delete from event_attend_by_students where email_id = (?) and event_id=(?)")) {
			prepStatement.setString(1, email);
			prepStatement.setString(2, eventId);
			if( prepStatement.executeUpdate() != 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return response;
	}

	@Override
	public Events getEvent(String eventId) {
		Events event = null;
		
		try(PreparedStatement prepStatement = connection.prepareStatement("Select * from events where event_id = (?)")) {
		prepStatement.setString(1, eventId);
		ResultSet result = prepStatement.executeQuery();
		event = new Events();
		if(result.next()) {
			event.setEventId(result.getString("event_id"));
			event.setEventName(result.getString("event_name"));
			event.setCreatedOn(result.getDate("created_on"));
			event.setEventDate(result.getDate("event_date"));
			event.setLocation(result.getString("location"));
		}
		}
		catch(Exception e) {
			event = null;
		}
		return event;
	}

}
