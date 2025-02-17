package mms.member.svc;

import mms.member.dao.MemberDAO;
import mms.member.vo.Member;

public class MemberAddService {

	public boolean addMember(Member newMember) throws Exception {
		
		boolean isInsertSuccess = false;
		
		MemberDAO memberDAO = new MemberDAO();
		
		isInsertSuccess = memberDAO.insertNewMember(newMember);
		
		return isInsertSuccess;
	}
	
}