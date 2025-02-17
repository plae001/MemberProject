package mms.member.action;

import java.util.List;
import java.util.Scanner;
import mms.member.svc.MemberLogService;
import mms.member.util.ConsoleUtil;

public class MemberLogAction implements Action {

    @Override
    public void execute(Scanner sc) throws Exception {
        ConsoleUtil cu = new ConsoleUtil();
        

        System.out.println("관리기록 : ");
        
        // Retrieve all logs using the service
        MemberLogService logService = new MemberLogService();
        List<String> logs = logService.getAllMemberLogs();  // 수정된 부분
        
        // Print all logs
        if (logs.isEmpty()) {
            System.out.println("기록을 찾지 못했습니다.");
        } else {
            logs.forEach(System.out::println);
        }
    }
}
