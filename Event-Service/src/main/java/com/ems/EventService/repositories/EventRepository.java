package com.ems.EventService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.EventService.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}

