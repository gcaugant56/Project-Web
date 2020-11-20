package com.esiea.backend.repository;

import com.esiea.backend.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    Event getEventByName(String name);
    List<Event> findAllByParticipantContainingOrCreatorEquals(String username, String usernames);
}
