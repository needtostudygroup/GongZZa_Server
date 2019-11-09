package com.needtostudy.gongzza.daos;

import com.needtostudy.gongzza.vos.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    void createUser(User user);

    User selectUserByIdPw(
            @Param("id") String id,
            @Param("password") String password,
            @Param("serviceId") int serviceId);

    String selectSaltByUserId(@Param("id") String id, @Param("serviceId") int serviceId);
}
