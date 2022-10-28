package com.chori.springStudy.model;


import lombok.Data;

@Data
public class Reply {

    private int id;
    private String content;
    private Board board;
    private User user;

}
