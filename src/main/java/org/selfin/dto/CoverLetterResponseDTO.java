package org.selfin.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CoverLetterResponseDTO {

    String title;
    LocalDate editDate;
    List<QnaDTO> prev;
    List<QnaDTO> after;
}
