package com.bau.hotel.model;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Entry implements Serializable{

    private int id;
    private String title;
    private String entry;
    private Date createDate;
    private User author;
    private String map;
    private String imagePath;
    private List<String> tagList = new ArrayList<>();

//    public List<MultipartFile> getFiles() {
//        return files;
//    }
//
//    public void setFiles(List<MultipartFile> files) {
//        this.files = files;
//    }
//
//    private List<MultipartFile> files;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<String> getTagList() {
        return tagList;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    public void addTags(String[] tagArray){
        this.tagList.addAll( Arrays.asList(tagArray) );
    }

    public boolean hasAnyTags() {
        return this.tagList.size() > 0;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }
}
