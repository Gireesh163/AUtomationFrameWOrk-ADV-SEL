package testNG;

import org.testng.annotations.Test;

public class GenericMethodPracticeTest {

	@Test
	public void genericMethodPractice()
	{
	add();
		add(5,6);
		int sum = add(3,4,5);
		System.out.println(sum);

	}
	public static void add()//called
	{
		int a=10;
		int b=20;
		int c=a+b;
		System.out.println(c);
	}
	public static void add(int a, int b)
	{
		int sum=a+b;
		System.out.println(sum);
	}
	//Generic Method / Reusable Method
	public static int add(int a, int b, int c)
	{
		int s=a+b+c;
		return s ;
	}
}
