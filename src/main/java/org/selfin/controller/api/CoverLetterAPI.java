package org.selfin.controller.api;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.selfin.dto.CoverLetterDTO;
import org.selfin.dto.CoverLetterResponseDTO;
import org.selfin.service.CoverLetterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CoverLetterAPI {

    private final CoverLetterService coverLetterService;

//    @GetMapping("/getcoverletters")
//    public ResponseEntity<List<PrevAfterCoverLetterDTO>> getPrevAfterCoverLetter(
//        @RequestParam String username) {
//        return ResponseEntity.ok(coverLetterService.getPrevAfterCoverLetters(username));
//    }

    @PostMapping("/postcoverletter")
    public ResponseEntity<CoverLetterDTO> postCoverLetter(
        @RequestParam String username,
        @RequestParam Long state,
        @RequestBody CoverLetterDTO coverLetterDTO) {
        coverLetterService.postCoverLetter(username, state, coverLetterDTO);
        return ResponseEntity.ok(coverLetterDTO);
    }

    @GetMapping("/getmypagecoverletters")
    public ResponseEntity<List<CoverLetterResponseDTO>> getCoverLetters(
        @RequestParam String username) {
        return ResponseEntity.ok(coverLetterService.getMypageCoverLetters(username));
    }
}