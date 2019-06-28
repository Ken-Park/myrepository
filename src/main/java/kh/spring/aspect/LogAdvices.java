package kh.spring.aspect;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.dto.MemberDTO;

@Component
@Aspect
public class LogAdvices {
	
	@Autowired
	private HttpSession session;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
	
	@Around("execution(* kh.spring.practice.HomeController.mypageForm(..))")
	public Object loginCheck(ProceedingJoinPoint pjp ) throws Throwable{
		 HttpServletRequest request = (HttpServletRequest)pjp.getArgs()[0];
		
		String id = (String)session.getAttribute("id");
		
		if(id == null) {
			 request.setAttribute("msg", "로그인 진행");
			return "home";
		}else {
			return pjp.proceed();
		}
	}
}
