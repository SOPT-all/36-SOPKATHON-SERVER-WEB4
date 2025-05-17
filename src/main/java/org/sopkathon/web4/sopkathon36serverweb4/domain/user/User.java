package org.sopkathon.web4.sopkathon36serverweb4.domain.user;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.sopkathon.web4.sopkathon36serverweb4.global.common.entity.BaseEntity;

public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
}
