package testNG;

import org.testng.annotations.Test;

public class TestNGPracticeInvocation {
	@Test(invocationCount = 3)
	public void createContact()
	{
		System.out.println("create");
	}
	@Test(invocationCount = 0)
	public void modifyContact()
	{
		System.out.println("modify");
	}
	@Test(invocationCount = -1)
	public void deleteContact()
	{
		System.out.println("delete");
	}
	@Test(enabled = true)
	public void addContact()
	{
		System.out.println("add");
	}
	@Test(enabled = false)
	public void updateContact()
	{
		System.out.println("update");
	}
	
	// execute in ASCII value order - lower ascii execute first, inovaction count 0/-ve will ignore
	}
