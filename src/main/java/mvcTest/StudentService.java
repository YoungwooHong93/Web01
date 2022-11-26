package mvcTest;

import java.util.List;

public class StudentService {
	
	StudentDAO dao = new StudentDAO();
	
	// ** Student List 출력하기
	public List<StudentVO> selectList() {
		return dao.selectList();
	}
	public List<StudentVO> joListPS(StudentVO vo) {
		return dao.joListPS(vo);
	}
	// ** 내정보 보기
	public StudentVO selectOne(StudentVO vo) {
		return dao.selectOne(vo);
	}
	
	// ** Insert
	public int insert(StudentVO vo) {
		return dao.insert(vo);
	} //insert
	
	// ** Update
	public int update(StudentVO vo) {
		return dao.update(vo);
	} //update
	
	// ** Delete
	public int delete(StudentVO vo) {
		return dao.delete(vo);
	} //delete
	
} // class
