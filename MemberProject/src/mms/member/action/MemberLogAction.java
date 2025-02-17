package mms.member.action;

import java.util.List;
import java.util.Scanner;
import mms.member.svc.MemberLogService;
import mms.member.util.ConsoleUtil;

public class MemberLogAction implements Action {

    @Override
    public void execute(Scanner sc) throws Exception {
        ConsoleUtil cu = new ConsoleUtil();
        

        System.out.println("������� : ");
        
        // Retrieve all logs using the service
        MemberLogService logService = new MemberLogService();
        List<String> logs = logService.getAllMemberLogs();  // ������ �κ�
        
        // Print all logs
        if (logs.isEmpty()) {
            System.out.println("����� ã�� ���߽��ϴ�.");
        } else {
            logs.forEach(System.out::println);
        }
    }
}
