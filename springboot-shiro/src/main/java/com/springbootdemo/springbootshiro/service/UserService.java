package com.springbootdemo.springbootshiro.service;

import com.springbootdemo.springbootshiro.entity.UserEntity;
import com.springbootdemo.springbootshiro.repository.UserRepository;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Little Rookies
 * @Date: 2018-11-29 16:17
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String login(String account, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(account, password);
        try {
            subject.login(usernamePasswordToken);
            return "success";
        } catch (UnknownAccountException e) {
            //账号不存在和下面密码错误一般都合并为一个账号或密码错误，这样可以增加暴力破解难度
            return "message:账号不存在！";
        } catch (DisabledAccountException e) {
            return "message:账号未启用！";
        } catch (IncorrectCredentialsException e) {
            return "message:密码错误！";
        } catch (Throwable e) {
            return "message:未知错误！";
        }
    }

    public String zhuce(UserEntity userEntity) {
        UserEntity firstByAccount = userRepository.findFirstByAccount(userEntity.getAccount());
        if (firstByAccount == null) {
            ByteSource salt = ByteSource.Util.bytes(userEntity.getAccount());
            String newPs = new SimpleHash("MD5", userEntity.getPassword(), salt.toString(), 23).toHex();
            userEntity.setPassword(newPs);
            userEntity.setSalt(salt.toString());
            userEntity.setRoleId(2L);
            userRepository.save(userEntity);
            return "success";
        }
        return "已存在";
    }
}
