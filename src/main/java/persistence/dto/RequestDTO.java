package persistence.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RequestDTO  {

    private int chRequest_id;
    private String name;
    private int id;
    private int user_id;
    private int food_id;
    private int spot_id;
    private String sort;
    private String content;
    private String address;

    public RequestDTO(){}
    public RequestDTO(int userId, int id, String sort, String content){
        user_id = userId;
        this.id = id;
        this.sort = sort;
        this.content = content;
    }
}
