package com.example.app;

public class exception extends Exception {

    @Override
    public String toString() {
        return "There is same appointment at same time!!!!";
    }
}
