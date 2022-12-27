package com.ssmstudy.ssm.Authorization;

import com.ssmstudy.ssm.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 拦截器中获取了redis在业务逻辑中就无法获取？？？
 */
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Autowired
    private IRedisService iRedisService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {

        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        if (method.getAnnotation(Authorization.class) != null){
            //权限校验
            return true;
        }
        //token校验
        //如果验证token失败，返回401错误
        if (method.getAnnotation(NeedToken.class) != null) {
            //从header中得到token
            String authorization = httpServletRequest.getHeader("Authorization");
            if (authorization==null){
                authorization="";
            }
            //System.out.println("authorization = " + authorization);
            boolean b = iRedisService.checkToken("logintoken:" + authorization);
            System.out.println("校验了，"+b);
            System.out.println("logintoken:"+authorization);
            if (b) {

                return true;

            /*权限校验开始
            //请求路径
            String servletPath = httpServletRequest.getServletPath();
            //查询是否有该权限
            Function function = roleService.selectFunc(model.getUserId(),servletPath);
            if(null == function){
            	httpServletResponse.setCharacterEncoding("UTF-8");
            	httpServletResponse.setContentType("text/x-json;charset=UTF-8");
                 解决跨域问题
            	httpServletResponse.setHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("origin"));
                JSONObject jsObject =JSONObject.fromObject(new JsonResult(false, "权限不足", ""));
                httpServletResponse.getWriter().write(jsObject.toString());
                //httpServletResponse.getOutputStream().write(jsObject.toString().getBytes("UTF8"));
                //httpServletResponse.getOutputStream().close();
                return false;
            }
            权限校验结束*/

            }
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}