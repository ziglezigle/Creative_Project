package persistence.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class AdditionDTO {
    private int user_id, id;
    private String sort, name, state, city, content, address;

    public AdditionDTO(){}

    //맛집 관광지 추가요청 기능
    public AdditionDTO(String name, String sort, String state, String city, String content){
        if(name.equals(""))
            this.name = null;
        else
            this.name = name;
        if(sort.equals(""))
        this.sort = null;
        else
            this.sort = sort;
        if(state.equals(""))
            this.state = null;
        else
        this.state = state;
        if(city.equals(""))
            this.city=null;
        else
        this.city = city;
        if(content.equals(""))
            this.content=null;
                    else
        this.content = content;
    }

    //맛집 관광지 수정 및 삭제 요청 기능
    public AdditionDTO(int user_id, int id, String sort,  String content){
        this.user_id = user_id;
        this.id = id;
        this.sort = sort;
        this.content = content;
    }
}



