package com.chori.springStudy.controller;

import com.chori.springStudy.dao.BoardDAOImpl;
import com.chori.springStudy.model.BoardVO;
import com.chori.springStudy.service.BoardService;
import com.chori.springStudy.service.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {


    private final BoardService boardService;


   // http://localhost:8080/board/getBoardList
    @RequestMapping(value = "/getBoardList", method = RequestMethod.GET)
    public String getBoardList(Model model) throws Exception {
//        BoardDAOImpl dao=new BoardDAOImpl();
//        System.out.println("here============");
//       List<BoardVO> list= dao.getBoardList();
//        System.out.println(list.size());
        List<BoardVO> bList=boardService.getBoardList();

        model.addAttribute("boardList", bList);
        return "board/index";
    }


    // http://localhost:8080/board/insertBoard
//    @PostMapping(value = "/insertBoard")
//    //public String insertBoard(String title, String content, Model model) throws Exception{
//    public int insertBoard(BoardVO boardVO) throws Exception {
//        BoardServiceImpl boardService=new BoardServiceImpl(boardVO);
//        //   BoardDAOImpl dao=new BoardDAOImpl();
//     // System.out.println("here============");
//      // int insertBoard= dao.insertBoard(boardVO);
//
//        //BoardVO vo=new BoardVO();
//        boardVO.setContent(boardVO.getContent());
//        boardVO.setTitle(boardVO.getTitle());
//        boardVO.setTag(boardVO.getTag());
//
//      System.out.println("tag : "+boardVO.getTag()+"content :" + boardVO.getContent() + ", " + "title :" + boardVO.getTitle());
//        return dao.insertBoard(boardVO);
//}



    @RequestMapping("/boardForm")
    public String boardForm() {
        return "board/boardForm";
    }

    @RequestMapping(value = "/saveBoard", method = RequestMethod.POST)
    public String saveBoard(@ModelAttribute("BoardVO") BoardVO boardVO, RedirectAttributes rttr) throws Exception {
        boardService.insertBoard(boardVO);
        return "redirect:/board/getBoardList"; // 이건 폴더밑 경로가 아니라, 컨트롤러 상의 경로임.
    }





}