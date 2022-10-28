package com.chori.springStudy.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {


    private int id;
    private String name;
    private String pwd;
    private String email;
    private String phone;

}
