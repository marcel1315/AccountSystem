package org.example.account.exception;

import lombok.*;
import org.example.account.type.ErrorCode;

@Getter
@AllArgsConstructor
public class AccountException extends RuntimeException {
    private final ErrorCode errorCode;
    private final String errorMessage;

    public AccountException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorCode.getDescription();
    }
}
