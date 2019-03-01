package com.bayee.util.serial;

/*
 * Created by renhongjiang on 2019/2/28.
 */

import java.io.*;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2019/2/28 17:59
 */
public class SerializeAlien {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("E:\\qq.txt"));
        Alien alien = new Alien();
        alien.setAge(26);
        alien.setName("Kevin");
        System.out.println(" 开始序列化");
        out.writeObject(alien);
        System.out.println(" 结束序列化");

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("E:\\qq.txt"));
        System.out.println(" 开始反序列化");
        Alien alien1 = (Alien) in.readObject();
        System.out.println(" 结束反序列化");
        System.out.println(alien == alien1);
        System.out.println(alien1);
    }

}