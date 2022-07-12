package com.luochen.financial.filter;

import com.luochen.financial.utils.JwtTokenProvider;
import io.jsonwebtoken.Claims;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author luochenfx
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) throws ServletException, IOException {
		String token = request.getHeader("token");
		if (StringUtils.hasText(token)) {
			// 解析token
			String userId;
			try {
				Claims claims = JwtTokenProvider.getClaims(token);
				assert claims != null;
				userId = claims.getSubject();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("token 非法!");
			}

			// 从Redis中获取用户信息
//			User user = JSON.parseObject(JSON.toJSONString(redisCache.getCacheObject("loginUser-" + userId)), User.class);

//			if (ObjectUtils.isEmpty(user)) {
//				throw new RemoteException("用户未登陆!");
//			}
//			LoginUser loginUser = new LoginUser();
//			loginUser.setUser(user);
			Object loginUser = null;

			// 存入SecurityContextHolder, 因为后面的filter都是从SecurityContextHolder获取的
			// todo 获取权限列表, 封装到authenticationToken
			List<GrantedAuthority> authorities = null;
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, authorities);
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		}
		filterChain.doFilter(request, response);
	}
}
