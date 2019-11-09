package com.needtostudy.gongzza.daos;

import com.needtostudy.gongzza.vos.School;
import com.needtostudy.gongzza.vos.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    void createUser(User user);

    User selectUserByIdPw(
            @Param("id") String id,
            @Param("password") String password);

    String selectSaltByUserId(@Param("id") String id);

    School selectSchoolIdById(@Param("id") String id);
}
