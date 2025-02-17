package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberAddService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

public class MemberAddAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		// sc = MemberUI에서 받아온 입력값
		
		ConsoleUtil cu = new ConsoleUtil();
		Member newMember = cu.getNewMember(sc);
//		String date = cu.getDate();
		
		MemberAddService memberService = new MemberAddService();
		
		boolean isAddSuccess = memberService.addMember(newMember);
		
		if(isAddSuccess) {
			System.out.printf("%s 회원정보 추가성공\n", newMember.getName());
		}else {
			System.out.println("데이터 추가 실패");
		}
		
	}

}
//		String log = newMember.getName() + " 회원정보 추가성공 - "+ date;
//		
//		memberService.saveLog(log);