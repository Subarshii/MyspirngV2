package com.example.demo.Aplication;

import GogoSpring.Myfactory;
import com.example.Interface.Interface1;
import com.example.Interface.Interface2;

public class App {

  public static void main(String[] args) {

    Object startTime1 = Myfactory.createService(new MyService());
    ((Interface1) startTime1).hello1();
  //  ((Interface2) startTime1).hello2();
  }
}
