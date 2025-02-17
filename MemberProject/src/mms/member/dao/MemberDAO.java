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
    
    // ȸ�� �߰�
    public boolean insertNewMember(Member newMember) {
        boolean isInsertSuccess = memberList.add(newMember);
        
        if (isInsertSuccess) {
            String timestamp = getCurrentTimestamp();  
            logList.add("[" + timestamp + "] Added new member: " + newMember);  
        }
        
        return isInsertSuccess;
    }
    
    // ȸ�� ���� ���
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
                System.out.println("�Է��Ͻ� ���̵�� ��ġ�ϴ� ȸ�� ������ �����ϴ�");
            }
        }        
    }
    
    
    // ȸ�� ����
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
            String timestamp = getCurrentTimestamp();  // ���� �ð� ��������
            logList.add(String.format("[%s] Deleted member: %s", timestamp, memberToDelete)); 
            isDeleteSuccess = true;
        }
        
        return isDeleteSuccess;
    }
    
    // ȸ�� ����
    public boolean updateMember(Member updatedMember) { 
        boolean isUpdateSuccess = false;

        for (Member member : memberList) {
            if (member.getId() == updatedMember.getId()) { 
                String timestamp = getCurrentTimestamp();  // ���� �ð� ��������
                logList.add(String.format("[%s] Updated member: %s �� %s", timestamp, member, updatedMember)); 
                memberList.set(memberList.indexOf(member), updatedMember);
                isUpdateSuccess = true;
                break;
            }
        }
        
        return isUpdateSuccess; 
    }
    
    // ��� �α� ��ȯ
    public static List<String> getAllMemberLogs() {
        return logList;  
    }


    // Ư�� ȸ�� ��ȸ
    public Member getMemberById(int memberId) {
        for (Member member : memberList) {
            if (member.getId() == memberId) {
                return member; 
            }
        }
        return null; 
    }
    
 // Ư�� ȸ���� ������ �׼� Ÿ�ӽ����� ��������
    public String getLastActionTimestamp(int memberId) {
        for (int i = logList.size() - 1; i >= 0; i--) { 
            String logEntry = logList.get(i);
            if (logEntry.contains("Member(id=" + memberId + ",")) { 
                return logEntry.substring(1, 20); 
            }
        }
        return "�ش� ȸ���� ����� �����ϴ�."; // �ش� ȸ���� �αװ� ���� ���
    }
    
    public void showLastActionTimestamp(int memberId) {
        String lastActionTime = getLastActionTimestamp(memberId);
        
        if (lastActionTime.equals("�ش� ȸ���� ����� �����ϴ�.")) {
            System.out.println("�ش� ȸ���� �ֱ� ���� ����� �����ϴ�.");
        } else {
            System.out.println("���� ��� : " + lastActionTime);
        }
    
    }


}