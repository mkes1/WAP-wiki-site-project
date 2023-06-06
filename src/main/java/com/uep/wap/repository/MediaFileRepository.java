package com.uep.wap.repository;

import com.uep.wap.model.MediaFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaFileRepository extends CrudRepository<MediaFile, Long> {
}
