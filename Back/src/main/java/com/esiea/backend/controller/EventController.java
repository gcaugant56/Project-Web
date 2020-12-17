package com.esiea.backend.controller;

import com.esiea.backend.Event;
import com.esiea.backend.services.EventService;
import com.esiea.backend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class EventController {
    @Autowired
    EventService eventService;

    @Autowired
    private JwtUtil TokenUtil;

    @PostMapping("/event/create")
    @ResponseBody
    public boolean event(@RequestBody Event event, @RequestHeader Map<String,String> headers)
    {
        if(!event.getDate().equals("") && !event.getName().equals("") && !event.getParticipant().equals("") && !event.getPlace().equals(""))
        {
            String token = headers.get("authorization");
            token = token.substring(7);
            token = TokenUtil.extractUsername(token);
            boolean result =  eventService.createEvent(event.getName(),event.getPlace(),event.getDate(),event.getParticipant(),token);
            System.out.println(result);
            return result;
        }
        return false;
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
