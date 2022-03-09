package com.venuebooking.venuebookingwork.Model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueDayRepository extends JpaRepository<VenueDay, Long> {

    VenueDay findByVenueDayID(Long venueDayID);

}
