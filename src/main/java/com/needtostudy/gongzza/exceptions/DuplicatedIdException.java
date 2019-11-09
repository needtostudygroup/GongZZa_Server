package com.needtostudy.gongzza.exceptions;

/**
 * 회원가입 시 아이디 중복되었을 때 발생하는 예외
 */
public class DuplicatedIdException extends RuntimeException {

    public DuplicatedIdException() {
        super("이미 사용 중인 아이디입니다.");
    }
}
