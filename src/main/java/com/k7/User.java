package com.k7;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    private String nickname;
    private String username;
    private String password;

}
