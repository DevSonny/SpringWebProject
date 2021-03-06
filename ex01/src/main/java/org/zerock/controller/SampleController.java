package org.zerock.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

//    @RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
    @RequestMapping("")
    public void basic() {
        log.info("basic........");
    }
    
    @GetMapping("/basicGET")
    public void basicGet() {
        log.info("basic get...........");
    }
    
    //http://localhost:8080/ex01?name=AAA&age=16
    @GetMapping("/ex01")
    public void ex01(SampleDTO dto) {
        log.info(dto);
    }
    
    //http://localhost:8080/sample/ex02?name=AAA&age=10
    @GetMapping("/ex02")
    public void ex02(@RequestParam("name") String name, int age) {
        log.info(name);
        log.info(age);
    }
    
    //http://localhost:8080/sample/ex02List?ids=111&ids=222&ids=333
    @GetMapping("/ex02List")
    public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
        log.info("ids: "+ids);
        return "ex02List";
    }
    
    //http://localhost:8080/sample/ex02Bean?list[0].name=AAA&list[0].age=16
    //http://localhost:8080/sample/ex02Bean?list%5B0%5D.name=AAA&list%5B0%5D.age=16
    @GetMapping("{/ex02Bean, /ex022}")
    public void ex02Bean(SampleDTOList list/*, Model model*/) { //모델에 굳이 담지 않아도 됨. 
        log.info(list);
//        model.addAttri bute("result", "success");
    }
    
    @GetMapping("/re1")
    public String re1() {
        log.info("re1...............");
        
        return "redirect:/sample/re2";
    }
    
    @GetMapping("/re2")
    public void re2() {
        log.info("re2...............");
    }    
    
    @GetMapping("/exUpload")
    public void exUpload() {
        log.info("exUpload..........");
    }
    
    @PostMapping("/exUploadPost")
    public void exUploadPost(ArrayList<MultipartFile> files) {

        files.forEach(file -> {
            log.info(file.getOriginalFilename());
            log.info(file.getSize());
            log.info(file.getContentType());
        });
        
    }
    
}
