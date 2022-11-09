//package com.chori.springStudy;
//
//import java.util.List;
//
//import javax.inject.Inject;
//
//import com.chori.springStudy.service.BoardService;
//import lombok.RequiredArgsConstructor;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.chori.springStudy.dao.BoardDAO;
//import com.chori.springStudy.model.BoardVO;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {
//        "classpath:spring/root-context.xml",
//        "classpath:spring/dataSource-context.xml"
//})
//@RequiredArgsConstructor
//public class BoardServiceTests {
//    private static final Logger logger = LoggerFactory.getLogger(BoardServiceTests.class);
//
//    //@Inject
////    @Autowired
////    private BoardDAO boardDAO;
//
//    private final BoardDAO boardDAO;
//    private final BoardService boardService;
//
//    @Test
//    public void testDelete() throws Exception {
//    int result=boardService.deleteBoard(5);
//        logger.info("result : "+ result);
//
//    }
//}