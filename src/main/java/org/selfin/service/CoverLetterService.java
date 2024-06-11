package org.selfin.service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.selfin.dto.CoverLetterDTO;
import org.selfin.dto.CoverLetterResponseDTO;
import org.selfin.dto.QnaDTO;
import org.selfin.entity.CoverLetterEntity;
import org.selfin.entity.QnaEntity;
import org.selfin.repository.CoverLetterRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoverLetterService {

    private final CoverLetterRepository coverLetterRepository;

//    public List<PrevAfterCoverLetterDTO> getPrevAfterCoverLetters(String username) {
//        List<CoverLetterEntity> coverLetters = coverLetterRepository.findAllByUsername(username);
//
//        List<CoverLetterEntity> prevs = new LinkedList<>();
//        List<CoverLetterEntity> afters = new LinkedList<>();
//
//        for (CoverLetterEntity coverLetterEntity : coverLetters) {
//            if (coverLetterEntity.getState() == -2) {
//                prevs.add(coverLetterEntity);
//            } else if (coverLetterEntity.getState() != -1) {
//                afters.add(coverLetterEntity);
//            }
//        }
//        List<PrevAfterCoverLetterDTO> results = new LinkedList<>();
//
//        for (CoverLetterEntity prev : prevs) {
//            CoverLetterEntity after = null;
//            for (CoverLetterEntity after2 : afters) {
//                if (prev.getId().equals(after2.getState())) {
//                    after = after2;
//                    break;
//                }
//            }
//
//            results.add(new PrevAfterCoverLetterDTO(
//                prev.getQna().stream().map(QnaEntity::to).toList(),
//                after.getQna().stream().map(QnaEntity::to).toList()));
//        }
//        return results;
//    }

    public void postCoverLetter(String username, Long state, CoverLetterDTO coverLetter) {
        List<QnaEntity> qnas = new LinkedList<>();
        for (QnaDTO qna : coverLetter.getQna()) {
            qnas.add(QnaEntity.builder()
                .question(qna.getQuestion())
                .answer(qna.getAnswer())
                .build());
        }
        CoverLetterEntity coverLetterEntity = CoverLetterEntity.builder()
            .username(username)
            .title(coverLetter.getTitle())
            .editDate(LocalDate.now())
            .state(state)
            .qna(qnas)
            .build();
        coverLetterRepository.save(coverLetterEntity);
    }

    public List<CoverLetterResponseDTO> getMypageCoverLetters(String username) {
        List<CoverLetterEntity> coverLetterEntities = coverLetterRepository.findAllByUsername(
            username).stream().filter(e -> e.getState() != -1).toList();

        List<CoverLetterEntity> prevs = new LinkedList<>();
        for (CoverLetterEntity e : coverLetterEntities) {
            if (e.getState() == -2) {
                prevs.add(e);
            }
        }

        List<CoverLetterResponseDTO> dtos = new LinkedList<>();
        for (CoverLetterEntity e : prevs) {
            CoverLetterEntity after = coverLetterRepository.findByState(e.getId());

            dtos.add(CoverLetterResponseDTO.builder()
                .title(e.getTitle())
                .editDate(e.getEditDate())
                .prev(e.getQna().stream().map(QnaEntity::to).toList())
                .after(after.getQna().stream().map(QnaEntity::to).toList())
                .build());
        }
        return dtos;
    }
}
