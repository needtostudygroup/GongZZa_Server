package com.needtostudy.gongzza.daos;

import com.needtostudy.gongzza.dtos.UserDto;
import com.needtostudy.gongzza.vos.AuthMail;
import com.needtostudy.gongzza.vos.ChatLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Repository;

import javax.mail.internet.MimeMessage;
import java.util.List;

@Repository
public interface AuthMailDao {

    void createAuthMail(AuthMail authMail);

    AuthMail selectAuthMail(@Param("userId") String userId, @Param("email") String email);

    AuthMail selectAuthMailByCode(@Param("userId") String userId, @Param("email") String email, @Param("code") String code);

    void deleteAuthMail(@Param("userId") String userId, @Param("email") String email);
}
