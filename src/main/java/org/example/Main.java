package org.example;

import util.CommunicateWithUser;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        CommunicateWithUser communicateWithUser = new CommunicateWithUser();
        communicateWithUser.interaction();
    }
}
