package persistence.dto;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
public class reviewDTO {
    private String content;
    private double rate;
    private LocalDate review_date;
}
