package kh.spring.practice;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.ReplyDTO;
import kh.spring.interfaces.BoardDAO;
import kh.spring.service.ServiceBoard;

@Controller
public class BoardController {

	@Autowired
	private HttpSession session;

	@Autowired
	private ServiceBoard sb;
	
	@Autowired
	private BoardDAO dao;

	@RequestMapping("/boardView")
	public String boardView(HttpServletRequest request) {
		request.setAttribute("result", sb.showAll());
		return "boardView";
	}

	@RequestMapping("/boardWrite") // 게시글 쓰는 화면으로 보냄
	public String boardWrite() {
		return "boardWrite";
	}

	@RequestMapping("/writeProc") // 게시글 쓰고 오는 화면
	public String writeProc(BoardDTO dto,HttpServletRequest request) {
		String resourcePath = session.getServletContext().getRealPath("/resources");
		int currentpage = Integer.parseInt(request.getParameter("number"));
//		List<BoardDTO> result = dao.selectByPage(currentpage);

		try {
			String fileName = System.currentTimeMillis()+dto.getImage().getOriginalFilename();
			File savedFile = new File(resourcePath + "/" + fileName);
			dto.setImgaddr("resources/"+savedFile.getName());
			dto.getImage().transferTo(savedFile );
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String id = (String) session.getAttribute("id");
		dto.setWriter(id);
		sb.write(dto);
		return "writeCompl";
	}

	@RequestMapping("/contentView") // 게시글 클릭 내용
	public String contentView(HttpServletRequest request, BoardDTO dto) {
		int num = Integer.parseInt(request.getParameter("number"));
		sb.viewCount(num);
		request.setAttribute("result", sb.showContent(num));
		request.setAttribute("result2", sb.reply_show(num));
		return "contentView";
	}

	@RequestMapping("/replyProc")
	public String replyProc(HttpServletRequest request, ReplyDTO dto) {
		String id = (String) session.getAttribute("id");
		int num = Integer.parseInt(request.getParameter("prac_board_seq"));
		dto.setReply_writer(id);
		dto.setPrac_board_seq(num);
		sb.reply_write(dto);
		sb.reply_show(num);
		return "redirect:/contentView?number=" + dto.getPrac_board_seq();
	}

	@RequestMapping("/replyDelete")
	public String replyDelete(HttpServletRequest request, ReplyDTO dto) {
		int num = Integer.parseInt(request.getParameter("number"));
		int seq = Integer.parseInt(request.getParameter("seq"));
		sb.reply_delete(num);
		dto.setPrac_board_seq(seq);
		return "redirect:/contentView?number=" + dto.getPrac_board_seq();
	}
}
