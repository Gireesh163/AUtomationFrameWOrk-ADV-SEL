package testNG;

import org.testng.annotations.Test;

public class TestNGPracticePriority {
	@Test(priority = 1)
	public void createContact()
	{
		System.out.println("create");
	}
	@Test(priority = 2)
	public void modifyContact()
	{
		System.out.println("modify");
	}
	@Test(priority = 3)
	public void deleteContact()
	{
		System.out.println("delete");
	}
	@Test(priority = 0)
	public void deleteContact1()
	{
		System.out.println("delete1");
	}
	@Test(priority = -1)
	public void deleteContact2()
	{
		System.out.println("delete2");
	}
	@Test(priority = -2)
	public void deleteContact3()
	{
		System.out.println("delete3");
	}
	// execute in ASCII value order - lower ascii execute first
	}

