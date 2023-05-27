package persistence.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class foodDTO {
    private int id;
    private String name;
    private String address;
    private String category;
    private double score;
    private String review;
    private String state;
    private String city;

    public foodDTO(){}
    public foodDTO(String name, String state, String city){
        this.name = name;
        this.state = state;
        this.city = city;
    }
}
