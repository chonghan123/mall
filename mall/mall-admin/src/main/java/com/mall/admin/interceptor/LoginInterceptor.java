package com.mall.admin.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hc
 * @classname LoginInterceptor
 * @description TODO
 * @date 2020/3/24
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      if (("/admin/login").equals(request.getRequestURI())) {
          return true;
      }
      Object obj = request.getSession().getAttribute("user");
      if (obj==null) {
          response.sendRedirect("/admin/login");
          return  false;
      }
      return  true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
