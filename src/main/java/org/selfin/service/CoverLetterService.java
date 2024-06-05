//package org.selfin.service;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.selfin.dto.CoverLetterDTO;
//import org.selfin.entity.CoverLetterEntity;
//import org.selfin.repository.CoverLetterRepository;
//import org.selfin.repository.MyCoverLetter;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class CoverLetterService {
//
//    private CoverLetterRepository coverLetterRepository;
//
//    public List<MyCoverLetter> index(String username) {
//        List<MyCoverLetter> coverLetters = coverLetterRepository.findByUsername(username);
//        List<MyCoverLetter> dtos = new ArrayList<>();
//        for (MyCoverLetter entity : coverLetters) {
//            MyCoverLetter dto = new MyCoverLetter() {
//                @Override
//                public String getTitle() {
//                    return entity.getTitle();
//                }
//
//                @Override
//                public LocalDateTime getModifiedDate() {
//                    return entity.getModifiedDate();
//                }
//            };
//            dtos.add(dto);
//        }
//        return dtos;
//    }
//
//    public CoverLetterDTO create(CoverLetterDTO dto) {
//        return new CoverLetterDTO(coverLetterRepository.save(dto.toEntity()));
//    }
//
//    public CoverLetterDTO update(String username, CoverLetterDTO dto, Long id) {
//        CoverLetterEntity coverLetter = dto.toEntity();
//        CoverLetterEntity target = coverLetterRepository.findCoverLetterEntityByUsernameAndId(
//            username, id);
////        if (target == null || !username.equals(target.getUsername())) {
////            return null; 여기서 자꾸 에러가 뜸 왜이러지
////        }
//        target.patch(coverLetter);
//        CoverLetterEntity updated = coverLetterRepository.save(target);
//        CoverLetterDTO updateCoverLetter = new CoverLetterDTO(updated);
//        return updateCoverLetter;
//    }
//
//
//    public CoverLetterEntity delete(String username, Long id) {
//        CoverLetterEntity target = coverLetterRepository.findCoverLetterEntityByUsernameAndId(
//            username, id);
//        if (target == null) {
//            return null;
//        }
//        coverLetterRepository.delete(target);
//        return target;
//    }
//
//}
//
