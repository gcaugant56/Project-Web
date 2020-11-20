package com.esiea.backend.services;

import com.esiea.backend.Event;
import com.esiea.backend.repository.EventRepository;
import com.esiea.backend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private JwtUtil TokenUtil;

    public Event getEventByName(String name)
    {
        return eventRepository.getEventByName(name);
    }
    public boolean createEvent(String name, String place, String date, String participant,String creator)
    {
        Event event = new Event();
        event.setDate(date);
        event.setName(name);
        event.setParticipant(participant);
        event.setPlace(place);
        event.setCreator(creator);
        eventRepository.save(event);
        return true;
    }

    public List<Event> getEventForUser(String username, String usernames)
    {
        return eventRepository.findAllByParticipantContainingOrCreatorEquals(username, usernames);
    }

    public String getUsernameFromToken(String token)
    {
        token = token.substring(7);
        return TokenUtil.extractUsername(token);
    }
}
