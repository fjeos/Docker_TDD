package com.example.tdddemo;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    // 필요한 의존성
    private UserRepository mockUserRepository;

    @InjectMocks
    // 내가 지금 테스트할 레이어
    private UserService userService;

    @Test
    void getUserById_존재하는_사용자_조회_성공() {
        // Given
        // 껍데기 Repository 객체를 만듦
        UserRepository mockUserRepository = mock(UserRepository.class);
        UserService userService = new UserService(mockUserRepository);

        User expectedUser = new User(1L, "testuser");
        // mock Repository에서 findById가 호출되면 만들어뒀던 expectedUser가 반환됨
        when(mockUserRepository.findById(1L)).thenReturn(Optional.of(expectedUser));

        // When
        User actualUser = userService.getUserById(1L);

        // Then
        assertEquals(expectedUser, actualUser);
        verify(mockUserRepository).findById(1L);
    }

    @Test
    void getUserById_존재하지_않는_사용자_조회_실패() {
        // Given
        UserRepository mockUserRepository = mock(UserRepository.class);
        UserService userService = new UserService(mockUserRepository);

        when(mockUserRepository.findById(anyLong())).thenReturn(Optional.empty());

        // When & Then
        assertThrows(UserNotFoundException.class, () -> userService.getUserById(1L));
        verify(mockUserRepository).findById(1L);
    }
}
