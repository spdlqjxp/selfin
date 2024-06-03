package org.selfin.repository;

import java.util.List;
import org.selfin.entity.CoverLetterEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoverLetterRepository extends CrudRepository<CoverLetterEntity, Long> {

    CoverLetterEntity findCoverLetterEntityByUsernameAndId(String username, Long id);

    List<MyCoverLetter> findByUsername(String username);
}
