package com.starrysky.infocollection.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode(of = {"id", "title"})
@ToString
public class Video {
    private String id;
    private String title;
    private String description;
    private String tag;
    private String author;
    private String arcurl;

    private int video_review;
    private int favorites;
    private int play;
    private String bvid;
}
