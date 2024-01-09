package testNG;

import org.testng.annotations.Test;

public class TestNGPractice {
@Test
public void createContact()
{
	System.out.println("create");
}
@Test
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
// flags - priority, invocationCount,enable,dependOnMethos