package com.venuebooking.venuebookingwork.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

public interface VenueRepository extends JpaRepository<Venue,Long> {

    Venue findByVenueID(Long venueID);

    Venue findByVenueName(String venueName);

    ArrayList<Venue> findAll();


    @Modifying
    @Transactional
    void deleteByVenueID(Long venueID);

}
