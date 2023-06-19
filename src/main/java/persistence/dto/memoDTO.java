package persistence.dto;

import lombok.*;

@Getter
@Setter
@ToString

public class memoDTO {
    private int id;
    private String date;
    private String information;

    public memoDTO(String date, String information){
        this.date = date;
        this.information = information;
    }
}

