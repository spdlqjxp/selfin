package org.selfin.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.selfin.dto.CoverLetterDTO;
import org.selfin.dto.EditedQnaDTO;
import org.selfin.dto.QnaDTO;
import org.selfin.entity.CoverLetterEntity;
import org.selfin.entity.QnaEntity;
import org.selfin.repository.CoverLetterRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditService {

    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();
    private final CoverLetterRepository coverLetterRepository;

    public EditedQnaDTO edit(String username, CoverLetterDTO coverLetterDTO) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://first-burro-comic.ngrok-free.app/api/edit"))
                .header("Content-Type", "application/json")
                .header("ngrok-skip-browser-warning", "1")
                .POST(BodyPublishers.ofString(mapper.writeValueAsString(coverLetterDTO)))
                .build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            EditedQnaDTO result = mapper.readValue(response.body(), EditedQnaDTO.class);

            List<QnaEntity> qnas = new LinkedList<>();
            for (QnaDTO dto : coverLetterDTO.getQna()) {
                qnas.add(QnaEntity.builder()
                    .question(dto.getQuestion())
                    .answer(dto.getAnswer())
                    .build());
            }

            CoverLetterEntity prevEdit = CoverLetterEntity.builder()
                .username(username)
                .title(coverLetterDTO.getTitle())
                .editDate(LocalDate.now())
                .state(-2L)
                .qna(qnas)
                .build();
            prevEdit = coverLetterRepository.save(prevEdit);

            qnas = new LinkedList<>();
            for (QnaDTO dto : result.getQna()) {
                qnas.add(QnaEntity.builder()
                    .question(dto.getQuestion())
                    .answer(dto.getAnswer())
                    .build());
            }

            CoverLetterEntity afterEdit = CoverLetterEntity.builder()
                .username(username)
                .title(coverLetterDTO.getTitle())
                .editDate(LocalDate.now())
                .state(prevEdit.getId())
                .qna(qnas)
                .build();
            coverLetterRepository.save(afterEdit);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
