package com.k7;

public class Main {
    public static void main(String[] args) {
        UserParser userParser = new UserParser();
        String inputString = "programmer:vasia@123,vaa:@t64654,programmer:vasia," +
                "vasia@asdasd,@t61214654,vasia,vasia:@trulala,programmer:vova@654235asd";
        userParser.viewUsers(userParser.parselist(inputString));
    }
}
