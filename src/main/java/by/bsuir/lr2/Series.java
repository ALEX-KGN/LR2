package by.bsuir.lr2;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Series {
    private String name;

    private int numbers;

    private double rating;


}
