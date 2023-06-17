package persistence.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class requestDTO {

    private int chRequest_id;
    private int user_id;
    private int food_id;
    private int spot_id;
    private String sort;
    private String content;
    private String address;
}
