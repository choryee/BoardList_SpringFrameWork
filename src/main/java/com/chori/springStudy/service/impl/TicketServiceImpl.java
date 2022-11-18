package com.chori.springStudy.service.impl;

import com.chori.springStudy.TheaterVO.TicketVO;
import com.chori.springStudy.service.dao.TicketDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService{

    private final TicketDAO ticketDAO;

    @Override
    public int insertTicket(TicketVO ticketVO) throws Exception {
       return ticketDAO.insertTicket(ticketVO);

    }
}
