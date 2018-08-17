package com.candid.spring.processor;

import org.springframework.batch.item.ItemProcessor;

import com.candid.spring.model.Person;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {
    @Override
    public Person process(final Person person) throws Exception {

    	// format conversion 
    	Person p=new Person();
    	p.setName(person.getDept());
    	p.setName(person.getName());
    	p.setRollno(person.getRollno());
    	
        return p;
    }
}