package com.chori.springStudy.TheaterVO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter @Setter
@Data
public class TicketVO {

    private String ticket_type;
    private int ticket_no;
    private int ticket_price;
    private int booth_total;
    private String invitation;
    private String purchase_date = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
}
