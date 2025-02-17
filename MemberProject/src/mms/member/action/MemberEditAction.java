package mms.member.action;

import java.util.Scanner;
import mms.member.svc.MemberEditService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

public class MemberEditAction implements Action {

    @Override
    public void execute(Scanner sc) throws Exception {
        ConsoleUtil cu = new ConsoleUtil();
        
        int memberId = cu.inputMemberId(sc); 
        Member updatedMember = cu.EditMember(sc, memberId); 
//        String date = cu.getDate();
        
        MemberEditService memberService = new MemberEditService();
        
        boolean isEditSuccess = memberService.editMember(updatedMember);
        
        if (isEditSuccess) {
            System.out.printf("아이디 %d번 회원정보 수정완료\n", memberId);
        } else {
            System.out.println("해당 회원이 존재하지 않습니다.");
        }
        
    }
}