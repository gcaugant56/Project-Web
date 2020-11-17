package com.esiea.backend.controller;

import com.esiea.backend.Event;
import com.esiea.backend.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5500")
public class EventController {
    @Autowired
    EventService eventService;

    @PostMapping("/event")
    @ResponseBody
    public boolean event(@RequestBody Event event)
    {
        return eventService.createEvent(event.getName(),event.getPlace(),event.getDate(),event.getParticipant(),event.getCreator());
    }


}
