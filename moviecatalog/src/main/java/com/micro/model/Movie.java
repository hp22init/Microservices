package com.micro.model;

public class Movie {

    private String movieId;
    private String name;
    private String desc;

    public Movie(){

    }

    public Movie(String name, String desc, String movieId) {
        this.name = name;
        this.desc = desc;
        this.movieId = movieId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
