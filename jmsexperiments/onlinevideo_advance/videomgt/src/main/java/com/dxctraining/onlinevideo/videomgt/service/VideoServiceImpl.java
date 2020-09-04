package com.dxctraining.onlinevideo.videomgt.service;

import com.dxctraining.onlinevideo.videomgt.dao.IVideoDao;
import com.dxctraining.onlinevideo.videomgt.entities.Video;
import com.dxctraining.onlinevideo.videomgt.exceptions.VideoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class VideoServiceImpl implements IVideoService{

    @Autowired
    private IVideoDao dao;

    @Override
    public Video save(Video video) {
        video= dao.save(video);
        return video;
    }

    @Override
    public Video findById(Integer id) {
        Optional<Video> optional=dao.findById(id);
        if(!optional.isPresent()){
            throw new VideoNotFoundException("video not found for id="+id);
        }
        return optional.get();
    }

    @Override
    public void deleteById(Integer id){
        dao.deleteById(id);
    }

    @Override
    public List<Video>findByUploaderUserId(Integer userId){
      List<Video>list=  dao.findByUploaderUserId(userId);
       return list;
    }

    @Override
    public void removeVideosUploadedByUser(Integer userId){
      List<Video>videos=  findByUploaderUserId(userId);
      dao.deleteAll(videos);
    }


}
