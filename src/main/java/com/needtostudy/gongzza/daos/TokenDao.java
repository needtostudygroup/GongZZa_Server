package com.needtostudy.gongzza.daos;

import com.needtostudy.gongzza.vos.Token;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TokenDao {

    void insertToken(Token token);

    Token selectToken(@Param("userId") String userId, @Param("token") String token);

    List<Token> selectTokenByUserId(String userId);
}
