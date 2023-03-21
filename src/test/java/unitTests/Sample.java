package unitTests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Sample {

	String username;
	String password;
	
	//Constructor parameters initialization
	public Sample(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	@Test
	public void login() {
		System.out.println(username+":"+password);
	}
	
	@Parameters
	public static Collection<Object[]> supplyData() {
		Object[][] obj = new Object[4][2];     //4 sets of Username & Password
		obj[0][0] = "arun";
		obj[0][1] = "pass";
		
		obj[1][0] = "varun";
		obj[1][1] = "1234";
		
		obj[2][0] = "tharun";
		obj[2][1] = "seco";
		
		obj[3][0] = "kishore";
		obj[3][1] = "abcd";
		
		return Arrays.asList(obj);
		
		
	}
}
