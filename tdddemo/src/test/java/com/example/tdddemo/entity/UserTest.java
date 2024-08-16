package com.example.tdddemo.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("유저 테스트")
public class UserTest {

    @Test
    @DisplayName("유저 생성 테스트")
    public void testUserCreation() {
        // given
        User user = new User("max@gmail.com","1234","kim songjo");


        // then
        assertThat(user.getEmail()).isEqualTo("max@gmail.com");
        assertThat(user.getPassword()).isEqualTo("1234");
        assertThat(user.getName()).isEqualTo("kim songjo");
        assertThat(user.getId()).isNull();
    }

    @DisplayName("sample test")
    @Test
    void testMethodName() {
        // given


        // when


        // then

        //assertTat(actual).isEqualTo(expected);

    }
}
