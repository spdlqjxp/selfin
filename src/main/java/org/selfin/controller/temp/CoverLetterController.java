package org.selfin.controller.temp;//package org.web.controller;
//
//import java.util.List;
//import org.domain.dto.CoverLetterDTO;
//import org.domain.entity.CoverLetterEntity;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.web.repository.MyCoverLetter;
//import org.web.service.CoverLetterService;
//
//@RestController
//public class CoverLetterController {
//
//    private static final Logger logger = LoggerFactory.getLogger(CoverLetterController.class);
//
//    @Autowired
//    private CoverLetterService coverLetterService;
//
//    @GetMapping("/cover-letter/{username}")
//    public List<MyCoverLetter> index(@PathVariable String username) {
//        logger.info("Fetching all cover letters");
//        return coverLetterService.index(username);
//    }
//
//    @GetMapping("/cover-letter/get-{username}-cover-letter/{id}")
//    public CoverLetterDTO show(@PathVariable String username, @PathVariable Long id) {
//        logger.info("Fetching cover letter for user with ID: {}", username);
//        return coverLetterService.show(username, id);
//    }
//
//    @PatchMapping("/cover-letter/create-{username}-cover-letter")
//    public ResponseEntity<CoverLetterEntity> create(@RequestBody CoverLetterDTO dto) {
//        CoverLetterEntity created = coverLetterService.create(dto).toEntity();
//        return (created != null) ?
//            ResponseEntity.status(HttpStatus.OK).body(created) :
//            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//    }
//
//    @PatchMapping("/cover-letter/patch-{username}-cover-letter/{id}")
//    public ResponseEntity<Object> update(@PathVariable String username, @PathVariable Long id,
//        @RequestBody CoverLetterDTO dto) {
//        CoverLetterEntity updated = coverLetterService.update(username, dto, id).toEntity();
//        return (updated != null) ?
//            ResponseEntity.status(HttpStatus.OK).body(updated) :
//            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//
//    }
//
//    @DeleteMapping("/cover-letter/delete-{username}-cover-letter/{id}")
//    public ResponseEntity<CoverLetterEntity> delete(@PathVariable String username,
//        @PathVariable Long id) {
//        CoverLetterEntity deleted = coverLetterService.delete(username, id);
//        return (deleted != null) ?
//            ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
//            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//    }
//}
