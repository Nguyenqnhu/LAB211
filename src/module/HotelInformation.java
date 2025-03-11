/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package module;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author nguyennhu
 */
public class HotelInformation implements Serializable{
    private String hotel_Id;
    private String hotel_Name;
    private int hotel_Room_Available;
    private String hotel_Address;
    private  int hotel_Phone;
    private int hotel_Rating;

    public HotelInformation() {
    }

    public HotelInformation(String hotel_Id, String hotel_Name, int hotel_Room_Available, String hotel_Address, int hotel_Phone, int hotel_Rating) {
        this.hotel_Id = hotel_Id;
        this.hotel_Name = hotel_Name;
        this.hotel_Room_Available = hotel_Room_Available;
        this.hotel_Address = hotel_Address;
        this.hotel_Phone = hotel_Phone;
        this.hotel_Rating = hotel_Rating;
    }

   

    public String getHotel_Id() {
        return hotel_Id;
    }

    public String getHotel_Name() {
        return hotel_Name;
    }

    public int getHotel_Room_Available() {
        return hotel_Room_Available;
    }

    public String getHotel_Address() {
        return hotel_Address;
    }

    public int getHotel_Phone() {
        return hotel_Phone;
    }

    public int getHotel_Rating() {
        return hotel_Rating;
    }

    public void setHotel_Id(String hotel_Id) {
        this.hotel_Id = hotel_Id;
    }

    public void setHotel_Name(String hotel_Name) {
        this.hotel_Name = hotel_Name;
    }

    public void setHotel_Room_Available(int hotel_Room_Available) {
        this.hotel_Room_Available = hotel_Room_Available;
    }

    public void setHotel_Address(String hotel_Address) {
        this.hotel_Address = hotel_Address;
    }

    public void setHotel_Phone(int hotel_Phone) {
        this.hotel_Phone = hotel_Phone;
    }

    public void setHotel_Rating(int hotel_Rating) {
        this.hotel_Rating = hotel_Rating;
    }
   
    public void displayInfo() {
        
        System.out.println("Hotel ID: " + hotel_Id);
        System.out.println("Hotel Name: " + hotel_Name);
        System.out.println("Available Rooms: " + hotel_Room_Available);
        System.out.println("Address: " + hotel_Address);
        System.out.println("Phone: " + hotel_Phone);
        System.out.println("Rating: " + hotel_Rating);
    }
    @Override
    public String toString() {
        return String.format("*%-4s|%-17s|%-10d|%-56s|%-11s|%-7dstar|*\n", hotel_Id, hotel_Name, hotel_Room_Available, hotel_Address, hotel_Phone, hotel_Rating);
    }

    

              
    
}
