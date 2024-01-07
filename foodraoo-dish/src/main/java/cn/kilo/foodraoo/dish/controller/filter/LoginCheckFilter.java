package cn.kilo.foodraoo.dish.controller.filter;

import cn.kilo.foodraoo.common.BaseContext;
import cn.kilo.foodraoo.common.Result;
import com.alibaba.fastjson.JSON;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import java.io.IOException;

/**
 *
 * LoginCheckFilter processes the request to determine:
 * - Whether the request for acces´s is a restricted resource
 * - Whether the request is from a logged-in user
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {

    /**
     * This filter intercepts all requests
     * - Determine whether the request access is a restricted resource
     *    - Access to unrestricted resources: release
     *    - Access to restricted resources:
     *      - whether the requester is logged in：
     *        - Logged in: release
     *        - Not logged in: Let the front end intercept and jump to the login page through the "NOTLOGIN" message
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

//        log.info("Intercept："+request.getRequestURI());

        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/user/login",
                "/user/sendMsg",
                "/common/**",
                "/backend/**",
                "/front/**"
        };

        if (checkURI(urls, request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        } else {
            if (request.getSession().getAttribute("employeeId") != null) {
                Long userId = (Long) request.getSession().getAttribute("employeeId");
                BaseContext.setCurrentId(userId);

                filterChain. doFilter(request, response);
                return;
            }
            else if(request.getSession().getAttribute("user") != null){
                Long userId = (Long) request.getSession().getAttribute("user");
                BaseContext.setCurrentId(userId);

                filterChain. doFilter(request, response);
                return;
            }
            else {

                response.getWriter().write(JSON.toJSONString(Result.error("NOTLOGIN")));
                return;
            }
        }

    }



    /**
     * Path match to check whether the requested URI is in the release list
     *
     * @param urls
     * @param requestURI
     * @return
     */
    public boolean checkURI(String[] urls, String requestURI) {
        for (String url : urls) {
//            boolean match = PATH_MATCHER.match(url, requestURI);
            boolean match = new AntPathMatcher().match(url, requestURI);
            if (match) return true;
        }
        return false;
    }
}
