package com.codestates.coffee;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


public class CoffeePostDto {

    @NotBlank(message = "커피 이름은 공백이 아니어야 합니다.")
    @Pattern(regexp = "^[가-힣]+(?:\\s[가-힣]+)*$")
    private String korName;

    //영문(대소문자 모두 가능)만 허용합니다.
    //워드 사이에 한칸의 공백(스페이스)만 포함 될 수 있습니다
    @NotBlank(message = "이름은 공백이 아니어야 하고, 영어 대소문자와 공백 1개만 허용합니다.")
    @Pattern(regexp = "^[a-zA-Z]+(?:\\s[a-zA-Z]+)*$")
    private String engName;

    //100이상 50000이하의 숫자만 허용
    @Max(value = 50000, message = "가격은 최대 50000원입니다.")
    @Min(value = 100, message = "가격은 최소 100원입니다.")
    private int price;

    public String getKorName() { return korName; }

    public String getEngName() { return engName; }

    public int getPrice() { return  price; }
}
