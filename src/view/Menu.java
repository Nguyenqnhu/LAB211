/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author LENOVO
 */
public class Menu {
    //tao menu tong
    public void aMenu(){
     System.out.println("|------------------------------- MENU ----------------------------------------------------|");
     System.out.println("|                         [1].Add new hotel                                               |");
     System.out.println("|                         [2].Check exist hotel                                           |");
     System.out.println("|                         [3].Update hotel information                                    |");
     System.out.println("|                         [4].Delete hotel                                                |");
     System.out.println("|                         [5].Search  hotel                                               |");
     System.out.println("|                         [6].Displaying a hotel list                                     |");
     System.out.println("|                         [7].Quit the program                                            |");
     System.out.println("|-----------------------------------------------------------------------------------------|");
     System.out.print("Enter your choice:");
    }
    
    //tao menu cho Search hotel
    public void subMenu(){
     System.out.println("*----------------------------------SEARCH HOTEL ------------------------------------------*");
     System.out.println("*                                 [1].SEARCH BY ID                                        *");
     System.out.println("*                                 [2].SEARCH BY NAME                                      *");
     System.out.println("*-----------------------------------------------------------------------------------------*");
       System.out.print("* Please choose (from 1 - 2):");
    }
    
}
