package com.sh.designpattern.creational.builder;

public class ConcreteBuilder1 implements Builder{

	Person person;
    public ConcreteBuilder1() {
        person = new Person();
    }
    @Override
    public void buildHead(){
        System.out.println("构建头");
    }
    @Override
    public void buildBody(){
        System.out.println("构建躯体");
    }
    @Override
    public void buildFoot(){
        System.out.println("构建脚");
    }
    @Override
    public Person buildPerson() {
        return person;
    }
    public Person buildPerson2() {
        buildHead();
        buildBody();
        buildFoot();

        return buildPerson();
    }
}
