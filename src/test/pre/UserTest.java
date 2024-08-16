package com.example.tdddemo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UserTest {

    @Test
    void 사용자_이름은_2자_이상이어야_합니다() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("A"));
        Assertions.assertDoesNotThrow(() -> new User("Bob"));
    }

    @Test
    void 상품_할인_금액_계산() {
        Product product = new Product("노트북", 100000);
        Discount discount = new Discount(10);

        int discountedPrice = discount.apply(product);

        assertThat(discountedPrice).isEqualTo(90000);
    }

    @Test
    void 두_숫자의_합을_반환한다() {
        Calculator calc = new Calculator();
        int result = calc.add(3, 4);
        assertThat(result).isEqualTo(7);
    }
    @Test
    void 두_숫자의_곱을_반환한다() {
        Calculator calc = new Calculator();
        int result = calc.multiply(3, 4);
        assertThat(result).isEqualTo(12);
    }

}
