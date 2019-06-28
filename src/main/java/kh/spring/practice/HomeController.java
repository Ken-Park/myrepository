package kh.spring.practice;



import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.spring.dao.MemberDAO;
import kh.spring.dto.MemberDTO;

@Controller
public class HomeController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private MemberDAO dao;
	
	@RequestMapping("/")
	public String index() {
		return "home";
	}
	
	@RequestMapping("/joinMemberForm")
	public String joinMember() {
		return "joinMemberForm";
	}
	
	@ResponseBody
	@RequestMapping("/idexist")
	public String idExist(String id) {
		boolean result = dao.idexist(id);
		if(result) {
			return "0";
		}else {
			return "1";
		}
	}
	
	@RequestMapping("/joinMemberProc")
	public String joinMemberProc(MemberDTO dto) {
		
		String resourcePath = session.getServletContext().getRealPath("/resources");
		System.out.println(resourcePath);
		try {
			String fileName = dto.getId() + "profile_image.png";
			dto.getImage().transferTo(new File(resourcePath + "/" + fileName));
			dto.setImgaddr(fileName);
			String pw = dao.testSHA256(dto.getPw());
			dto.setPw(pw);
			int result = dao.joinMember(dto);
		if(result == 1) {
			return "redirect:/";
		}else {
			return "joinFail";
		}
		}catch(Exception e){
			e.printStackTrace();
			return "joinFail";
		}
		
	}
	
	@RequestMapping("/loginProc")
	public String login(MemberDTO dto) {
		String pw = dao.testSHA256(dto.getPw());
		dto.setPw(pw);
		int result = dao.login(dto);
		if(result == 1) {
			session.setAttribute("id", dto.getId());
			return "home";
		}else {
			return "error";
		}
		
	}
	
	@RequestMapping("/logoutProc")
	public String logout() {
		session.invalidate();
		return "home";
	}
	
	@RequestMapping("/myPageForm")
	public String mypageForm(HttpServletRequest request) {
		String id = (String)session.getAttribute("id");
		MemberDTO dto = dao.showAll(id);
		
		request.setAttribute("result", dto);
		return "mypage";
	}
	
	@RequestMapping("/chatProc")
	public String chatProc() {
		
		String id = (String)session.getAttribute("id");
		session.setAttribute("id", id);
		return "chatPage";
	}
	
	
}
