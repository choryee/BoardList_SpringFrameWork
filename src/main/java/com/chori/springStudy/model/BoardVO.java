package com.chori.springStudy.model;

import jdk.jfr.Timestamp;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardVO {
    public int bid;
    public String cate_cd;
    public String title;
    public String content;
    public String tag;
    public int view_cnt;
    public String reg_id;
    public String icode;
    public String cmd;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public String reg_dt;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public String edit_dt;




}
