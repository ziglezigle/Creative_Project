package persistence.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Calendar;
import java.util.Date;


@Getter
@Setter
@ToString

public class reviewDTO {
    private int id, user_id;

    private String nickname;
    private double rate;
    private String content;
    private Date date;

    public reviewDTO(){}
    public reviewDTO(int user_id, int id, double rate, String content){
        this.user_id = user_id;
        this.id = id;
        this.rate = rate;
        this.content = content;
        date = new Date();
    }
}


//
//    public reviewDTO(int id, double rate, String content){
//        this.id = id;
//        this.rate = rate;
//        this.content = content;
//        date = new Date();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.add(Calendar.DAY_OF_MONTH, +1); // 현재 날짜로부터 1일을 뺌
//
//        // 1일 전 날짜를 가져오기
//        Date previousDate = calendar.getTime();
//        date = previousDate;
//    }
