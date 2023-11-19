package com.example.gigacf.v2.common;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j2;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Log4j2
public class MyInterceptor implements HandlerInterceptor {

	 
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("===============================================");
        log.info("==================== BEGIN ====================");
        log.info("handler(컨트롤러, 메소드) : "+handler);
        log.info("Request URI : " + request.getRequestURI());
        
		/* 세션 생명주기 관리 */
        HttpSession httpSession = request.getSession(false); // 세션이 없으면 세션을 생성해주지 않는다.
        if(httpSession != null) {
        	log.info("🤡🤡🤡🤡세센정보 조회🤡🤡🤡🤡");
        	log.info("sessionId={}", httpSession.getId());  // 세션 ID
    		log.info("getMaxInactiveInterval={}", httpSession.getMaxInactiveInterval()); 	// 만료 시간(마지막 활동 시간을 기준으로 만료)
    		log.info("creationTime={}", new Date(httpSession.getCreationTime())); // 생성 시간
    		log.info("lastAccessedTime={}", new Date(httpSession.getLastAccessedTime())); // 마지막 활동 시간
        } else {
        	log.info("🤡🤡🤡🤡세센이 존재하지 않습니다🤡🤡🤡🤡");
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    	log.info("modelAndView(URL, Model) : "+modelAndView);
    	log.info("handler(컨트롤러, 메소드) : "+handler);
    	log.info("response : "+response.getStatus());
        log.info("==================== END ======================");
        log.info("===============================================");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

}