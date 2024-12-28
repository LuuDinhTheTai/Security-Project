package com.utc.securityproject.service.base.impl;

import com.hina.socialmedia.entity.base.BaseEntity;
import com.hina.socialmedia.exception.AppException;
import com.hina.socialmedia.exception.ErrorCode;
import com.hina.socialmedia.repository.base.BaseRepository;
import com.hina.socialmedia.service.base.BaseService;
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
  public void delete(Long id) {
    log.info("(delete) id: {}", id);
    repository.deleteById(id);
  }

  @Override
  public T find(Long id) {
    log.debug("(find) id: {}", id);
    return repository.findById(id).orElseThrow(() -> new AppException(ErrorCode.ENTITY_NOT_FOUND));
  }

  @Override
  public boolean isExist(Long id) {
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

//  private void copyNonNullProperties(T source, T target) {
//    BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
//  }
//
//  private String[] getNullPropertyNames(Object source) {
//    final BeanWrapper src = new BeanWrapperImpl(source);
//    PropertyDescriptor[] pds = src.getPropertyDescriptors();
//
//    Set<String> emptyNames = new HashSet<>();
//    for (PropertyDescriptor pd : pds) {
//      Object srcValue = src.getPropertyValue(pd.getName());
//      if (srcValue == null) emptyNames.add(pd.getName());
//    }
//    return emptyNames.toArray(new String[0]);
//  }
}
