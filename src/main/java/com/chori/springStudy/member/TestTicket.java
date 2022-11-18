package com.chori.springStudy.member;

import java.time.LocalDateTime;

public class TestTicket {

    public static void main(String[] args) {
        //(파라미터)에 객체를 받아야 될때는, new 객체명()해야.
        Theater theater=new Theater(new TicketSeller(new TicketOffice(100, new Ticket() )));

        theater.enter(new Audience(new Bag(new Invitation(), 20)));

       // System.out.println(LocalDateTime.now());
        Ticket ticket=new Ticket();







    }
}
