package persistence.dto;

import lombok.*;

@Getter
@Setter
@ToString

public class requireAddDTO {
    private int addition_id;
    private String name;
    private String state;
    private String sort;
    private String content;
    private String city;
    private String address;


    public requireAddDTO(String name, String state, String sort, String content, String city, String address){
        this.name = name;
        this.state = state;
        this.sort = sort;
        this.content = content;
        this.city = city;
        this.address = address;
    }
}

