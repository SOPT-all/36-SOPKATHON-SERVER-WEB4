package org.sopkathon.web4.sopkathon36serverweb4.domain.drinkOption;

import jakarta.persistence.Column;
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
@Table(name = "drink_options")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DrinkOption extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; // PK가 명확하지 않으면 임시 PK 추가

  @Column(name = "drink_id")
  private Long drinkId;

  @Column(name = "option_id")
  private Long optionId;

  @Builder
  public DrinkOption(final Long drinkId, final Long optionId) {
    this.drinkId = drinkId;
    this.optionId = optionId;
  }
}
