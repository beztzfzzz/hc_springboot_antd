package com.cesi.module.base.config.shiro;

import com.cesi.module.base.util.JwtUtil;
import com.cesi.module.main.sys.po.SysUserPo;
import com.cesi.module.main.sys.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component("userRealm")
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private ISysUserService userService;

    public UserRealm() {
        setName("UserRealm");
        // 采用MD5加密
        setCredentialsMatcher(new HashedCredentialsMatcher("md5"));
    }

    /**
     * 必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = JwtUtil.getUsername(principals.toString());
        SysUserPo user = userService.getUserByLoginCode(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JwtUtil.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("token无效");
        }
        SysUserPo user = userService.getUserByLoginCode(username);
        if (user == null) {
            throw new AuthenticationException("用户不存在!");
        }

        if (!JwtUtil.verify(token, username, user.getPassword())) {
            throw new AuthenticationException("用户名或密码错误");
        }

        return new SimpleAuthenticationInfo(token, token, "UserRealm");
    }

}
