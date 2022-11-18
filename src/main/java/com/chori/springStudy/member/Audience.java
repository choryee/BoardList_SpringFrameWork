package com.chori.springStudy.member;

public class Audience { // 가방 유무만.
    private Bag bag;

    public Audience(Bag bag){
        this.bag=bag;
    }

    public Bag getBag(){
        return bag;
    }
}
