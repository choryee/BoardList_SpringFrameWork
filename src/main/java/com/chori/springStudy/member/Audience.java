package com.chori.springStudy.member;

import lombok.ToString;

import java.time.LocalDateTime;

@ToString
public class Audience { // 가방 유무만.
    private Bag bag;

    public Audience(Bag bag){
        this.bag=bag;
    }

    public Bag getBag(){
        return bag;
    }

    public String toString(Bag bag){
        return "Bag=====> "+this.bag;
    }

}
