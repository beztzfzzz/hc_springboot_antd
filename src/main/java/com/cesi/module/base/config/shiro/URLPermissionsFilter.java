package com.cesi.module.base.config.shiro;

import com.cesi.module.base.util.StringUtils;
import com.cesi.module.main.sys.service.ISysUserService;
import com.google.common.collect.Lists;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Component("urlPermissionsFilter")
public class URLPermissionsFilter extends PermissionsAuthorizationFilter{
    @Autowired
    private ISysUserService userService;

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
        String curUrl = getRequestUrl(request);
        Subject subject = SecurityUtils.getSubject();
        if(subject.getPrincipal() == null
                || StringUtils.endsWithAny(curUrl, ".js",".css",".html")
                || StringUtils.endsWithAny(curUrl, ".jpg",".png",".gif", ".jpeg")
                || StringUtils.equals(curUrl, "/unauthor")) {
            return true;
        }
        List<String> urls = Lists.newArrayList();//userService.findPermissionUrl(subject.getPrincipal().toString());

        return urls.contains(curUrl);
    }

    /**
     * 获取当前URL+Parameter
     * @author lance
     * @since  2014年12月18日 下午3:09:26
     * @param request	拦截请求request
     * @return			返回完整URL
     */
    private String getRequestUrl(ServletRequest request) {
        HttpServletRequest req = (HttpServletRequest)request;
        String queryString = req.getQueryString();

        queryString = StringUtils.isBlank(queryString)?"": "?"+queryString;
        return req.getRequestURI()+queryString;
    }
}