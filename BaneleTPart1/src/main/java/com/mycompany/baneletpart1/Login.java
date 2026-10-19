/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baneletpart1;

/**
 *
 * @author nosip
 */
public class Login {

public static String registerUser( String firstName,String lastName, String phoneNumber,String userName,String password ) {
        if (checkFirstName(firstName)&& checkLastName(lastName)&& checkUserName(userName)
                && checkCellPhoneNumber(phoneNumber)&& checkPasswordComplexity(password)) {
            return "First name successfully captured"+"\nLast name successfully captured"+
                    "\nUsername successfully captured"+"\nCell phone number successfully added"+"\nPassword successfully captured";
        }
        return "Registration was unsuccessful.";
}
public static boolean checkFirstName(String firstName) {
    return firstName != null && !firstName.trim().isEmpty();
}
public static boolean checkLastName(String lastName) {
    return lastName != null && !lastName.trim().isEmpty();
}
public static boolean checkUserName(String userName) {
    return userName != null && userName.contains("_")&& userName.length() <= 5;
}

public static boolean checkPasswordComplexity(String password) {
    if (password == null || password.length() < 8) {
    return false;
    }
    boolean hasCapitalLetter = false;
    boolean hasSpecialCharacter = false;
    boolean hasNumber = false;
    int index = 0;

    // While loop checks every character in the password
    while (index < password.length()) {
    char current = password.charAt(index);

    if (Character.isUpperCase(current)) {
    hasCapitalLetter = true;
    } else if (Character.isDigit(current)) {
    hasNumber = true;
    } else if (!Character.isLetterOrDigit(current)) {
    hasSpecialCharacter = true;
    }
    index++;
    }
    return hasCapitalLetter && hasNumber && hasSpecialCharacter;
}

public static boolean checkCellPhoneNumber(String phoneNumber) {
    return phoneNumber != null && phoneNumber.matches("\\+27[0-9]{9}");
}
public static boolean loginUser(String userName, String password, String registeredUsername, String registeredPassword) {
    return userName != null && password != null&& userName.equals(registeredUsername)&& password.equals(registeredPassword);
    }

    public static String loginStatus( String firstName,String lastName,String userName,
        String password,String registeredUsername, String registeredPassword) {
        if (loginUser(userName,password,registeredUsername, registeredPassword)) {
            return "Welcome " + firstName + "," + lastName+", it is great to see you again.";
        }
        return "Username or password incorrect.";
    }
}
