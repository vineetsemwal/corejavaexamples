package com.dxctraining.oninevideo.usermgt.service;

import com.dxctraining.oninevideo.usermgt.dao.IUserDao;
import com.dxctraining.oninevideo.usermgt.entities.AppUser;
import com.dxctraining.oninevideo.usermgt.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserDao userDao;

    @Override
    public AppUser save(AppUser user) {
        user=userDao.save(user);
        return user;
    }

    @Override
    public AppUser findById(Integer id) {
       Optional<AppUser> optional=  userDao.findById(id);
        if(!optional.isPresent()){
            throw new UserNotFoundException("user not found fpr id="+id);
        }
        AppUser user= optional.get();
        return user;
      }

    @Override
    public List<AppUser> findByInterest(String interest) {
        List<AppUser>users=userDao.findByInterest(interest);
        return users;
    }

    @Override
    public void addVideo(String interest, Integer videoId){
        List<AppUser> users= userDao.findByInterest(interest);
        System.out.println("users found="+users.size());
        for (AppUser user:users){
            addVideo(user.getId(),videoId);
        }
    }

    @Override
    public void removeVideo(String interest, Integer videoId) {
        List<AppUser> users= userDao.findByInterest(interest);
        System.out.println("users found="+users.size());
        for (AppUser user:users){
            removeVideo(user.getId(),videoId);
        }
    }

    @Override
    public AppUser removeVideo(int userId, int videoId){
        AppUser user= findById(userId);
        Set<Integer> videos=  user.getVideos();
        if(videos==null){
            return user;
        }
        videos.remove(videoId);
        user=userDao.save(user);
        return user;
    }

    @Override
    public AppUser addVideo(int userId, int videoId){
       AppUser user= findById(userId);
        Set<Integer> videos=  user.getVideos();
        if(videos==null){
            videos=new HashSet<>();
            user.setVideos(videos);
        }
        videos.add(videoId);
        user=userDao.save(user);
        return user;
    }
}
