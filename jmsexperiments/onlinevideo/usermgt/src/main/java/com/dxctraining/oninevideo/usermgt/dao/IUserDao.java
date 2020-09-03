package com.dxctraining.oninevideo.usermgt.dao;

import com.dxctraining.oninevideo.usermgt.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserDao extends JpaRepository<AppUser,Integer> {

    List<AppUser> findByInterest(String interest);

}
