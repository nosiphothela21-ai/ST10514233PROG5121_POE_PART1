/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.baneletpart1.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author nosip
 */
public class TestRegistrationAndLogin {
    
    public TestRegistrationAndLogin() {
    }
    @Test
    public void TestUsernameSuccess()
    {
        String testData = "Kyl_1";
        boolean expected = true;
        boolean Actual = Login.checkUserName(testData);
        assertEquals(expected,Actual);
    }
    
    @Test
    public void TestUsernameFailure()
    {
        String testData = "Kyle!!!!!!!!";
        boolean expected = false;
        boolean Actual = Login.checkUserName(testData);
        assertEquals(expected,Actual);
    }
    
    @Test
    public void TestPasswordSuccess()
    {
        String testData = "Ch&&sec@ke99";
        boolean expected = true;
        boolean Actual = Login.checkPasswordComplexity(testData);
        assertEquals(expected,Actual);
    }
    
    @Test
    public void TestPasswordFailure()
    {
        String testData = "password";
        boolean expected = false;
        boolean Actual = Login.checkPasswordComplexity(testData);
        assertEquals(expected,Actual);
    }
    
    @Test
    public void TestCellPhoneSuccess()
    {
        String testData = "+27838968976";
        boolean expected = true;
        boolean Actual = Login.checkCellPhoneNumber(testData);
        assertEquals(expected,Actual);
    }
    
    @Test
    public void TestCellPhoneFailure()
    {
        String testData = "08966553";
        boolean expected = false;
        boolean Actual = Login.checkPasswordComplexity(testData);
        assertEquals(expected,Actual);
    }
    
    @Test
    public void TestLoginSucess()
    {
        String loginUserName = "No_si";
        String loginPassword = "Nosi@678";
        String registeredUserName = "No_si";
        String  registeredPassword = "Nosi@678";
        String firstName = "Nosipho";
        String lastName = "Thela";
        String expected = "Welcome " + firstName + "," + lastName+", it is great to see you again.";
        String Actual = Login.loginStatus(firstName, lastName, loginUserName, loginPassword, registeredUserName, registeredPassword);
        
        assertTrue(Actual.equals(expected));
    }
    
    @Test
    public void TestLoginFailure()
    {
         String loginUserName = "No_si";
        String loginPassword = "Nosi@678";
        String registeredUserName = "No_si";
        String  registeredPassword = "Nosi@678";
        String firstName = "Nosipho";
        String lastName = "Thela";
        String expected = "Username or password incorrect.";
        String Actual = Login.loginStatus(firstName, lastName, loginUserName, loginPassword, registeredUserName, registeredPassword);
        
        assertFalse(Actual.equals(expected));
    }
    
  
}

    
    
      

