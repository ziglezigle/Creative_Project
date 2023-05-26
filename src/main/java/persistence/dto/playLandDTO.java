package persistence.dto;


import lombok.*;


@Getter
@Setter
@ToString
public class playLandDTO {
    private int id;
    private String name;
    private String sort;
    private String address;
    private String state;
    private String city;
    private double score;
    private String review;

    public playLandDTO(){}
    public playLandDTO(String name, String state, String city){
        this.name = name;
        this.state = state;
        this.city = city;
    }
}
