package com.venuebooking.venuebookingwork.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

public interface OrderFormRepository extends JpaRepository<OrderForm, Long> {

    OrderForm findByOrderFormID(Long orderFormID);

    ArrayList<OrderForm> findAllByUid(Long uid);

    ArrayList<OrderForm> findAllByVenueID(Long venueID);

    ArrayList<OrderForm> findAllByVenueName(String venueName);

    ArrayList<OrderForm> findAllByUidAndVenueID(Long uid, Long venueID);

    ArrayList<OrderForm> findAllByUidAndVenueName(Long uid, String venueName);

    boolean existsByUidAndOrderDay(Long uid, String orderDay);

    @Modifying
    @Transactional
    void deleteByOrderFormID(Long orderFormID);
}
