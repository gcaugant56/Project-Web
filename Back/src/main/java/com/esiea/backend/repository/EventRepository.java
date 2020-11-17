package com.esiea.backend.repository;

import com.esiea.backend.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
    Event getEventByName(String name);
}
