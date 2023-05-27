package persistence.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.time.LocalDate;

@Getter
@Setter
@ToString
public class userDTO {
    private int user_id;
    private String nickname;
    private String logId;
    private String logPw;
    private String name;
    private int sex;
    private LocalDate birth;
    private String digit;
    private int auth;



}
