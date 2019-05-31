package com.juntaihc.jdk;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class MyAuthenticator extends Authenticator {
    protected  PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("szy-2008","abc@1234".toCharArray());
    }
}
