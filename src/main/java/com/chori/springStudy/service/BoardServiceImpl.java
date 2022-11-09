package com.chori.springStudy.service;

import com.chori.springStudy.dao.BoardDAO;
import com.chori.springStudy.model.BoardVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

// @Inject
//    private BoardDAO boardDAO;

    private final BoardDAO boardDAO;


    @Override
    public List<BoardVO> getBoardList() throws Exception {
        return boardDAO.getBoardList();
    }

    @Override
    public BoardVO getBoardContent(int bid) throws Exception {
        boardDAO.updateViewCnt(bid); //조회수 증가
        return boardDAO.getBoardContent(bid); // 게시물 읽어오기
    }

    @Override
    public BoardVO detailBoard(int bid) throws Exception {
        return boardDAO.detailBoard(bid);
    }

    //    @Override
//    public int insertBoard(BoardVO boardVO) throws Exception {
//        return boardDAO.insertBoard(boardVO);
//    }

    @Override
    public Map<String, Object> insertBoard(BoardVO boardVO) throws Exception {
        boardDAO.insertBoard(boardVO);
        return null;
    }


    @Override
    public int updateBoard(BoardVO boardVO) throws Exception {
        return 0;
    }

    @Override
    public int deleteBoard(int bid) throws Exception {
        return boardDAO.deleteBoard(bid);
    }

    @Override
    public int updateViewCnt(int bid) throws Exception {
        return 0;
    }
}











