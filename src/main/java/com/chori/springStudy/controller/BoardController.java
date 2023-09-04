package com.chori.springStudy.controller;

import com.chori.springStudy.dto.ResponseDto;
import com.chori.springStudy.model.BoardDto;
import com.chori.springStudy.model.BoardVO;
import com.chori.springStudy.service.BoardService;
import lombok.RequiredArgsConstructor;
//import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
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

    @RequestMapping("/boardForm")
    public String boardForm() {
        return "/board/boardForm";
    }

    //boardForm.jsp의 34라인에 saveBoard있음.
//    @RequestMapping(value = "/saveBoard1", method = RequestMethod.POST) //post 매핑은 redirect를 생각해야. 안 그러면, 글 도배할 수도 있다.
//    public String saveBoard(@ModelAttribute("BoardVO") BoardVO boardVO, RedirectAttributes rttr) throws Exception {
//        boardService.insertBoard(boardVO);
//        return "redirect:/board/getBoardList"; // 이건 폴더밑 경로가 아니라, 컨트롤러 상의 경로임.
//    }

    //6.수정 및 삭제-훈잇블로그 밑 부분에서, 위의 것을 수정함.
    @RequestMapping(value = "/saveBoard", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:8080/board/saveBoard")
    public String saveBoard(@ModelAttribute("boardVO") BoardVO boardVO,
                            @RequestParam(value = "mode", required = false) String mode,
                            RedirectAttributes rttr) throws Exception {
        //@ModelAttribute("boardVO") BoardVO boardVO는 model로 넘길 것이 boardVO하나일때 씀.
        if (mode != null && mode.equals("edit")) {
            System.out.println("BoardVO>>"+boardVO);
            System.out.println("updateBoard>> 탐.."+mode);
            boardService.updateBoard(boardVO);
        } else {
            System.out.println("insertBoard>> 탐.. mode>>"+mode);
            System.out.println("BoardVO>>"+boardVO);
            boardService.insertBoard(boardVO);
        }
        return "redirect:/board/getBoardList";
    }

    //상세보기
    @RequestMapping(value = "/getBoardContent", method = RequestMethod.GET)
    public String detailBoard(@RequestParam("bid") int bid, Model model) throws Exception {

        // System.out.println("bid===>"+boardService.getBoardContent(bid));

        model.addAttribute("boardContent", boardService.getBoardContent(bid));
        return "board/boardContent";
    }

    @RequestMapping(value = "/editForm", method = RequestMethod.GET)
    // /editForm은 jsp에서 ajax로 호출하는 부분. 230901
    public String editForm(@RequestParam("bid") int bid,
                           @RequestParam("mode") String mode,
                           Model model) throws Exception {
        System.out.println("=============bid=>"+bid);
        BoardVO boardVO=boardService.getBoardContent(bid);

        model.addAttribute("boardContent", boardService.getBoardContent(bid));
        model.addAttribute("mode", mode);
        // model.addAttribute("boardVO", new BoardVO());
        model.addAttribute("boardVO", boardVO);
        return "/board/editForm";
    }


    @RequestMapping(value = "/updateBoard", method = RequestMethod.POST)
    public String updateBoard(@ModelAttribute("boardVO")BoardVO boardVO,
                              @RequestParam("mode") String mode,
                              @RequestParam("bid") int bid) throws Exception{
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


    // http://localhost:8080/board/getBoardList
   // @ResponseBody
//    @RequestMapping(value = "/getBoardList", method = RequestMethod.GET)
//    public String getBoardList(Model model) throws Exception {
////        BoardDAOImpl dao=new BoardDAOImpl();
////        System.out.println("here============");
////       List<BoardVO> list= dao.getBoardList();
////        System.out.println(list.size());
//        List<BoardVO> bList=boardService.getBoardList();
//        //System.out.println("list"+bList);
//
//        model.addAttribute("boardList", bList);
//       //return "board/index";
//       // return "board/theaterList";
//       return "board/test_board";
//    }

//    @ResponseBody
//    @RequestMapping(value = "/getBoardList1", method = RequestMethod.GET)
//    public BoardVO getBoardList1() throws Exception {
//        List<BoardVO> bList=boardService.getBoardList();

//        for (bList:BoardVO boardVO  ) {
//            BoardVO boardVO1=new BoardVO();
//            boardVO1.setBid(bList);
//        }

//        for(int i=0; i<=3; i++){
//            BoardVO boardVO=new BoardVO();
//            boardVO.setReg_id(bList.get(6));
//        }

//        BoardVO vo=new BoardVO();
//        vo.setReg_id(blist[0].ge);
//        vo.setBid(1);

//        HashMap<String, Object> map=new HashMap<>();
//        for (bList:BoardVO boardVO             ) {
//            map.put()
//        }

        //return vo;
    //}

   //@RequestMapping("/ticketList")
    public String ticket(){
        return "board/theaterList";
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

    //http://localhost:8080/board/getBoardContent5
   // @GetMapping("/getBoardContent5", produces = MediaType.APPLICATION_JSON_VALUE)
    //@GetMapping("/getBoardContent5")
    public ResponseEntity<?> select(@RequestBody BoardDto dto)  {
        String introduction = "안녕하세요. 저의 이름은 " + dto.getCmd()+ "입니다."
                + " 저의 취미는 " + dto.getIcode()+ "입니다.";
        return ResponseEntity.ok(introduction);
    }


    //@GetMapping("/getBoardContent4")
    public ResponseDto<Integer> test(@RequestBody BoardDto dto) throws Exception {
         System.out.println("iiicode==============>"+dto.getIcode());
//        BoardDto dto=new BoardDto();
//        dto.setIcode(icode);
//        dto.setCmd(cmd);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }


    // https://baessi.tistory.com/22
    //@RequestMapping("/getBoardContent3")
    public @ResponseBody BoardVO test() throws Exception {
       // System.out.println("boardVO.getIcode()=====>"+boardVO.getIcode());
        BoardVO vo=new BoardVO();
        //vo.setIcode(3);
        vo.setCmd("test");
        System.out.println("boardVO=====>"+vo);
        return vo;
    }

    @ResponseBody
    //@RequestMapping("/getBoardContent2")
    public  BoardVO test1(BoardVO vo) throws Exception {
        // System.out.println("boardVO.getIcode()=====>"+boardVO.getIcode());
        BoardVO boardVO=new BoardVO();

        //int aa=vo.getIcode();
        String a=vo.getCmd();
        System.out.println("boardVO===============>"+vo.getCmd());
        return vo;
    }

//   @ResponseBody //230107
//    @RequestMapping(value = "/getBoardContent1", method = RequestMethod.GET)
//   // public String detailBoard1(@RequestParam int icode) throws Exception {
//   public Map<String, Object> detailBoard1(@RequestParam("icode") int icode) throws Exception {
//    //public Map<String, Object> detailBoard1(BoardVO boardvo) throws Exception {
//        icode=icode;
//        System.out.println("icode=======================>"+icode);
//       // System.out.println("boardService.getBoardContent(icode)===>"+boardService.getBoardContent(icode));
//     //   System.out.println("boardvo.getIcode()=======================>"+boardvo.getIcode());
//     //   System.out.println("boardvo.getCmd()=====>"+boardvo.getCmd());
//    //    System.out.println("boardService.getBoardContent(boardvo.getIcode())===>"+boardService.getBoardContent(boardvo.getIcode()));
//       BoardVO boardVO=boardService.getBoardContent(icode);
//        System.out.println("boardVO=====>"+boardVO);
//
//       Map<String, Object> result=new HashMap<String, Object>();
//       result.put("cmd", boardVO.getCmd());
//       result.put("icode", boardVO.getIcode());
//
//       //JSONObject jsonObject = new JSONObject(result);
//        System.out.println("map>>>"+result);
//        System.out.println("=======================");
//        System.out.println("jsonObject>>>"+jsonObject);
//
//      //  model.addAttribute("boardContent", boardService.getBoardContent(bid));
//      //  return "board/boardContent";
//       // return "ok";
//        //return "result = "+icode;
//      //  return jsonObject;
//    }


//    @ResponseBody
//    @RequestMapping(value = "/getBoardContent1", method = RequestMethod.GET)
//   //  public String detailBoard1(@RequestParam("icode") int icode, Model model) throws Exception {
//     public List<Map<String, Object>> detailBoard2(@RequestParam Map<String, Object> params, HttpServletRequest request) throws Exception {
//        System.out.println("params>>>>"+params);
//        List<Map<String, Object>> result = new ArrayList<>(); //result를 선언하는 것.
//        //System.out.println("icode===>"+boardService.getBoardContent(icode));
//
//        result=boardService.getBoardContent1(params);
//        System.out.println("result>>>>"+result);
//        System.out.println("request>>>>"+request);
//        //model.addAttribute("boardContent", boardService.getBoardContent(icode));
//        return result;
//    }


//    @RequestMapping("/updateForm")
//    public String updateForm(@RequestParam("bid") int bid, Model model) throws Exception {
//        model.addAttribute("updateBoard", boardService.getBoardContent(bid)) ;
//        return "board/updateForm";
//    }



}