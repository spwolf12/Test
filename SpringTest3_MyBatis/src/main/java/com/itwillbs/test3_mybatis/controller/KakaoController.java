package com.itwillbs.test3_mybatis.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itwillbs.test3_mybatis.service.KakaoApiService;

@Controller
public class KakaoController {

    @Autowired
    private KakaoApiService kakaoApiService;
    
    @GetMapping("/send-message")
    public ModelAndView sendMessage(@RequestParam("recipientId") String recipientId, @RequestParam("message") String message) {
        try {
            kakaoApiService.sendMessage(recipientId, message);
            ModelAndView modelAndView = new ModelAndView("main");
            modelAndView.addObject("message", "메시지를 성공적으로 보냈습니다.");
            return modelAndView;
        } catch (IOException e) {
            ModelAndView modelAndView = new ModelAndView("error");
            modelAndView.addObject("message", "메시지 보내기에 실패했습니다.");
            return modelAndView;
        }
    }
    
    
}