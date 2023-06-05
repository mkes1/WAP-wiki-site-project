package com.uep.wap.repository;

import com.uep.wap.model.Section;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends CrudRepository<Section, Long> {
    // Additional methods for section repository if needed
}
