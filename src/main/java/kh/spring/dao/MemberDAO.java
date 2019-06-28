package kh.spring.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kh.spring.dto.MemberDTO;

@Component
public class MemberDAO {

	@Autowired
	private JdbcTemplate template;

	@Autowired
	private SqlSessionTemplate sst;

	//	public int joinMember(MemberDTO dto) {
	//		String sql = "insert into prac_member values(prac_member_seq.nextval,?,?,?,?,?,?)";
	//		
	//		try {
	//			int result = template.update(sql, dto.getId(), dto.getPw(), dto.getName(), dto.getAge(), dto.getAddress(), dto.getImgaddr());
	//			return result;
	//		}catch(Exception e) {
	//			e.printStackTrace();
	//			return 0;
	//		}
	//	}

	public int joinMember(MemberDTO dto) {

		return sst.insert("MemberDAO.insert",dto);
	}

//	public boolean login(String id, String pw) {
//		String sql = "select count(*) from prac_member where id = ? and pw = ?";
//
//		try {
//			int result = template.queryForObject(sql, new Object[] {id,pw}, Integer.class);
//			if(result > 0){
//				return true;
//			}else {
//				return false;
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
	
	public int login(MemberDTO dto) {
		
		return sst.selectOne("MemberDAO.login",dto);
	}

	public boolean idexist(String id) {
		String sql = "select count(*) from prac_member where id = ?";

		try {
			int result = template.queryForObject(sql, new Object[] {id}, Integer.class);
			if(result > 0) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public MemberDTO showAll(String id) {
		String sql = "select * from prac_member where id = ?";

		try {
			return template.queryForObject(sql, new Object[] {id}, new RowMapper<MemberDTO>() {

				@Override
				public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					MemberDTO dto = new MemberDTO();
					dto.setId(rs.getString(2));
					dto.setAddress(rs.getString(6));
					dto.setImgaddr(rs.getString(7));
					return dto;
				}});

		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String testSHA256(String str){
		String SHA = ""; 
		try{
			MessageDigest sh = MessageDigest.getInstance("SHA-256"); 
			sh.update(str.getBytes()); 
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer(); 
			for(int i = 0 ; i < byteData.length ; i++){
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			SHA = sb.toString();
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace(); 
			SHA = null; 
		}
		return SHA;
	}
}
