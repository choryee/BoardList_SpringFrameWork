package com.chori.springStudy.service;

import com.chori.springStudy.model.BoardVO;

import java.util.List;
import java.util.Map;

public interface BoardService {

    public List<BoardVO> getBoardList() throws Exception;

    public BoardVO getBoardContent(int bid) throws Exception;

   // public int insertBoard(BoardVO boardVO) throws Exception;

      public Map<String, Object> insertBoard(BoardVO boardVO) throws Exception;


    public int updateBoard(BoardVO boardVO) throws Exception;

    public int deleteBoard(int bid) throws Exception;

    public int updateViewCnt(int bid) throws Exception;

}
