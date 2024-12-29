package com.utc.securityproject.service.base.impl;

import com.utc.securityproject.entity.base.BaseEntity;
import com.utc.securityproject.exception.AppException;
import com.utc.securityproject.exception.ErrorCode;
import com.utc.securityproject.repository.base.BaseRepository;
import com.utc.securityproject.service.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Slf4j
public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

  private final BaseRepository<T> repository;

  public BaseServiceImpl(BaseRepository<T> repository) {
    this.repository = repository;
  }

  @Override
  public T create(T t) {
    log.info("(create) object: {}", t);
    return repository.save(t);
  }

  @Override
  public void delete(String id) {
    log.info("(delete) id: {}", id);
    repository.deleteById(id);
  }

  @Override
  public T find(String id) {
    log.debug("(find) id: {}", id);
    return repository.findById(id).orElseThrow(() -> new AppException(ErrorCode.ENTITY_NOT_FOUND));
  }

  @Override
  public boolean isExist(String id) {
    log.debug("(isExist) id: {}", id);
    return repository.existsById(id);
  }

  @Override
  public T update(T t) {
    log.info("(update) object: {}", t);

    T exist = repository.findById(t.getId())
                      .orElseThrow(() -> new AppException(ErrorCode.ENTITY_NOT_FOUND));

    BeanUtils.copyProperties(t, exist, "id", "createBy", "createAt");
    return repository.save(exist);
  }

  @Override
  public List<T> list() {
    return repository.findAll();
  }
}
