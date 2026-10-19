/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.baneletpart1;

import java.util.Scanner;

/**
 *
 * @author nosip
 */
public class BaneleTPart1 {  
        
public static void main(String[] args) {
     Scanner myInput = new Scanner(System.in);
        String firstName;
        String lastName;
        String phoneNumber;
        String registerUserName;
        String registerPassword;
        String userName;
        String password;
        
        System.out.println("REGISTRATION");
        // Keep asking until a valid first name is entered
        System.out.print("Enter your first name: ");
        firstName = myInput.nextLine().trim();
        while (!checkFirstName(firstName)) {
            System.out.println("First name is incorrect.");
            System.out.print("Enter your first name again: ");
            firstName = myInput.nextLine().trim();
        }
        
        // Keep asking until a valid last name is entered
        System.out.print("Enter your last name: ");
        lastName = myInput.nextLine().trim();
        while (!checkLastName(lastName)) {
            System.out.println("Last name is incorrect.");
            System.out.print("Enter your last name again: ");
            lastName = myInput.nextLine().trim();
        }
        
        // Keep asking until a valid phone number is entered
        System.out.print("Enter your phone number: ");
        phoneNumber = myInput.nextLine().trim();
        while (!checkCellPhoneNumber(phoneNumber)) {
            System.out.println("Cell phone number incorrectly formatted or "+"does not contain the international code.");
            System.out.print("Enter your phone number again: ");
            phoneNumber = myInput.nextLine().trim();
        }
        
        // Keep asking until a valid username is entered
        System.out.print("Enter your username: ");
        registerUserName = myInput.nextLine().trim();
        while (!checkUserName(registerUserName)) {
            System.out.println(
            "Username is not correctly formatted. Ensure that it "+"contains an underscore and is no more than 5 characters.");
            System.out.print("Enter your username again: ");
            registerUserName = myInput.nextLine().trim();
        }
        
        // Keep asking until a valid password is entered
        System.out.print("Enter your password: ");
        registerPassword = myInput.nextLine();
        while (!checkPasswordComplexity(registerPassword)) {
            System.out.println("Password is not correctly formatted. Ensure that it contains "+
                "at least 8 characters, a capital letter, a number, "+"and a special character." );
            System.out.print("Enter your password again: ");
            registerPassword = myInput.nextLine();
        }
        System.out.println();
        System.out.println(registerUser(firstName,lastName,phoneNumber,registerUserName,registerPassword));
        System.out.println(" LOGIN");
        boolean loggedIn = false;
        
        
        // Repeat the login process until the details are correct
        while (!loggedIn) {
            System.out.print("Enter your username: ");
            userName = myInput.nextLine().trim();
            System.out.print("Enter your password: ");
            password = myInput.nextLine();
            loggedIn = loginUser(userName, password,registerUserName, registerPassword);
            System.out.println(
            loginStatus(firstName,lastName,userName,password,registerUserName,registerPassword));
            if (!loggedIn) {
                System.out.println("Please try again. ");
            }
        }
        myInput.close();
        
}

