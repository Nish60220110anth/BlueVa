package com.indua.utils;

public class BJNodeSet {
    private BJNodeSet() {

    }

    public static BJNodeSet createInstance() {
        return new BJNodeSet();
    }

    public String build() {
        return String.format("System.out.println(\"Hi\")");
    }

}
