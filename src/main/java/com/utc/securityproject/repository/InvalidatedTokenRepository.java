package com.utc.securityproject.repository;

import com.utc.securityproject.entity.InvalidatedToken;
import com.utc.securityproject.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvalidatedTokenRepository extends BaseRepository<InvalidatedToken> {
}
