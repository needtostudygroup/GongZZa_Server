package com.needtostudy.gongzza.user;

import com.google.api.client.util.Base64;
import com.needtostudy.gongzza.daos.AuthenticatedAccountDao;
import com.needtostudy.gongzza.dtos.UserDto;
import com.needtostudy.gongzza.vos.AuthenticatedAccount;
import com.needtostudy.gongzza.vos.User;
import com.needtostudy.gongzza.daos.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private AuthenticatedAccountDao authenticatedAccountDao;

    public UserDto signUp(UserDto userDto) throws Exception {
        AuthenticatedAccount authenticatedAccount = authenticatedAccountDao.selectAuthenticatedAccount(
                new AuthenticatedAccount(
                    userDto.getId(),
                    userDto.getEmail()
                )
        );
        if (authenticatedAccount == null)
            throw new Exception();

        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        KeySpec spec = new PBEKeySpec(userDto.getPassword().toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        User user = new User(userDto, Base64.encodeBase64String(salt));
        user.setPassword(Base64.encodeBase64String(factory.generateSecret(spec).getEncoded()));
        userDao.createUser(user);
        authenticatedAccountDao.deleteAuthenticatedAccount(authenticatedAccount);
        return userDao.selectUserByIdPw(user.getId(), user.getPassword());
    }

    public UserDto getUserById(String id) throws Exception {
        return userDao.selectUserById(id);
    }

    public UserDto getUserByIdPw(String id, String password) throws Exception {
        String salt = userDao.selectSaltByUserId(id);
        if (salt == null)
            throw new Exception();

        password = getEncryptedPassword(password, salt);
        UserDto userDto = userDao.selectUserByIdPw(id, password);
        if (userDto == null)
            throw new Exception();

        return userDto;
    }

    private String getEncryptedPassword(String password, String salt) throws Exception {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), Base64.decodeBase64(salt), 65536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        return Base64.encodeBase64String(factory.generateSecret(spec).getEncoded());
    }

    public String findId(String name, Date birthday) {
        return userDao.selectIdByNameAndBirthday(name, birthday);
    }

    public int authenticateFindPassword(String id, String name, Date birthday) {
        if (userDao.selectUserByIdNameAndBirthday(id, name, birthday) != null)
            return 200;
        return 0;
    }

    public void setNewPassword(String id, String password) throws Exception {
        String salt = userDao.selectSaltByUserId(id);
        if (salt == null)
            throw new Exception();

        password = getEncryptedPassword(password, salt);
        userDao.updatePassword(id, password);
    }
}
