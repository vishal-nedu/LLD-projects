package com.zsgs.NoolNikarchi.repository.dto;

public class SearchFilter {
    private String name;
    private String author;
    private String genre;
    private Integer publishedYearFrom;
    private Integer publishedYearTo;
    private Boolean availableOnly;

    public Boolean getAvailableOnly() {
        return availableOnly;
    }

    public void setAvailableOnly(Boolean availableOnly) {
        this.availableOnly = availableOnly;
    }

    public Integer getPublishedYearTo() {
        return publishedYearTo;
    }

    public void setPublishedYearTo(Integer publishedYearTo) {
        this.publishedYearTo = publishedYearTo;
    }

    public Integer getPublishedYearFrom() {
        return publishedYearFrom;
    }

    public void setPublishedYearFrom(Integer publishedYearFrom) {
        this.publishedYearFrom = publishedYearFrom;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}