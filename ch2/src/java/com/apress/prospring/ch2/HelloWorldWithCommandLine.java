/*
 * Created on Jul 23, 2004
 */
package com.apress.prospring.ch2;

/**
 * @author robh
 */
public class HelloWorldWithCommandLine {

    public static void main(String[] args) {
        if(args.length > 0) {
            System.out.println(args[0]);
        } else {
            System.out.println("Hello World!");
        }
    }
}
