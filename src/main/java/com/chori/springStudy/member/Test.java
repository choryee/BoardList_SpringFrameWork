package com.chori.springStudy.member;

public class Test {

    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        ticket.setNumber(100);
        int number= ticket.getNumber();
        System.out.println("ticket.getNumber()==>"+ticket.getNumber());

        int paidA1=ticket.paidAmount(number, 2);
        System.out.println("paidAmount1===>"+paidA1);

        int paidA2=ticket.paidAmount(number, 2);
        System.out.println("paidAmount2===>"+paidA2);

    }
}
