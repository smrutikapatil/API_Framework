package com.Framework.API.tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.Framework.API.helpers.PersonServiceHelpers;
import com.Framework.API.models.Person;

public class TestGETPosts {
	
	private PersonServiceHelpers personServiceHelpers;
	
	@BeforeClass
	public void init() {
		personServiceHelpers = new PersonServiceHelpers();
	}

	@Test
	public void testGetAllPosts() {
		
		List<Person> personList = personServiceHelpers.getAllPosts();
		assertNotNull(personList, "Person List is not Empty");
		assertFalse(personList.isEmpty(),"Person List is not True");
	}
}
