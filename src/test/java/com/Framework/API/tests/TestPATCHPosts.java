package com.Framework.API.tests;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Framework.API.helpers.PersonServiceHelpers;

public class TestPATCHPosts {

	private PersonServiceHelpers personServiceHelpers;

	@BeforeClass
	public void init() {
		personServiceHelpers = new PersonServiceHelpers();
	}

	@Test
	public void testPATCHPosts() {

		String id = personServiceHelpers.updatePosts(15).jsonPath().getString("id");
		System.out.println(id);
		assertNotNull(id, "Updated");
	}
}
