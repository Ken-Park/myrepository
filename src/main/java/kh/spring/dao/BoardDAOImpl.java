package kh.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.ReplyDTO;
import kh.spring.interfaces.BoardDAO;
import kh.spring.others.Others;

@Component
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	private SqlSessionTemplate sst;
	
	public int write(BoardDTO dto) {
		return sst.insert("BoardDAO.board_insert",dto);
	}
	
	public List<BoardDTO> showAll(){
		return sst.selectList("BoardDAO.board_showAll");
	}
	
	public BoardDTO showContent(int num) {
		return sst.selectOne("BoardDAO.board_showContent",num);
	}
	
	public int viewCount(int num) {
		return sst.update("BoardDAO.board_viewCount",num);
	}
	
	public int write_reply(ReplyDTO dto) {
		return sst.insert("BoardDAO.reply_insert",dto);
	}
	
	public List<ReplyDTO> show_reply(int num) {
		return sst.selectList("BoardDAO.reply_show",num);
	}
	
	public int delete_reply(int num) {
		return sst.delete("BoardDAO.reply_delete",num);
	}
	
	public int contentcount() {
		return sst.selectOne("BoardDAO.board_count");
	}
	
	public List<String> getNavi(int currentPage) {
		// 네비게이터 제작을 위한 Step

		// 0.현재 내가 위치하는 페이지가 몇 페이지인지

		// 1.전체 레코드(글 갯수) 개수가 몇개인지
		int recordTotalCount = this.contentcount(); //글의 총개수

		// 2.한 페이지에 몇개의 글이 보이게 할 것인지
		int recordCountPerPage = Others.recordCountPerPage; //10으로 하는게 이해하기 제일 쉽다.

		// 3.한 페이지에 네비게이터가 총 몇개가 보이게 할 것인지
		int naviCountPerPage = 10;

		int pageTotalCount = 0;
		//int끼리 나누면 소수점이 안나오므로 14가 나온다 이러면 글 3개가 짤리므로 1을 더해줘서 15페이지를 만들어야 한다.
		//그런데 또 글이 140개일때 페이지가 15개인것은 말이 안되므로 경우의 수를 나눠야한다.
		if(recordTotalCount % recordCountPerPage > 0) { //%=나눗셈을 했을때 나머지만 구하는 식 즉, 나머지가 있는 경우
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;

		}else { //나머지가 없는 경우
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}


		//1페이지보다 작은 숫자는 1페이지로,끝페이지 설정
		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		//자바의 나눗셈은 몫을 제외한 나머지는 모두 버린다는 성질을 이용
		int startNavi = (currentPage - 1) / naviCountPerPage * naviCountPerPage + 1;
		int endNavi = startNavi + (naviCountPerPage - 1);

		//네비 끝값이 최대 페이지 번호를 넘어가면 최대 페이지 번호로 네비 끝값을 설정한다.
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		boolean needPrev = true;
		boolean needNext = true;

		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}

		List<String> arr = new ArrayList<>();

		if(needPrev) {
			arr.add("<이전  ");
		}

		for(int i = startNavi; i <= endNavi; i++) {
			arr.add(i +" ");
		}

		if(needNext) {
			arr.add(" 다음>");
		}
		return arr;
	}
}
