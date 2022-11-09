package com.chori.springStudy.dao;



import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chori.springStudy.model.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

    //@Autowired
   // @Autowired(required = false)
    @Inject
    private SqlSession sqlSession;

    public List<BoardVO> getBoardList() throws Exception {
        return sqlSession.selectList("com.chori.springStudy.boardMapper.getBoardList");
    }

    public BoardVO getBoardContent(int bid) throws Exception {
        return sqlSession.selectOne("com.chori.springStudy.boardMapper.getBoardContent", bid);
    }

    public BoardVO detailBoard(int bid) throws Exception{
        return sqlSession.selectOne("com.chori.springStudy.boardMapper.detailBoard", bid);
    }

    public int insertBoard(BoardVO boardVO) throws Exception {
        return sqlSession.insert("com.chori.springStudy.boardMapper.insertBoard", boardVO);
    }

    public int updateBoard(BoardVO boardVO) throws Exception {
        return sqlSession.update("com.chori.springStudy.boardMapper.updateBoard", boardVO);
    }

    public int deleteBoard(int bid) throws Exception {
        return sqlSession.delete("com.chori.springStudy.boardMapper.deleteBoard", bid);
    }

    public int updateViewCnt(int bid) throws Exception {
        return sqlSession.update("com.chori.springStudy.boardMapper.updateViewCnt", bid);
    }

    //SqlSession sqlSession=new SqlSession();



}