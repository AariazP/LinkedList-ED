package org.example.application;


import org.example.model.LinkedList;

public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.add(6, 2);
        list.print();
        System.out.println("Size: " + list.getSize());
        list.sort();

        list.print();


    }
}