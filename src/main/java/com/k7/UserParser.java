package com.k7;

import lombok.AllArgsConstructor;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
public class UserParser {

    User parse(String user) {
        Pattern pattern = Pattern.compile("(\\w+)?(?::(\\w+))?(?:@(\\w+))?");
        Matcher matcher = pattern.matcher(user);
        User parsedUser = null;
        if (!matcher.matches()) {
            System.out.println("Invalid user!");
            return null;
        }
        else {
            if (matcher.group(2)==null) {
                parsedUser = new User(matcher.group(1), matcher.group(1),matcher.group(3));
            }
            if (matcher.group(1) == null) {
                parsedUser = new User(matcher.group(2), matcher.group(2), matcher.group(3));
            }
            if (matcher.group(1) !=null&&matcher.group(2)!=null) {
                parsedUser = new User(matcher.group(1), matcher.group(2), matcher.group(3));
            }
            return parsedUser;
        }
    }
}
