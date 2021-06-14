package com.ITIS.security.security;

import com.ITIS.utils.utils.CRModel;
import com.ITIS.utils.utils.ResponseUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 退出处理器 - redis 中移除 jwt token
 */
public class TokenLogoutHandler implements LogoutHandler {
    private JwtTokenManager jwtTokenManager;
    private RedisTemplate redisTemplate;

    public TokenLogoutHandler(JwtTokenManager jwtTokenManager, RedisTemplate redisTemplate) {
        this.jwtTokenManager = jwtTokenManager;
        this.redisTemplate = redisTemplate;
    }

    /**
     * redis 中移除 jwt token
     * @param request
     * @param response
     * @param authentication
     */
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        //1 从header里面获取token
        //2 token不为空，移除token，从redis删除token
        String token = request.getHeader("token");
        if(token != null) {
            //移除
            jwtTokenManager.removeToken(token);
            //从token获取用户名
            String username = jwtTokenManager.getUserInfoFromToken(token);
            redisTemplate.delete(username);
        }
        ResponseUtil.out(response, CRModel.ok());
    }
}
