package com.douzone.emaillist.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.douzone.emaillist.vo.EmaillistVo;

@Repository
public class EmaillistRepository {

	public List<EmaillistVo> findAll() {
		List<EmaillistVo> result = new ArrayList<EmaillistVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String sql = "select first_name, last_name, email \r\n" + "	from emaillist \r\n" + " order by no desc";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			// 5. 결과 가져오기
			while (rs.next()) {
				// ()안은 인덱스를 가져오는게 좋다.
				String firstName = rs.getString(1);
				String lastName = rs.getString(2);
				String email = rs.getString(3);

				EmaillistVo vo = new EmaillistVo();
				vo.setFirstName(firstName);
				;
				vo.setLastName(lastName);
				vo.setEmail(email);

				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			// 6. 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public Boolean insert(EmaillistVo emaillistVo) {

		Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into emaillist values(null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, emaillistVo.getFirstName());
			pstmt.setString(2, emaillistVo.getLastName());
			pstmt.setString(3, emaillistVo.getEmail());

			int count = pstmt.executeUpdate();

			// 5. 성공여부
			result = count == 1;

		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			// 6. 자원정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
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
			// 1. 드라이버 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			// 2. 연결하기
			String url = "jdbc:mysql://192.168.1.105:3307/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드러이버 로딩 실패:" + e);
		}

		return conn;
	}
}
