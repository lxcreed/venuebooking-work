package com.venuebooking.venuebookingwork.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface UserRepository extends JpaRepository<User,Long> {


    User findByUid(Long uid);

    User findByUserName(String userName);

    void deleteByUid(Long uid);

    Boolean existsByUserName(String userName);

    Boolean existsByUid(Long uid);


}
