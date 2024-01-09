package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPrcticeDependency {
	@Test
	public void createContact()
	{
		Assert.fail();
		System.out.println("create");
	}
	@Test(dependsOnMethods = "createContact")
	public void modifyContact()
	{
		System.out.println("modify");
	}
	@Test
	public void deleteContact()
	{
		System.out.println("delete");
	}
	// execute in ASCII value order - lower ascii execute first
	}

