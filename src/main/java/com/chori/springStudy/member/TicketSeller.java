package com.chori.springStudy.member;

public class TicketSeller { //TicketOffice만 관계됨.
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice=ticketOffice;
    }

    public TicketOffice getTicketOffice(){
        return ticketOffice;
    }
}
