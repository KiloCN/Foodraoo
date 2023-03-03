package cn.kilo.foodaroo.controller.filter;

import cn.kilo.foodaroo.common.Result;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * LoginCheckFilter processes the request to determine:
 * - Whether the request for access is a restricted resource
 * - Whether the request is from a logged-in user
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {

    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();


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
                "/backend/**",
                "/backend/**"
        };

        if (checkURI(urls, request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        } else {
            if (request.getSession().getAttribute("employeeId") != null) {
                filterChain.doFilter(request, response);
                return;
            } else {

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
            boolean match = PATH_MATCHER.match(url, requestURI);
            if (match) return true;
        }
        return false;
    }
}
