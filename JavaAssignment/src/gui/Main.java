/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import model.Validation;

/**
 *
 * @author PCDELL
 */
public class Main {
   
    public static void main(String[] args) throws Exception{
         View v = new View();
         int choose;
         while (true) {
            v.menu();
            choose = Validation.getInt("Enter choose: ", 1, 4);
            switch (choose) {
                case 1:
                    v.addTask();
                    break;
                case 2:
                    v.deleTask();
                    break;
                case 3:
                    v.displayTask();
                    break;
                case 4:
                    return;
            }
        }
    }
}
