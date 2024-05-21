package com.adrian.taskPlanner.repositories;

import com.adrian.taskPlanner.pojos.SecurityUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SecurityUserRepository extends CrudRepository<SecurityUser, Long> {
    @Query("SELECT u FROM SecurityUser u WHERE u.username = :username")
    public SecurityUser getUserByUsername(@Param("username") String username);
}
