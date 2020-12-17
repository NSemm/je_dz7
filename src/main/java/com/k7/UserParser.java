package com.k7;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
public class UserParser {

    public User parse(String user) {
        Pattern pattern = Pattern.compile("(\\w+)?(?::(\\w+))?(?:@(\\w+))?");
        Matcher matcher = pattern.matcher(user);
        User parsedUser = null;
        if ((!matcher.matches()) || (matcher.group(1) == null && matcher.group(2) == null)) {
            System.out.println(user + " - Invalid user!");
            return null;
        } else {
            if (matcher.group(2) == null) {
                parsedUser = new User(matcher.group(1), matcher.group(1), matcher.group(3));
            }
            if (matcher.group(1) == null) {
                parsedUser = new User(matcher.group(2), matcher.group(2), matcher.group(3));
            }
            if (matcher.group(1) != null && matcher.group(2) != null) {
                parsedUser = new User(matcher.group(1), matcher.group(2), matcher.group(3));
            }
            return parsedUser;
        }
    }

    public List<User> parselist(String string) {
        List<User> userList = new ArrayList<>(0);
        for (String s : string.split(",")
        ) {
            if (parse(s) != null)
                userList.add(parse(s));
        }
        return userList;
    }

    public void viewUsers(String s) {
        for (User u : parselist(s)
        ) {
            System.out.println(u);
        }
    }
}
