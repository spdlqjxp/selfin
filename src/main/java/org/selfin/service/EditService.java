package org.selfin.service;

import java.util.List;
import org.selfin.dto.EditedQnaDTO;
import org.selfin.dto.QnaDTO;
import org.selfin.dto.QnaReceiveDTO;
import org.springframework.stereotype.Service;

@Service
public class EditService {

    public EditedQnaDTO edit(QnaReceiveDTO qnaReceiveDTO) {
        return new EditedQnaDTO(
            3,
            List.of(new QnaDTO("first question", "first answer"),
                new QnaDTO("second question", "second answer"))
        );
    }
}
