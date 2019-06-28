package kh.spring.dto;

import org.springframework.web.multipart.MultipartFile;

public class MemberDTO {
	private int seq;
	private String id;
	private String pw;
	private String name;
	private int age;
	private String address;
	private MultipartFile image;
	private String imgaddr;
	
	public MemberDTO() {
		super();
	}

	public MemberDTO(int seq, String id, String pw, String name, int age, String address, MultipartFile image,
			String imgaddr) {
		super();
		this.seq = seq;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.address = address;
		this.image = image;
		this.imgaddr = imgaddr;
	}

	public MemberDTO(int seq, String id, String pw, String name, int age, String address, String imgaddr) {
		super();
		this.seq = seq;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.address = address;
		this.imgaddr = imgaddr;
	}
	
	

	public MemberDTO(int seq, String id, String pw, String name, int age, String address, MultipartFile image) {
		super();
		this.seq = seq;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.address = address;
		this.image = image;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
