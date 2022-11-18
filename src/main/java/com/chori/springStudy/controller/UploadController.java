package com.chori.springStudy.controller;

 import com.chori.springStudy.member.Ticket;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestMethod;
 import org.springframework.web.multipart.MultipartFile;

 //import java.util.logging.Logger;


@Controller
public class UploadController {


    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);


    @RequestMapping(value = "/board/uploadForm", method = RequestMethod.GET)
    public String uploadFormGET(Ticket ticket) {
        System.out.println("ticket.getNumber()=====>"+ticket.getNumber());


    logger.info("=============>>>>>>>>>>>>>upload GET.....");
    return "board/uploadForm";
    }

    @RequestMapping(value = "board/uploadForm", method = RequestMethod.POST)
    public void uploadFormPOST(MultipartFile file) throws Exception {
       // logger.info("============> originalName, size, contenttype", file.getOriginalFilename());

    }










}