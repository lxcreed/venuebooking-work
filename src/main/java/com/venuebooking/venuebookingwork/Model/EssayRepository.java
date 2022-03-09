package com.venuebooking.venuebookingwork.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

public interface EssayRepository extends JpaRepository<Essay,Long> {

    Essay findByEssayID(Long essayID);

    Essay findByPublishTime(String publishTime);

    ArrayList<Essay> findAll();

    @Modifying
    @Transactional
    void deleteByEssayID(Long essayID);

}
