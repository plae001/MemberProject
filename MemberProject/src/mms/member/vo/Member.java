package mms.member.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {

    private int id;
    private String name;
    private String addr;
    private String email;
    private String nation;
    private int age;
	
	
}