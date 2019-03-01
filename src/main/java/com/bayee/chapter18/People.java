package com.bayee.chapter18;

/*
 * Created by renhongjiang on 2018/10/17.
 */

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Elements;
import nu.xom.ParsingException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/17 11:05
 */
public class People extends ArrayList<Person> {
    public People(File filename) throws ParsingException, IOException {
        Document doc = new Builder().build(filename);
        Elements elements = doc.getRootElement().getChildElements();
        for (int i = 0; i < elements.size(); i++) {
            add(new Person(elements.get(i)));
        }
    }

    public static void main(String[] args) throws Exception {
        File file = new File("D:\\People.xml");
        People people = new People(file);
        System.out.println(people);
    }
}