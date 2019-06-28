package kh.spring.interfaces;

import java.util.List;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.ReplyDTO;

public interface BoardDAO {
	public int write(BoardDTO dto) throws Exception;
	
	public List<BoardDTO> showAll() throws Exception;
	
	public BoardDTO showContent(int num) throws Exception;
	
	public int viewCount(int num) throws Exception;
	
	public int write_reply(ReplyDTO dto) throws Exception;
	
	public List<ReplyDTO> show_reply(int num) throws Exception;
	
	public int delete_reply(int num) throws Exception;
	
	public List<String> getNavi(int currentPage) throws Exception;
}
