package com.dxctraining.onlinevideo.videomgt.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Video {
    @GeneratedValue
    @Id
    private Integer id;

    private String description, interest;

    private Integer uploaderUserId;

    public Video(){

    }

    public Video( String interest, String desc,Integer uploaderUserId){
        this.interest=interest;
        this.description=desc;
        this.uploaderUserId=uploaderUserId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public Integer getUploaderUserId() {
        return uploaderUserId;
    }

    public void setUploaderUserId(Integer uploaderUserId) {
        this.uploaderUserId = uploaderUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return Objects.equals(id, video.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
