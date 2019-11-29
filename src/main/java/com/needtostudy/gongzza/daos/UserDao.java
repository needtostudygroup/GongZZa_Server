package com.needtostudy.gongzza.daos;

import com.needtostudy.gongzza.dtos.UserDto;
import com.needtostudy.gongzza.vos.School;
import com.needtostudy.gongzza.vos.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UserDao {

    void createUser(User user);

    UserDto selectUserByIdPw(
            @Param("id") String id,
            @Param("password") String password);

    String selectSaltByUserId(@Param("id") String id);

    School selectSchoolIdById(@Param("id") String id);

    String selectIdByNameAndBirthday(@Param("name") String name,
                                     @Param("birthday") Date birthday);

    UserDto selectUserById(@Param("id") String id);

    UserDto selectUserByIdNameAndBirthday(@Param("id") String id,
                                          @Param("name") String name,
                                          @Param("birthday") Date birthday);

    UserDto selectUserByEmail(@Param("email") String email);

    void updatePassword(@Param("id") String id, @Param("password") String password);
}
