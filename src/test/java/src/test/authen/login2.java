package src.test.authen;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class login2 {
    @Test
    public void test2() {
        System.out.println("this is a login 2");
    }

    @Parameters({"UUID"})
    @Test()
    public void testPara(String UUID) {
        System.out.println("This is a para " + UUID);
    }
}
