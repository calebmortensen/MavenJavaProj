package unitTests;
import org.junit.Assume;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Login {

	@Test
	public void test_a_loginWithValidCredentials() {

		System.out.println("loginWithValidCredentials method");
	}
	@Test
	public void test_b_loginWithValidUsernameAndInvalidPassword() {
		Assume.assumeTrue(false); //This disables test
		System.out.println("loginWithValidUsernameAndInvalidPassword method");
	}
	@Test
	public void test_c_loginWithInvalidUsernameAndInvalidPassword() {

		System.out.println("loginWithInvalidUsernameAndInvalidPassword method");
	}

}
