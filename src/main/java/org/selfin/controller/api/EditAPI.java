package org.selfin.controller.api;

import java.util.List;
import org.selfin.dto.QnaDTO;
import org.selfin.dto.QnaReceiveDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EditAPI {

    @PostMapping(value = "/edit")
    public ResponseEntity<List<QnaDTO>> edit(
        @RequestBody QnaReceiveDTO qnaReceiveDTO
    ) {
        System.out.println(qnaReceiveDTO);

        return ResponseEntity.ok(List.of(
            new QnaDTO("first question", "first answer"),
            new QnaDTO("second question", "second answer")
        ));
    }
}


