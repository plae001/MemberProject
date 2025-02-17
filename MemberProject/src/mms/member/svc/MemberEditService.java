package mms.member.svc;

import mms.member.dao.MemberDAO;
import mms.member.vo.Member;

public class MemberEditService {

    private MemberDAO memberDAO;

    public MemberEditService() {
        this.memberDAO = new MemberDAO();
    }

    public boolean editMember(Member updatedMember) {
        return memberDAO.updateMember(updatedMember); 
    }
}