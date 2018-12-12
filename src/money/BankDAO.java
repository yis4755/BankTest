package money;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BankDAO {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	BankDTO dto;

	// 생성자(DB 연결)
	public BankDAO() throws Exception {
		this.con = new DBConnector().connection();
	}

	// 회원 정보 삽입(데이타 삽입)
	public void insert(String id, String name, int age, String tel) throws Exception {

		// SQL문 작성
		String sql = "insert into member values (?, ?, ?, ?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, name);
		ps.setInt(3, age);
		ps.setString(4, tel);

		ps.executeUpdate();
		System.out.println("회원 정보 삽입 완료");
	}

	// 회원 정보 변경
	public void update(String id, String tel) throws Exception {

		// SQL문 작성
		String sql = "update member set tel = ? where id = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, tel);
		ps.setString(2, id);

		ps.executeUpdate();
		System.out.println("회원 정보 변경 완료");
	}

	// 회원 탈퇴
	public void delete(String id) throws Exception {

		// SQL문 작성
		String sql = "delete from member where id = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, id);

		ps.executeUpdate();
		System.out.println("회원 탈퇴 완료");
	}

	// 회원 검색
	public BankDTO select(String id) throws Exception {

		// SQL문 작성
		String sql = "select * from member where id = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, id);
		rs = ps.executeQuery();

		// DTO 객체 생성
		dto = new BankDTO();

		while (rs.next()) {
			// 입력 받은 아이디와 맞는지 확인 후 dto에 값 저장
			if (id.equals(rs.getString(1))) {
				dto.setId(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setAge(rs.getInt(3));
				dto.setTel(rs.getString(4));
			}
		}
		return dto;
	}

	// 회원 전체 리스트

	public ArrayList<BankDTO> selectAll() throws Exception {

		// SQL문 작성
		String sql = "select * from member";
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();

		// 컬렉션(ArrayList) 객체 생성
		ArrayList<BankDTO> list = new ArrayList<BankDTO>();

		while (rs.next()) {
			// while 문이 반복 될 때마다 dto 객체를 생성하면서 새로운 주소값 부여
			dto = new BankDTO();
			dto.setId(rs.getString(1));
			dto.setName(rs.getString(2));
			dto.setAge(rs.getInt(3));
			dto.setTel(rs.getString(4));

			//	ArrayList에 dto 주소값 저장.
			list.add(dto);
		}
		return list;
	}
}
