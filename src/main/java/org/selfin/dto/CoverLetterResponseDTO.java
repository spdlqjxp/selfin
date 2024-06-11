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

    private Long id;
    private String title;
    private LocalDate editDate;
    private List<QnaDTO> prev;
    private List<QnaDTO> after;
}
