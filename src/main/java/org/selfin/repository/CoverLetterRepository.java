package org.selfin.repository;

import java.util.List;
import org.selfin.entity.CoverLetterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoverLetterRepository extends JpaRepository<CoverLetterEntity, Long> {

    List<CoverLetterEntity> findAllByUsername(String username);
    CoverLetterEntity findByState(Long state);
}
