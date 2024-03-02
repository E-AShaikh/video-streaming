package com.videostreaming.sqldatabase.repository;

import com.videostreaming.sqldatabase.model.VidMetaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VidMetaDataRepository extends JpaRepository<VidMetaData, Long> {
}

