package com.adrian.taskPlanner.repositories;

import com.adrian.taskPlanner.pojos.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
