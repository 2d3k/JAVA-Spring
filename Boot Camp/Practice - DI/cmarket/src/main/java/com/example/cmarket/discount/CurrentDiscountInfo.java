//enum 타입을 비교할때는 == 을 사용합니다.
//1, 2 등급일 때는 고정 할인 값 grade_number_Amount를 리턴해주고 그 외에는 0을 return 해줍니다.

package com.example.cmarket.discount;

import com.example.cmarket.user.User;
import com.example.cmarket.user.UserGrade;

public class CurrentDiscountInfo implements DiscountInfo{
    private int grade_1_Amount = 500;
    private int grade_2_Amount = 1000;

    @Override

    public int discount(User user, int price) {
        if (user.getUserGrade() == UserGrade.GRADE_2) {
            return grade_2_Amount;
        }
        return 0;
    }
}