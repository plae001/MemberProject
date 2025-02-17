package mms.member.svc;

import mms.member.dao.MemberDAO;

public class MemberPrintService {
	
	public void printMember(int memberId) throws Exception {
			
		MemberDAO memberDAO = new MemberDAO();
		
		memberDAO.printMember(memberId);
		
	}

}