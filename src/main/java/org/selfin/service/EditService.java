package org.selfin.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import org.selfin.dto.CoverLetterDTO;
import org.selfin.dto.EditedQnaDTO;
import org.springframework.stereotype.Service;

@Service
public class EditService {

    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    public EditedQnaDTO edit(CoverLetterDTO qnaReceiveDTO) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://first-burro-comic.ngrok-free.app/api/edit"))
                .header("Content-Type", "application/json")
                .header("ngrok-skip-browser-warning", "1")
                .POST(BodyPublishers.ofString(mapper.writeValueAsString(qnaReceiveDTO)))
                .build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            return mapper.readValue(response.body(), EditedQnaDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
