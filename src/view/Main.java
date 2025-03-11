/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;


import controller.Hotel_Management;
import static java.awt.SystemColor.menu;
import module.HotelInformation;
import java.util.Scanner;



/**
 *
 * @author nguyennhu
 */
public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
       Hotel_Management h=new Hotel_Management();
       final String FILE = "Hotel.dat";
       h.readFile(FILE);
        int choose;
    do{
    Menu mainMenu=new Menu();
    mainMenu.aMenu();
     choose = sc.nextInt();
    switch(choose){
        case 1: 
            System.out.println("* Add new hotel *");
            h.addHotel();
            h.saveFile(FILE);
            break;
         
        case 2:
            System.out.println("* Check an existed hotel *");
            h.checkExistHote();
            h.saveFile(FILE);
            break;
            
        case 3:
            System.out.println("* Update hotel information *");
            h.updateHotel();
            h.saveFile(FILE);
            break;
            
            
        case 4:
            System.out.println("* Delete hotel *");
            h.deleteHotel();
            h.saveFile(FILE);
            break;
            
            
        case 5:
           Menu a=new Menu();
            a.subMenu();
            choose =sc.nextInt();
             if (choose == 1) {
                        h.searchHotelByID();
                        break;
                    } else if (choose==2) {
                        h.searchHotelByName();
                        break;
                   }
                 else
                    break;
          
        case 6:
            System.out.println("* Display hotel *");
            h.displayHotel();
            h.saveFile(FILE);
            break;
            
        case 7:
            System.out.println("* Quit the program *");
            break;
            
        default:
            System.out.println("Invalid choice. Please enter valid option.");
            
            
    }
} while(choose != 7);
    
}
}
