package com.dxctraining.onlinevideo.videomgt.dao;

import com.dxctraining.onlinevideo.videomgt.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVideoDao extends JpaRepository<Video,Integer> {

    /**
     *
     * find all videos uploaded by user
     */
    List<Video> findByUploaderUserId(Integer userId);
}
