package com.codestates.coffee;

import org.hibernate.validator.constraints.Range;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.Optional;

public class CoffeePatchDto {
    private long coffeeId;

    @Nullable
    @Pattern(regexp = "^[가-힣]+(?:\\s[가-힣]+)*$")
    private String korName;
    @Nullable
    @Pattern(regexp = "^[a-zA-Z]+(?:\\s[a-zA-Z]+)*$")
    private String engName;

    private Optional<@Range(min = 100, max = 50000) Integer> price = Optional.empty();

    public String getKorName() { return korName; }

    public String getEngName() { return engName; }

    public Optional<Integer> getPrice() { return price; }

    public long coffeeId() { return coffeeId; }

    public void setCoffeeId(long coffeeId) { this.coffeeId = coffeeId; }
}
