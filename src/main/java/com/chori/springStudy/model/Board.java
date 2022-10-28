package com.chori.springStudy.model;

import lombok.Data;

import java.util.List;

@Data
public class Board {

    private int id;
    private String title;
    private String content;
    private int count;


    private User user;

    private List<Reply> reply;


}
