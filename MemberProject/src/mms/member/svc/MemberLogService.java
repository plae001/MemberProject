package mms.member.svc;

import mms.member.dao.MemberDAO;
import java.util.List;

public class MemberLogService {

    public List<String> getAllMemberLogs() {
        return MemberDAO.getAllMemberLogs();  
    }
}