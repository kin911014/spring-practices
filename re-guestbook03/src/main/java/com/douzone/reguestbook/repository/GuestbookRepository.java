package com.douzone.reguestbook.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.douzone.reguestbook.vo.GuestbookVo;

@Repository
public class GuestbookRepository {
	
	public List<GuestbookVo> findAll(){
		List<GuestbookVo> result = new ArrayList<GuestbookVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		conn = getConnection();
		
		String sql = "select no, name, contents, password, date_format(reg_date, '%Y-%m-%d' )\r\n" + 
				"from guestbook\r\n" + 
				"order by no desc"; 
		pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		
		// 5. 결과 가져오기
		while(rs.next()) {
			// ()안은 인덱스를 가져오는게 좋다.
			Long no = rs.getLong(1);
			String name = rs.getString(2);
			String contents = rs.getString(3);
			String password = rs.getString(4);
			String reg = rs.getString(5);
			
			
			GuestbookVo vo = new GuestbookVo();
			vo.setNo(no);
			vo.setName(name);
			vo.setContents(contents);
			vo.setPassword(password);
			vo.setReg(reg);
			
			result.add(vo);
		}
		
		} catch (SQLException e) {
			System.out.println("error : " + e);
		}finally {
			// 6. 자원정리
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}	
	
	
public Boolean insert(GuestbookVo vo) {
		
		Boolean result  = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
		conn = getConnection();
		
		String sql = "insert into guestbook values(null, ?, ?, ?, curdate())";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1,vo.getName());
		pstmt.setString(2, vo.getContents());
		pstmt.setString(3, vo.getPassword());
		
		int count = pstmt.executeUpdate();
		
		// 5. 성공여부
		result = count == 1;
		
		} catch (SQLException e) {
			System.out.println("error : " + e);
		}finally {
			// 6. 자원정리
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
public Boolean delete(Long no,String password) {
	
	Boolean result  = false;
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	try {
	conn = getConnection();
	
	String sql = "delete from guestbook where no = ? and password = ?";
	pstmt = conn.prepareStatement(sql);
	
	pstmt.setLong(1, no);
	pstmt.setString(2, password);
	
	int count = pstmt.executeUpdate();
	
	// 5. 성공여부
	result = count == 1;
	
	} catch (SQLException e) {
		System.out.println("error : " + e);
	}finally {
		// 6. 자원정리
		try {
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return result;
}

	public Boolean ck(GuestbookVo vo) {
		Boolean result  = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		try {
		conn = getConnection();
		
		String sql = "select count(no)\r\n" + 
				" from guestbook\r\n" + 
				" where no = ?\r\n" + 
				" and password = ?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setLong(1, vo.getNo());
		pstmt.setString(2, vo.getPassword());
		
		int count = 0;
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			// ()안은 인덱스를 가져오는게 좋다.
			count = rs.getInt(1);
			
		}
		// 5. 성공여부
		result = count == 1;
		
		} catch (SQLException e) {
			System.out.println("error : " + e);
		}finally {
			// 6. 자원정리
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			// 1. JDBC Driver(MySQL)  로딩
		Class.forName("org.mariadb.jdbc.Driver");

		// 2. 연결하기
		String url = "jdbc:mysql://192.168.1.105:3307/webdb";
		conn = DriverManager.getConnection(url, "webdb", "webdb");
		}catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		}
		
		return conn;
	}
}
