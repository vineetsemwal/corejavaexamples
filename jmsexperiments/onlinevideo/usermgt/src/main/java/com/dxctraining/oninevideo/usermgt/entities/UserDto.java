package com.dxctraining.oninevideo.usermgt.entities;

import java.util.Set;

public class UserDto {
    private Integer id;

    private String name, interest;


    private Set<Integer> videos;

    public UserDto(){

    }

    public UserDto(Integer id,String name, String interest, Set<Integer> videos){
        this.id=id;
        this.name=name;
        this.interest=interest;
        this.videos = videos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public Set<Integer> getVideos() {
        return videos;
    }

    public void setVideos(Set<Integer> videos) {
        this.videos = videos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
