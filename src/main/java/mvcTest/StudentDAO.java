package mvcTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//** DAO(Data Access Object)
//=> SQL 구문 처리
//=> CRUD 구현 
//   Create(insert), Read(select), Update, Detete

public class StudentDAO {
	// ** 전역변수 정의
	private static Connection cn = DBConnection.getConnection();
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static String sql;	
	
	// ** Student List 출력하기
	public List<StudentVO> selectList() {
		sql = "select * from student";
		// ** 결과를 담을 콜렉션 정의 (ArrayLIst 가 가장적합)
		List<StudentVO> list = new ArrayList<>(); 
		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			// => select 문 결과가 있는지 확인
			if (rs.next()) {
				// 결과를 모아 담아서 요청한곳(서비스 -> 컨트롤러)으로 전달
				do {
					StudentVO vo = new StudentVO();
					vo.setSnum(rs.getInt(1));
					vo.setSname(rs.getString(2));
					vo.setAge(rs.getInt(3));
					vo.setInfo(rs.getString(4));
					vo.setJno(rs.getInt(5));
					vo.setId(rs.getString(6));
					vo.setHeight(rs.getDouble(7));
					list.add(vo);
				}while(rs.next());
				return list;
			}else {
				System.out.println("** selectList : 출력자료가 1건도 없음 **");
			}
		} catch (Exception e) {
			System.out.println("** selectList Exception => "+e.toString());
		}
		return null;
	} //selectList
	
	// ** PreparedStatement Test
	// => 매개변수, return 값 적용하기
	public List<StudentVO> joListPS(StudentVO vo) {
		sql = "select * from student where jno=?";
		List<StudentVO> list = new ArrayList<>();
		try {
			pst = cn.prepareStatement(sql);  
			pst.setInt(1, vo.getJno());   
			rs = pst.executeQuery();
			// => select 문 결과가 있는지 확인
			if (rs.next()) {
				do {
					StudentVO vos = new StudentVO();
					vos.setSnum(rs.getInt(1));
					vos.setSname(rs.getString(2));
					vos.setAge(rs.getInt(3));
					vos.setInfo(rs.getString(4));
					vos.setJno(rs.getInt(5));
					vos.setId(rs.getString(6));
					vos.setHeight(rs.getDouble(7));
					list.add(vos);
				}while(rs.next());
				return list;
			}else {
				System.out.println("** joListPS : 출력자료가 1건도 없음 **");
			}
		} catch (Exception e) {
			System.out.println("** joListPS Exception => "+e.toString());
		}
		return null;
	} //joListPS
	
	// ** 내정보 보기
	public StudentVO selectOne(StudentVO vo) {
		sql = "select * from student where snum=?";
		try {
			pst=cn.prepareStatement(sql);
			pst.setInt(1, vo.getSnum());
			rs = pst.executeQuery();
			if (rs.next()) {
				vo.setSnum(rs.getInt(1));
				vo.setSname(rs.getString(2));
				vo.setAge(rs.getInt(3));
				vo.setInfo(rs.getString(4));
				vo.setJno(rs.getInt(5));
				vo.setId(rs.getString(6));
				vo.setHeight(rs.getDouble(7));
				return vo;
			}else {
				System.out.println("** snum 에 해당하는 학생은 존재하지 않습니다. **");
				return null;
			}
		} catch (Exception e) {
			System.out.println("** selectOne Exception => "+e.toString());
			return null;
		}
	} //selectOne
	
	// ** Insert
	// => Insert 의 성공여부는 실행된 레코드(Row) 갯수로 확인 ( 0 면 실패 )
	public int insert(StudentVO vo) {
		sql="insert into student(sname, age, info, jno, id, height) values(?,?,?,?,?,?)";
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1, vo.getSname());
			pst.setInt(2, vo.getAge());
			pst.setString(3, vo.getInfo());
			pst.setInt(4, vo.getJno());
			pst.setString(5, vo.getId());
			pst.setDouble(6, vo.getHeight());
			return pst.executeUpdate();  // 실행된 레코드(Row) 갯수를 return
		} catch (Exception e) {
			System.out.println("** insert Exception => "+e.toString());
			return 0;
		}
	} //insert
	
	// ** Update
	// => sname 으로 찾고, age 와 id 수정
	public int update(StudentVO vo) {
		sql="update student set age=?, id=? where sname=?";
		try {
			pst=cn.prepareStatement(sql);
			pst.setInt(1, vo.getAge());
			pst.setString(2, vo.getId());
			pst.setString(3, vo.getSname());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("** update Exception => "+e.toString());
			return 0;
		}
	} //update
	
	// ** Delete
	// => sname 으로 찾아서 삭제
	public int delete(StudentVO vo) {
		sql="delete from student where sname=?";
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1, vo.getSname());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("** delete Exception => "+e.toString());
			return 0;
		}
	} //delete	

} //class
