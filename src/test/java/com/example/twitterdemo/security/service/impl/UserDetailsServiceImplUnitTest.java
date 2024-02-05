package com.example.twitterdemo.security.service.impl;

import com.example.twitterdemo.security.entity.UserAccount;
import com.example.twitterdemo.security.entity.UserRole;
import com.example.twitterdemo.security.service.UserAccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class UserDetailsServiceImplUnitTest {
    @Mock
    private UserAccountService userAccountService;
    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Test
    void shouldReturnNotEmptyUserDetails(){
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername("horuzart001@gmail.com");
        userAccount.setPassword("Lapka228");
        userAccount.setAuthorities(Collections.singleton(new UserRole()));

        User expectedResult = new User(userAccount.getUsername(), userAccount.getPassword(), userAccount.getAuthorities());
        Mockito.when(userAccountService.findUserByUsername(userAccount.getUsername())).thenReturn(Optional.of(userAccount));
        UserDetails actualResult = userDetailsService.loadUserByUsername(userAccount.getUsername());

        assertEquals(expectedResult, actualResult);
        Mockito.verify(userAccountService, Mockito.times(1)).findUserByUsername(any());
    }
    @Test
    void shouldThrowUserNotFoundException(){
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername("horuzart001@gmail.com");
        userAccount.setPassword("Lapka228");
        userAccount.setAuthorities(Collections.singleton(new UserRole()));

        Mockito.when(userAccountService.findUserByUsername(userAccount.getUsername()))
                .thenReturn(Optional.empty());

        assertThrows(
                UsernameNotFoundException.class,
                () -> userDetailsService.loadUserByUsername(userAccount.getUsername())
        );
        Mockito.verify(userAccountService, Mockito.times(1)).findUserByUsername(any());
    }
}