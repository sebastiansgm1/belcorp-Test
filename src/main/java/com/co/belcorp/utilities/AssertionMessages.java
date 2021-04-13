package com.co.belcorp.utilities;

import lombok.Getter;

@Getter
public enum AssertionMessages {
  ERROR_ADD_ADDRESS("Failed to add address");

  private String message;

  AssertionMessages(String message) {
    this.message = message;
  }
}
