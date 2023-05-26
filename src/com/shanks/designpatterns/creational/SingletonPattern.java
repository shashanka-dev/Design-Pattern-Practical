package com.shanks.designpatterns.creational;

public class SingletonPattern {
}

class DemoClass {
    private static volatile DemoClass demoClass;

    private DemoClass () { }

    public static DemoClass getInstance() {
        return new DemoClass();
    }
}
