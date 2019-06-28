package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.ReplyDTO;
import kh.spring.interfaces.BoardDAO;

@Component
public class ServiceBoard {
	
	@Autowired
	BoardDAO dao;
	
	public void write(BoardDTO dto) {
		try {
			dao.write(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<BoardDTO> showAll() {
		try {
			return dao.showAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public BoardDTO showContent(int num) {
		try {
			return dao.showContent(num);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int viewCount(int num) {
		
		try {
			return dao.viewCount(num);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public void reply_write(ReplyDTO dto) {
		try {
			dao.write_reply(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<ReplyDTO> reply_show(int num) {
		try {
			return dao.show_reply(num);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int reply_delete(int num) {
		try {
			return dao.delete_reply(num);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
}
