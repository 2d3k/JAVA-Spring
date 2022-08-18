package com.example.cmarket;

import com.example.cmarket.singleton.SingletonService;
import com.example.cmarket.user.UserService;

public class SingletonApp {
    //static AppConfig appConfig = new AppConfig();

    static SingletonService SingletonService1 = SingletonService.getInstance();
    static SingletonService SingletonService2 = SingletonService.getInstance();


    public static void main(String[] args) {
        System.out.println("SingletonService1 : " + SingletonService1);
        System.out.println("SingletonService2 : " + SingletonService2);
    }
}
