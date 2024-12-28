package com.utc.securityproject.service.base;

import com.hina.socialmedia.entity.base.BaseEntity;

import java.util.List;

public interface BaseService<T extends BaseEntity> {
  T create(T t);
  void delete(Long id);
  T find(Long id);
  boolean isExist(Long id);
  T update(T t);
  List<T> list();
}
