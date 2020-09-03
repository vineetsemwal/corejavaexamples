package com.dxctraining.onlinevideo.videomgt.dao;

import com.dxctraining.onlinevideo.videomgt.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVideoDao extends JpaRepository<Video,Integer> {
}
