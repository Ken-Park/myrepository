package kh.spring.dto;

import java.sql.Date;

public class ReplyDTO {
	
	private int prac_reply_seq;
	private int prac_board_seq;
	private String reply_contents;
	private String reply_writer;
	private Date reply_writedate;
	
	public ReplyDTO() {
		super();
	}

	public ReplyDTO(int prac_reply_seq, int prac_board_seq, String reply_contents, String reply_writer,
			Date reply_writedate) {
		super();
		this.prac_reply_seq = prac_reply_seq;
		this.prac_board_seq = prac_board_seq;
		this.reply_contents = reply_contents;
		this.reply_writer = reply_writer;
		this.reply_writedate = reply_writedate;
	}

	public int getPrac_reply_seq() {
		return prac_reply_seq;
	}

	public void setPrac_reply_seq(int prac_reply_seq) {
		this.prac_reply_seq = prac_reply_seq;
	}

	public int getPrac_board_seq() {
		return prac_board_seq;
	}

	public void setPrac_board_seq(int prac_board_seq) {
		this.prac_board_seq = prac_board_seq;
	}

	public String getReply_contents() {
		return reply_contents;
	}

	public void setReply_contents(String reply_contents) {
		this.reply_contents = reply_contents;
	}

	public String getReply_writer() {
		return reply_writer;
	}

	public void setReply_writer(String reply_writer) {
		this.reply_writer = reply_writer;
	}

	public Date getReply_writedate() {
		return reply_writedate;
	}

	public void setReply_writedate(Date reply_writedate) {
		this.reply_writedate = reply_writedate;
	}
	
	
}
