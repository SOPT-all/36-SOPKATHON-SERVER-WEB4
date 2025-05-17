package org.sopkathon.web4.sopkathon36serverweb4.domain.drink;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopkathon.web4.sopkathon36serverweb4.global.common.entity.BaseEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Drink extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String description;

  private String location;

  private String imageLink;

  @Builder
  public Drink(final String name, final String description, final String location, final String imageLink) {
    this.name = name;
    this.description = description;
    this.location = location;
    this.imageLink = imageLink;
  }
}
