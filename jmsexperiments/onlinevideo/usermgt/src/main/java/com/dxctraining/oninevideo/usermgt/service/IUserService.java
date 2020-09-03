package com.dxctraining.oninevideo.usermgt.service;

import com.dxctraining.oninevideo.usermgt.entities.AppUser;

import java.util.List;

public interface IUserService {

    AppUser save(AppUser user);

    AppUser findById(Integer id);

    List<AppUser> findByInterest(String interest);

    AppUser addVideo(int userId, int videoId);

    void addVideo(String interest, Integer videoId);
}
