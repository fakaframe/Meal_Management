/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Meal_management;

import javax.swing.JFrame;

/**
 *
 * 
 */
public class Main {
    public static void main(String[] args) {
               
                Login_form frame =new Login_form();
                frame.setVisible(true);
                frame.setBounds(300, 100, 500, 420);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setTitle("Login form");
    }
}
