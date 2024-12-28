package com.utc.securityproject.mapper;

import com.hina.socialmedia.dto.response.AccountDTO;
import com.hina.socialmedia.dto.response.PostDTO;
import com.hina.socialmedia.entity.Account;

public class AccountMapper {
  public static AccountDTO toDTO(Account account) {
    return new AccountDTO(
            account.getId(),
            account.getCreatedBy(),
            account.getCreatedAt(),
            account.getLastUpdatedBy(),
            account.getLastUpdatedAt(),
            account.getEmail(),
            account.getPassword(),
            account.getRoles(),
            account.getPosts()
                    .stream()
                    .map(post -> new PostDTO(account.getId(),
                            post.getContent()))
                    .toList());
  }
}
