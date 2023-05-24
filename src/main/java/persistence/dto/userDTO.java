package persistence.dto;

import lombok.Data;
import lombok.ToString;


import java.time.LocalDate;

@Data
@ToString
public class userDTO {
    private int user_id;
    private String nickname;
    private String loginId;
    private String logPw;
    private String name;
    private int sex;
    private LocalDate birth;
    private String address;
    private String digit;
    private int auth;


}
