package org.example;

import util.UserCommunicationUtil;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        UserCommunicationUtil communicateWithUser = new UserCommunicationUtil();
        communicateWithUser.interaction();
    }
}
