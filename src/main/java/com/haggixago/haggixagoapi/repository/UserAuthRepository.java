package com.haggixago.haggixagoapi.repository;

import com.haggixago.haggixagoapi.model.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, Integer> {
    public UserAuth findUserAuthByEmail(String email);
}
