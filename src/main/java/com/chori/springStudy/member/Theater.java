package com.chori.springStudy.member;

public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller){
        this.ticketSeller=ticketSeller;
    }

    //관중이 입장.
    public void enter(Audience audience){
        if(audience.getBag().hasInvitation()){ //관중의 가방 안에 초대장 있다면-> 그것을 티켓으로
            Ticket ticket=ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket); //관중은 가방에 티켓받음.
        }else {
            Ticket ticket=ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee()); // 관중은 돈 감소
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee()); // 매표소는 돈 증가.
            audience.getBag().setTicket(ticket); //관중은 가방에 티켓받음.

        }
    }


}
