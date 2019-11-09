package com.needtostudy.gongzza.exceptions;

/**
 * 회원가입 시 비밀번호가 적절하지 않을 때 발생하는 예외
 */
public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException() {
        super("비밀번호는 8자리 이상이여야 합니다.");
    }
}
