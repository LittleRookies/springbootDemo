package com.springbootdemo.springbootshiro.config.shiro;

import com.springbootdemo.springbootshiro.entity.PermissionEntity;
import com.springbootdemo.springbootshiro.entity.UserEntity;
import com.springbootdemo.springbootshiro.repository.PermissionRepository;
import com.springbootdemo.springbootshiro.repository.UserRepository;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: Little Rookies
 * @Date: 2018-11-29 15:41
 */
public class RealmConf extends AuthorizingRealm {
    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取登录用户名
        UserEntity userEntity = (UserEntity) principals.getPrimaryPrincipal();
        //查询角色权限
        List<PermissionEntity> allByName = permissionRepository.findAllByName(userEntity.getAccount());

        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //添加角色
        simpleAuthorizationInfo.addRole(userEntity.getRoleId().toString());
        //添加权限
        for (PermissionEntity permissionEntity : allByName) {
            simpleAuthorizationInfo.addStringPermission(permissionEntity.getPermission());
        }
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (token.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        UserEntity userEntity = userRepository.findFirstByAccount(usernamePasswordToken.getUsername());


        if (userEntity == null) {
            //这里返回后会报出对应异常
            return null;
        }


        return new SimpleAuthenticationInfo(userEntity, userEntity.getPassword().toCharArray(), ByteSource.Util.bytes(userEntity.getSalt()), getName());
    }
}
