package com.testa.usermanager.interceptor;

import com.alibaba.fastjson.JSON;
import com.testa.usermanager.vo.R;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class PermissionInterceptor implements HandlerInterceptor {

    private static final String code = "maoyongqiaokokthisis";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 放行OPTIONS请求
        if (HttpMethod.OPTIONS.matches(request.getMethod())) {
            return true;
        }

        // 获取请求头
        String authentication = request.getHeader("Authentication");
        // 两者相等 -> 通过放行, 两者不相等 -> 不通过不放行
        if (code.equals(authentication)) {
            // 放行
            return true;
        }else {
            // 不放行, 回传没有权限
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println(JSON.toJSONString(R.error().message("没有操作权限")));
            return false;
        }
    }
}
