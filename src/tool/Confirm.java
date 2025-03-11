/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tool;
import java.util.Scanner;

/**
 *
 * @author nguyennhu
 */

/**
 *
 * extra function to confirm yes no
 */
public class Confirm {
    public static boolean Confirm(String msg){
        boolean check  = true;
        Scanner sc = new Scanner (System.in);
        String ans;
        do{
            System.out.println(msg);
            ans= sc.nextLine().toUpperCase();
            if(ans.isEmpty()){
                System.out.println("Enter again please!");
            }
            if (ans.equals("Y")|| ans.equals("N")) {
                check = false;
            }
                
                   
        }while(check);
        return ans.equalsIgnoreCase("Y");
      
            
        
    }
}
