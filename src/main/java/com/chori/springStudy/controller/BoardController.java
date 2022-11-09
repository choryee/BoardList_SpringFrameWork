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

    //boardForm.jsp의 34라인에 saveBoard있음.
//    @RequestMapping(value = "/saveBoard", method = RequestMethod.POST) //post 매핑은 redirect를 생각해야. 안 그러면, 글 도배할 수도 있다.
//    public String saveBoard(@ModelAttribute("BoardVO") BoardVO boardVO, RedirectAttributes rttr) throws Exception {
//        boardService.insertBoard(boardVO);
//        return "redirect:/board/getBoardList"; // 이건 폴더밑 경로가 아니라, 컨트롤러 상의 경로임.
//    }

    //6.수정 및삭제-훈잇블로그 밑 부분에서, 위의 것을 수정함.
    @RequestMapping(value = "/saveBoard", method = RequestMethod.POST)
    public String saveBoard(@ModelAttribute("boardVO") BoardVO boardVO, @RequestParam("mode") String mode, RedirectAttributes rttr) throws Exception {
      //@ModelAttribute("boardVO") BoardVO boardVO는 model로 넘길 것이 boardVO하나일때 씀.
        if (mode.equals("edit")) {
            boardService.updateBoard(boardVO);
        } else {
            boardService.insertBoard(boardVO);
        }
        return "redirect:/board/getBoardList";
    }


    public String testBoard1(BoardVO boardVO, @RequestParam("mode") String mode, Model model) throws Exception {
        model.addAttribute("boardVO", boardVO);
        return null;
    }
    public String testBoard2(@ModelAttribute("boardVO") BoardVO boardVO, @RequestParam("mode") String mode, Model model) throws Exception {
        //여기 boardVO관련되 것 없음.
        return null;
    }
    public String testBoard3(@RequestParam("mode") String mode, Model model ) throws Exception { //여기 boardVO관련되 것 없음.
        model.addAttribute("boardVO", new BoardVO());
        return null;
    }


    @RequestMapping(value = "/getBoardContent", method = RequestMethod.GET)
    public String detailBoard(@RequestParam("bid") int bid, Model model) throws Exception {

       // System.out.println("bid===>"+boardService.getBoardContent(bid));

        model.addAttribute("boardContent", boardService.getBoardContent(bid));
        return "board/boardContent";
    }


//    @RequestMapping("/updateForm")
//    public String updateForm(@RequestParam("bid") int bid, Model model) throws Exception {
//        model.addAttribute("updateBoard", boardService.getBoardContent(bid)) ;
//        return "board/updateForm";
//    }

    @RequestMapping(value = "/editForm", method = RequestMethod.GET)
    public String editForm(@RequestParam("bid") int bid, @RequestParam("mode") String mode, Model model) throws Exception {

        model.addAttribute("boardContent", boardService.getBoardContent(bid));
        model.addAttribute("mode", mode);
        model.addAttribute("boardVO", new BoardVO());
       // model.addAttribute("boardVO", boardVO);

        return "board/editForm";
    }


    @RequestMapping(value = "/updateBoard", method = RequestMethod.POST)
    public String updateBoard(@ModelAttribute("boardVO")BoardVO boardVO, @RequestParam("mode") String mode, RedirectAttributes rttr) throws Exception{
        boardService.updateBoard(boardVO);
        return "redirect:/board/getBoardList";
    }

    @RequestMapping(value = "/deleteBoard", method = RequestMethod.GET)
    public String deleteBoard(RedirectAttributes rttr, @RequestParam("bid") int bid) throws Exception {
        int result=boardService.deleteBoard(bid);
        System.out.println("result=============>"+result);
        rttr.addFlashAttribute("result1", "DELETE SUCCESS");
        return "redirect:/board/getBoardList";
    }

}