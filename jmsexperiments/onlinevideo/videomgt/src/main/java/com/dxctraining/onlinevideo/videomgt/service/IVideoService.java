package com.dxctraining.onlinevideo.videomgt.service;

import com.dxctraining.onlinevideo.videomgt.entities.Video;

public interface IVideoService {

    Video save(Video video);

    Video findById(Integer id);

}
