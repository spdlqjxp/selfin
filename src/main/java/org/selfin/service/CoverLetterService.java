package org.selfin.service;//package org.web.service;
//
//import lombok.ToString;
//import lombok.extern.slf4j.Slf4j;
//import org.domain.dto.CoverLetterDTO;
//import org.domain.entity.CoverLetterEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.web.repository.CoverLetterRepository;
//import org.web.repository.MyCoverLetter;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@ToString
//@Slf4j
//public class CoverLetterService {
//
//    @Autowired
//    private CoverLetterRepository coverLetterRepository;
//    public CoverLetterDTO show(String username,Long id) {
//        CoverLetterEntity entity = coverLetterRepository.findCoverLetterEntityByUsernameAndId(username,id);
//        CoverLetterDTO coverLetter = new CoverLetterDTO(entity);
//        return coverLetter;
//    }
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
//        CoverLetterEntity coverLetter = dto.toEntity();
//        CoverLetterDTO created = new CoverLetterDTO(coverLetterRepository.save(coverLetter));
//        return created;
//    }
//
//    public CoverLetterDTO update(String username, CoverLetterDTO dto,Long id) {
//        CoverLetterEntity coverLetter = dto.toEntity();
//        CoverLetterEntity target = coverLetterRepository.findCoverLetterEntityByUsernameAndId(username,id);
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
//        CoverLetterEntity target = coverLetterRepository.findCoverLetterEntityByUsernameAndId(username,id);
//        if (target == null) {
//            return null;
//        }
//        coverLetterRepository.delete(target);
//        return target;
//    }
//
//}
//
