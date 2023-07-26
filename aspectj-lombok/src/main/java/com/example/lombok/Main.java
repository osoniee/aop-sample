package com.example.lombok;

import com.example.lombok.avenger.Captain;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Captain captainRogers = new Captain("I can do this all day.");
        captainRogers.assemble();
    }
}
