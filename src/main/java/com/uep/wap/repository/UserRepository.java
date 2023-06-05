package com.uep.wap.repository;

import com.uep.wap.model.userTypes.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    // Add custom query methods if needed
}