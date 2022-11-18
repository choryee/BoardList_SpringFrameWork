package com.chori.springStudy.member;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Data
public class Ticket { //금액,  getter/setter

    // Ticket를 fee만 가진, A,B,C,D..라고 생각하자.

    private int fee;
    private String ticketName;


    /*
    private int number;
    private int totalAmount;*/

    public Ticket(){};
    public Ticket(String ticketName){
        this.ticketName=ticketName;
    }


    public int getFee(){
        return fee;
    }

    public void setTicketName(String ticketName){
        this.ticketName=ticketName;
    }

    public String getTicketName(){
        return ticketName;
    }

    /*

    public void setFee(int fee){
        this.fee=fee;
    }

    public void setNumber(int number){
        this.number=number;
    }

    public int getNumber(){
        return number;
    }

    public void setTotalAmount(int totalAmount){
        this.totalAmount=totalAmount;
    }
    public int getTotalAmount(){
        return totalAmount;
    }

    public int paidAmount(int number,int fee){
        this.number-=number;
        return number*fee;
    }

 */

}
