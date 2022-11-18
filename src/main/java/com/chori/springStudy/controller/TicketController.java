package com.chori.springStudy.controller;


import com.chori.springStudy.TheaterVO.TicketVO;
import com.chori.springStudy.service.impl.TicketService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class TicketController {

    private static final Logger logger = LoggerFactory.getLogger(TicketController.class);
    private final TicketService ticketService;


    @RequestMapping(value = "/ticket/ticketList", method = RequestMethod.GET)
    //@ResponseBody
   // @GetMapping("/ticket/ticketList")
   // public String ticketList(HttpServletRequest request, String ticket_no, @RequestParam(required = false) String ticket_price, Model model) throws Exception {
       public String ticketList(TicketVO ticketVO, Model model) throws Exception{
//        System.out.println(request.getParameter("ticket_no"));
//        System.out.println("============ticket_no===>"+ticket_no);
//        System.out.println("============ticket_price===>"+ticket_price);
//        model.addAttribute("ticket_no", ticket_no);
//        model.addAttribute("ticket_price", ticket_price);
        System.out.println("============ticketVO.getTicket_no()===>"+ticketVO.getTicket_no());
        System.out.println("============ticketVO.getTicket_price()===>"+ticketVO.getTicket_price());

        ticketService.insertTicket(ticketVO);
        model.addAttribute("ticket", ticketVO);

        return "board/ticketList";

    }

        @RequestMapping(value = "/ticket/ticketInsert", method = RequestMethod.POST)
         public String ticketInsert(TicketVO ticketVO, Model model, RedirectAttributes rttr) throws Exception {
            System.out.println("===============>"+ticketVO.getTicket_no());
            System.out.println("===============>"+ticketVO.getTicket_price());



            model.addAttribute("ticket", ticketVO);

            return "redirect:/board/theaterList ";
     }

//    @RequestMapping("/ticket/ticketForm")
//    public String ticketList()  {
//
//        return "board/boardForm";
//
//    }



//    @RequestMapping("/boardForm")
//    public String boardForm() {
//        return "board/boardForm";
//    }



}

