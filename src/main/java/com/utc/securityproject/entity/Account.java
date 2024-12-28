package com.utc.securityproject.entity;

import com.hina.socialmedia.constants.Constant;
import com.hina.socialmedia.entity.base.BaseEntity;
import com.hina.socialmedia.validation.ValidateEmail;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Account extends BaseEntity {
    @Column(unique = true)
    @ValidateEmail
    private String email;
    @Column(nullable = false)
    private String password;

    private String roles = Constant.USER;

    @OneToMany(mappedBy = "account")
    private List<Post> posts;
}