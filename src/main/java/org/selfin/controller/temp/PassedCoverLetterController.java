package org.selfin.controller.temp;//package org.web.controller;
//
//import org.domain.dto.PassedCoverLetterDTO;
//import org.domain.entity.PassedCoverLetterEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.web.service.PassedCoverLetterService;
//
//import java.util.List;
//
//@RestController
//public class PassedCoverLetterController {
//    @Autowired
//    private PassedCoverLetterService passedCoverLetterService;
//
//    @GetMapping("/passed-cover-letter/{company}/{username}")
//    public List<PassedCoverLetterEntity> index(String username, String company) {
//        return passedCoverLetterService.index(username, company);
//    }
//
//    @GetMapping("/passed-cover-letter/get-{username}-passed-cover-letter/{id}")
//    public PassedCoverLetterDTO show(String username, Long id) {
//        return passedCoverLetterService.show(username, id);
//    }
//}
