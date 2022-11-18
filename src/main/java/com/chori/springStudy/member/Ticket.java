package com.chori.springStudy.member;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Data
public class Ticket { //금액, 티켓수, 총액 getter/setter

    private int fee;
    private int number;
    private int totalAmount;


    public void setTotalAmount(int totalAmount){
        this.totalAmount=totalAmount;
    }
    public int getTotalAmount(){
        return totalAmount;
    }

    public void setFee(int fee){
        this.fee=fee;
    }
    public int getFee(){
        return fee;
    }

    public void setNumber(int number){
        this.number=number;
    }

    public int getNumber(){
        return number;
    }


    public int paidAmount(int number,int fee){
        this.number-=number;
        return number*fee;
    }

}
