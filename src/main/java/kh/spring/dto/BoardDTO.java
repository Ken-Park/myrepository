package kh.spring.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class BoardDTO {
	
	private int prac_board_seq;
	private String title;
	private String contents;
	private String writer;
	private Date writedate;
	private int viewcount;
	private MultipartFile image;
	private String imgaddr;
	
	public BoardDTO() {
		super();
	}
	public BoardDTO(int prac_board_seq, String title, String contents, String writer, Date writedate, int viewcount,
			MultipartFile image, String imgaddr) {
		super();
		this.prac_board_seq = prac_board_seq;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.writedate = writedate;
		this.viewcount = viewcount;
		this.image = image;
		this.imgaddr = imgaddr;
	}
	public int getPrac_board_seq() {
		return prac_board_seq;
	}
	public void setPrac_board_seq(int prac_board_seq) {
		this.prac_board_seq = prac_board_seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public String getImgaddr() {
		return imgaddr;
	}
	public void setImgaddr(String imgaddr) {
		this.imgaddr = imgaddr;
	} 
	
	
	
}
