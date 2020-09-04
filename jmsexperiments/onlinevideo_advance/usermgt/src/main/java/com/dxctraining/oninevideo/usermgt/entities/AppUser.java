package com.dxctraining.oninevideo.usermgt.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class AppUser {

    @GeneratedValue
    @Id
    private Integer id;

    private String name, interest;

    /**
     * this field holds videos suggested to the user
     */
    @ElementCollection
    private Set<Integer> videos;

    public AppUser(){

    }

    public AppUser(String name, String interest){
        this.name=name;
        this.interest=interest;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(id, appUser.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
