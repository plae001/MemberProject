package mms.member.util;

import java.util.Scanner;

import mms.member.dao.MemberDAO;
import mms.member.vo.Member;

public class ConsoleUtil {

    static int id = 1;

    public Member getNewMember(Scanner sc) {
        // 기존 코드 유지
        System.out.println("등록할 회원 정보를 입력하세요");
        
        System.out.println("이름 : ");
        String name = sc.next();
        
        System.out.println("주소 : ");
        String addr = sc.next();
        
        System.out.println("이메일 : ");
        String email = sc.next();
        
        System.out.println("국가 : ");
        String nation = sc.next();
        
        System.out.println("나이 : ");
        int age = sc.nextInt();
        
        return new Member(id++, name, addr, email, nation, age);
    }

    public int inputMemberId(Scanner sc) {
        // 조회, 수정, 삭제 기능에서 필요한 ID 값을 입력
        System.out.println("회원의 아이디를 입력하세요");
        int inputId = sc.nextInt();
        return inputId;
    }

    public Member EditMember(Scanner sc, int memberId) {
        
        Member currentMember = new MemberDAO().getMemberById(memberId); // 해당 회원 정보를 가져옴
        
        if (currentMember == null) {
            System.out.println("해당 회원이 존재하지 않습니다.");
            return null; 
        }
        
        System.out.println("수정할 회원 정보를 입력하세요");
        
        String name = currentMember.getName();

        System.out.println("이전 주소: " + currentMember.getAddr() + " 수정할 주소: ");
        String addr = sc.next();

        System.out.println("이전 이메일: " + currentMember.getEmail() + " 수정할 이메일: ");
        String email = sc.next();

        System.out.println("이전 국가: " + currentMember.getNation() + " 수정할 국가: ");
        String nation = sc.next();

        System.out.println("이전 나이: " + currentMember.getAge() + " 수정할 나이: ");
        int age = sc.nextInt();

        return new Member(memberId, name, addr, nation, email, age);
    }
}