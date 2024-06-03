package org.selfin.service;//package org.web.service;
//
//import org.domain.dto.CoverLetterDTO;
//import org.domain.dto.PassedCoverLetterDTO;
//import org.domain.entity.PassedCoverLetterEntity;
//import org.springframework.stereotype.Service;
//import org.web.repository.PassedCoverLetterRepository;
//
//import java.util.List;
//
//@Service
//public class PassedCoverLetterService {
//    private PassedCoverLetterRepository passedCoverLetterRepository;
//    public List<PassedCoverLetterEntity> index(String username, String company) {
//        List<PassedCoverLetterEntity> passedCoverLetters = passedCoverLetterRepository.findByUsernameAndCompany(username, company);
//        return passedCoverLetters;
//    }
//
//    public PassedCoverLetterDTO show(String username, Long id) {
//        PassedCoverLetterEntity passedCoverLetter = passedCoverLetterRepository.findById(id).orElse(null);
//        return new PassedCoverLetterDTO(passedCoverLetter);
//    }
//}
