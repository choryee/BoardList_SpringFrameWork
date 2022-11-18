package com.chori.springStudy.TheaterVO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class People {
    private int id;
    private String name;
    private String invitationCard;
    private String purchase_date = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);

}
