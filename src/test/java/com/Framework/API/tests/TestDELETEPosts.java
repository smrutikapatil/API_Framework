package com.Framework.API.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Framework.API.helpers.PersonServiceHelpers;

public class TestDELETEPosts {
	
	private PersonServiceHelpers personServiceHelpers;

	@BeforeClass
	public void init() {
		personServiceHelpers = new PersonServiceHelpers();
	}

	
	  @Test public void testDeletePosts() {
	  
	  personServiceHelpers.deletePost(15);
	  
	  }
}
