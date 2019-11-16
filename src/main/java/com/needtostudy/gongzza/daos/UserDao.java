package com.needtostudy.gongzza.daos;

import com.needtostudy.gongzza.dtos.UserDto;
import com.needtostudy.gongzza.vos.School;
import com.needtostudy.gongzza.vos.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    void createUser(User user);

    UserDto selectUserByIdPw(
            @Param("id") String id,
            @Param("password") String password);

    String selectSaltByUserId(@Param("id") String id);

    School selectSchoolIdById(@Param("id") String id);

    String selectIdByNameAndEmail(@Param("name") String name,
                                  @Param("email") String email);

    UserDto selectUserById(@Param("id") String id);

    UserDto selectUserByIdAndEmail(@Param("id") String id,
                                   @Param("email") String email);

    UserDto selectUserByEmail(@Param("email") String email);

    void updatePassword(@Param("id") String id, @Param("password") String password);
}
