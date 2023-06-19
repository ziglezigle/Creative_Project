package persistence.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class locationDTO {
    private  int id;
    private String Do, Si, road, nx, ny, code;

    public locationDTO(){}
    public locationDTO(String Do, String Si){
        this.Do = Do;
        this.Si = Si;
    }
}
