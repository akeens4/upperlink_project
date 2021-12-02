package com.project.upperlink.repository;

import com.project.upperlink.model.UpperlinkUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UpperlinkUserRepository extends JpaRepository<UpperlinkUser, Long> {

    Optional<UpperlinkUser> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE UpperlinkUser a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);

}
