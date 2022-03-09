package com.venuebooking.venuebookingwork.Model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator,Long> {

    Administrator findBySuperID(Long superID);

    Administrator findBySuperName(String superName);

    void deleteBySuperID(Long superID);

    boolean existsBySuperID(Long superID);

    boolean existsBySuperName(String superName);

}
