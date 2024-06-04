package org.selfin.repository;

import java.util.List;
import org.selfin.entity.PassedCoverLetterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassedCoverLetterRepository extends JpaRepository<PassedCoverLetterEntity, Long> {

    List<PassedCoverLetterEntity> findByUsernameAndCompany(String username, String company);
}
