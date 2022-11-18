package com.chori.springStudy.member;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice { //금액조정, 티켓수 조정.
    private int amount;
    private List<Ticket> tickets=new ArrayList<>();

    public TicketOffice(int amount, Ticket ... tickets){ //생성자.
        this.amount=amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    public Ticket getTicket(){ //초대장받고, 대신 티켓은 하나 줄어드는 것.
        return tickets.remove(0);
    }

    public void minusAmount(int amount){
        this.amount-=amount;
    }

    public void plusAmount(int amount){
        this.amount+=amount;
    }


}