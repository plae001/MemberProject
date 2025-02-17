package mms.member.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mms.member.vo.Member;

public class MemberDAO {

    static List<Member> memberList = new CopyOnWriteArrayList<>();
    static List<String> logList = new CopyOnWriteArrayList<>();  
    
    private static String getCurrentTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
    
    // 회원 추가
    public boolean insertNewMember(Member newMember) {
        boolean isInsertSuccess = memberList.add(newMember);
        
        if (isInsertSuccess) {
            String timestamp = getCurrentTimestamp();  
            logList.add("[" + timestamp + "] Added new member: " + newMember);  
        }
        
        return isInsertSuccess;
    }
    
    // 회원 정보 출력
    public void printMember(int memberId) { 
        if (memberId == 0) { 
            memberList.forEach(System.out::println);
        } else {
            boolean found = false;
            for (Member member : memberList) {
                if (member.getId() == memberId) { 
                    System.out.println(member);
                    found = true; 
                    break;
                }
            }
            
            if (!found) { 
                System.out.println("입력하신 아이디와 일치하는 회원 정보가 없습니다");
            }
        }        
    }
    
    
    // 회원 삭제
    public boolean deleteMember(int memberId) { 
        boolean isDeleteSuccess = false;
        Member memberToDelete = null;
        
        for (Member member : memberList) {
            if (member.getId() == memberId) {
                memberToDelete = member;
                break;
            }
        }
        
        if (memberToDelete != null) {
            memberList.remove(memberToDelete);
            String timestamp = getCurrentTimestamp();  // 현재 시간 가져오기
            logList.add(String.format("[%s] Deleted member: %s", timestamp, memberToDelete)); 
            isDeleteSuccess = true;
        }
        
        return isDeleteSuccess;
    }
    
    // 회원 수정
    public boolean updateMember(Member updatedMember) { 
        boolean isUpdateSuccess = false;

        for (Member member : memberList) {
            if (member.getId() == updatedMember.getId()) { 
                String timestamp = getCurrentTimestamp();  // 현재 시간 가져오기
                logList.add(String.format("[%s] Updated member: %s → %s", timestamp, member, updatedMember)); 
                memberList.set(memberList.indexOf(member), updatedMember);
                isUpdateSuccess = true;
                break;
            }
        }
        
        return isUpdateSuccess; 
    }
    
    // 모든 로그 반환
    public static List<String> getAllMemberLogs() {
        return logList;  
    }


    // 특정 회원 조회
    public Member getMemberById(int memberId) {
        for (Member member : memberList) {
            if (member.getId() == memberId) {
                return member; 
            }
        }
        return null; 
    }
    
 // 특정 회원의 마지막 액션 타임스탬프 가져오기
    public String getLastActionTimestamp(int memberId) {
        for (int i = logList.size() - 1; i >= 0; i--) { 
            String logEntry = logList.get(i);
            if (logEntry.contains("Member(id=" + memberId + ",")) { 
                return logEntry.substring(1, 20); 
            }
        }
        return "해당 회원의 기록이 없습니다."; // 해당 회원의 로그가 없을 경우
    }
    
    public void showLastActionTimestamp(int memberId) {
        String lastActionTime = getLastActionTimestamp(memberId);
        
        if (lastActionTime.equals("해당 회원의 기록이 없습니다.")) {
            System.out.println("해당 회원의 최근 관리 기록이 없습니다.");
        } else {
            System.out.println("관리 기록 : " + lastActionTime);
        }
    
    }


}