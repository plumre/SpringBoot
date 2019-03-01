package com.bayee.chapter18;

/*
 * Created by renhongjiang on 2018/10/17.
 */

import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2018/10/17 9:15
 */
public class Person {
    private String first, last, address;

    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    // Produce an xml element from this person object
    public Element getXML() {
        Element person = new Element("person");
        Element firstName = new Element("first");
        firstName.appendChild(first);
        Element lastName = new Element("last");
        lastName.appendChild(last);
        Element address1 = new Element("address");
        address1.appendChild(address);
        person.appendChild(firstName);
        person.appendChild(lastName);
        person.appendChild(address1);
        return person;
    }

    // Constructor to restore a Person from an xml element
    public Person(Element person) {
        first = person.getFirstChildElement("first").getValue();
        last = person.getFirstChildElement("last").getValue();
        address = person.getFirstChildElement("address").getValue();
    }

    @Override
    public String toString() {
        return first + " " + last + " - " + address;
    }

    public static void format(OutputStream os, Document doc) throws IOException {
        Serializer serializer = new Serializer(os, "ISO-8859-1");
        serializer.setIndent(4);
        serializer.setMaxLength(60);
        serializer.write(doc);
        serializer.flush();
    }

    public static void main(String[] args) throws IOException {
        List<Person> people = Arrays.asList(
                new Person("Dr. Bunsen", "Honeydew", "fjiesfidoshfgasgh"),
                new Person("Gonzo", "The Great", "dsfhsdjkrwifhsf"),
                new Person("Phillip J.", "Fry", "dsfsjkdfhsjkhfeuw"));
        System.out.println(people);
        Element root = new Element("people");
        for (Person person : people) {
            root.appendChild(person.getXML());
        }
        Document doc = new Document(root);
        // System.out.println(doc.toXML());
        format(System.out, doc);
        format(new BufferedOutputStream(new FileOutputStream("D:\\People.xml")), doc);
    }

}