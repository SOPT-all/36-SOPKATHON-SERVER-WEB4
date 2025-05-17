package org.sopkathon.web4.sopkathon36serverweb4.domain.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.enums.Part;
import org.sopkathon.web4.sopkathon36serverweb4.global.common.entity.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED
)
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Part part;

    @Builder
    private User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setPart(final Part part) {
        this.part = part;
    }
}
