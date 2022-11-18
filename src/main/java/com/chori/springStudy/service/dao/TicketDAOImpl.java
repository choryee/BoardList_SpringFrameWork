package com.chori.springStudy.service.dao;

import com.chori.springStudy.TheaterVO.TicketVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository
public class TicketDAOImpl implements TicketDAO{

    @Inject
    private SqlSession sqlSession;

    public int insertTicket(TicketVO ticketVO) throws Exception{
        return sqlSession.insert("com.chori.springStudy.ticketMapper.insertTicket", ticketVO);
    }
}
