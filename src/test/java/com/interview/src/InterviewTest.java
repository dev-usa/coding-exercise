package com.interview.src;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class InterviewTest {

    public class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean equals(Person p){
            System.out.println("equals called..");
            if(p.getName().equals(this.getName())) {
                return true;
            }

            return false;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person)) return false;
            Person person = (Person) o;
            return Objects.equals(getName(), person.getName());
        }

        @Override
        public int hashCode() {

            return Objects.hash(getName());
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    private ArrayList<String> testArray = new ArrayList<>();
    public LinkedBlockingQueue<Person> testQ = new LinkedBlockingQueue<>(2);
    public Map<Integer, Person> testMap = new HashMap<>();

    @Test
    public void testArrayList() {

        testArray.add("test");
        Assert.assertEquals(testArray.size(), 1);

        Person p1 = new Person("Sarat");
        Person p2 = new Person("Chandra");
        testQ.add(p1);
        testQ.add(p2);

        System.out.println(testQ);

        Person p3 = new Person("Shreya");
        if(!testQ.contains(p3)) {
            if(testQ.offer(p3)) {
                System.out.println("P3 inserted");
            } else if(testQ.poll() !=null) {
                System.out.println("P3 not inserted");
                System.out.println("One element removed - " + testQ);
            }
        }

        System.out.println(testQ);

        Person p4 = new Person("Shreya");

        if(!testQ.contains(p4)) {
            testQ.add(p4);
        }

        System.out.println("p4 exists in queue = " + testQ.contains(p4));

        testQ.stream().forEach(System.out::println);

        while(testQ.size()>0) {
            Person tempP = testQ.poll();
            if(tempP !=null) {
                System.out.println("tempP - " + tempP);
            }
        }

        Person tempP = testQ.poll();
        System.out.println("tempP - " + tempP);

        System.out.println(testQ);

    }

    @Test
    public void testMap() {
        Person p1 = new Person("Sarat");
        Person p2 = new Person("Chandra");
        Person p3 = new Person("Shreya");
        testMap.put(1, p1);
        testMap.put(2, p2);
        testMap.put(3, p3);

        Set<Integer> integers = testMap.keySet();
        for(Integer i : integers) {
            System.out.println("val = " + testMap.get(i));
        }

        Iterator<Map.Entry<Integer, Person>> it = testMap.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<Integer, Person> mapEntry = it.next();
            Person p = mapEntry.getValue();
            System.out.println("val = " + p);
        }

        Collection<Person> values = testMap.values();

        for(Person person: values){
            System.out.println("val = " + person);
        }

        System.out.println("4 - " + testMap.get(4));

        System.out.println("map = " + testMap);
    }
}
