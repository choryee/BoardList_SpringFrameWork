package com.chori.springStudy.member;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter

public class Invitation { // 시간만
    private LocalDateTime when;
}
