package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberDeleteService;
import mms.member.util.ConsoleUtil;

public class MemberDeleteAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		
		ConsoleUtil cu = new ConsoleUtil();
		System.out.print("삭제할 ");
		int memberId = cu.inputMemberId(sc);
		
		MemberDeleteService memberService = new MemberDeleteService();
		
		boolean isDeleteSuccess = memberService.deleteMember(memberId);
		
		if(isDeleteSuccess) {
			System.out.printf("%d번 회원 정보 삭제 성공\n", memberId);
		}else {
			System.out.println("회원 정보가 존재하지 않습니다");
		}
		
		
	}

}