package persistence.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserInfo {
    private static int user_id;

    public static void setUser_id(int id){
        user_id = id;
    }
    public static int getUser_id(){
        return user_id;
    }


}
