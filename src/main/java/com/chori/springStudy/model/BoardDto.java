package com.chori.springStudy.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class BoardDto {
    public int bid;
    public String icode;
    public String cmd;
    public String title;
    public String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public String reg_dt;
}
