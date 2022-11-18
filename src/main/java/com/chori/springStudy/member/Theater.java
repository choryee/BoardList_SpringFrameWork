package com.chori.springStudy.member;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller){ //ticketSeller는 ticketOffice만 있음.
        this.ticketSeller=ticketSeller;
    }

    //관중이 입장.
    public Ticket enter(Audience audience){ //audience는 Bag만 있음.
        if(audience.getBag().hasInvitation()){ //관중의 가방 안에 초대장 있다면-> 그것을 티켓으로
            Ticket ticket=ticketSeller.getTicketOffice().getTicket(); //getTicket() 이건 티켓 하나 주는 것.
            audience.getBag().setTicket(ticket); //관중은 가방에 티켓받음.
            Ticket ticketA=audience.getBag().getTicket();
            System.out.println("====ticketA====>" + ticketA);
        }else {
            Ticket ticket=ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee()); // 관중은 돈 감소
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee()); // 매표소는 돈 증가.
            audience.getBag().setTicket(ticket); //관중은 가방에 티켓받음.

        }//--if
        return new Ticket(); // public Ticket이 리턴형이라, 반환형이 new Ticket();임 됨.
    }

    public static void main(String[] args) {
        //(파라미터)에 객체를 받아야 될때는, new 객체명()해야.
       // Theater theater=new Theater(new TicketSeller(new TicketOffice(100, new Ticket() )));
        Ticket ticket=new Ticket();

        List<Ticket> tickets=new ArrayList<>();
        tickets.add(new Ticket("A"));
        tickets.add(new Ticket("B"));
        tickets.add(new Ticket("C"));
       /*
        for (Ticket :
                tickets) {
            System.out.println(tickets);
        }*/

        for(int i=0; i<tickets.size(); i++){
            System.out.println("=====>"+tickets);
        }



       // TicketOffice ticketOffice1=new TicketOffice(10,A);
        //TicketOffice ticketOffice2=new TicketOffice(10,B);
        //TicketOffice ticketOffice3=new TicketOffice(10,C);
       // TicketOffice ticketOffic4=new TicketOffice(10,D);

/*
        //TicketSeller ticketSeller1=new TicketSeller(new TicketOffice(10, new Ticket()));

        TicketSeller ticketSeller3=new TicketSeller(new TicketOffice(1, new Ticket("B")));
        TicketSeller ticketSeller4=new TicketSeller(new TicketOffice(1, new Ticket("C")));
        ticketSeller2.getTicketOffice().getTicket();
        */

        TicketSeller ticketSeller2=new TicketSeller(new TicketOffice(1, ticket));
        Theater theater =new Theater(ticketSeller2);

       // theater.enter(new Audience(new Bag(new Invitation(), 20)));
       // System.out.println(theater.enter(new Audience(new Bag(new Invitation(), 20))));

        Invitation invitation1=new Invitation();
        invitation1.setWhen(LocalDateTime.now());

        Bag bag1=new Bag(invitation1,11);

        Audience audience=new Audience(bag1);
        System.out.println("=ticketSeller2.getTicketOffice().getTicket()====> "+ticketSeller2.getTicketOffice().getTicket() );
        System.out.println("==invitation1.getWhen()======> "+ invitation1.getWhen());
        System.out.println("==audience.getBag().hasInvitation()======> "+audience.getBag().hasInvitation());
        System.out.println("==bag1.getAmount()======> "+ bag1.getAmount());

        theater.enter(audience);
        System.out.println("+++++++> "+theater.enter(audience));





    }


}
