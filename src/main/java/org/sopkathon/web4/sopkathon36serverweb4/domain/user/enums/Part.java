package org.sopkathon.web4.sopkathon36serverweb4.domain.user.enums;

import lombok.Getter;

@Getter
public enum Part {
  PLAN("기획"),
  DESIGN("디자인"),
  WEB("웹"),
  ANDROID("안드로이드"),
  IOS("IOS"),
  SERVER("서버");

  private final String displayName;

  Part(String displayName) {
    this.displayName = displayName;
  }
}