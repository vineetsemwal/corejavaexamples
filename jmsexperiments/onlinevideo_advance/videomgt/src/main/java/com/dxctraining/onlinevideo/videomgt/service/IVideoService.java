package com.dxctraining.onlinevideo.videomgt.service;

import com.dxctraining.onlinevideo.videomgt.entities.Video;

import java.util.List;

public interface IVideoService {

    Video save(Video video);

    Video findById(Integer id);

    void deleteById(Integer id);

    List<Video> findByUploaderUserId(Integer userId);

    void removeVideosUploadedByUser(Integer userId);
}
