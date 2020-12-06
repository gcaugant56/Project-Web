package com.esiea.backend.controller;

import com.esiea.backend.Event;
import com.esiea.backend.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5500")
public class EventController {
    @Autowired
    EventService eventService;

    @PostMapping("/event/create")
    @ResponseBody
    public boolean event(@RequestBody Event event)
    {
        return eventService.createEvent(event.getName(),event.getPlace(),event.getDate(),event.getParticipant(),event.getCreator());
    }
    @GetMapping("/event/all")
    @ResponseBody
    public List<Event> getEvent(@RequestHeader("Authorization") Map<String, String> headers)
    {
        String username = eventService.getUsernameFromToken(headers.get("authorization"));
        return eventService.getEventForUser(username,username);
    }
    @PostMapping("/event/delete")
    @ResponseBody
    public boolean deleteEvent(Event event)
    {
        return eventService.deleteEvent(event);
    }
}
