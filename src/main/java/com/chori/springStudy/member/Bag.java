package com.chori.springStudy.member;

public class Bag { // 금액, 초대장, 티켓(금액, 티켓수, 총액) 유무.
    private int amount;
    private Invitation invitation;
    private Ticket ticket;



    public Bag(int amount) {
        this(null, amount);
    }

    public Bag(Invitation invitation, int amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    public boolean hasInvitation() {
        return invitation != null;
    }

    public boolean hasTicket() {
        return ticket != null;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void minusAmount(int amount) {
        this.amount -= amount;
    }

    public void plusAmount(int amount) {
        this.amount += amount;
    }
}
