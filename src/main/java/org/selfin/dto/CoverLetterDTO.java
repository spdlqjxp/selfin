package org.selfin.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CoverLetterDTO {
    private String title;
    private List<QnaDTO> qna;
}
