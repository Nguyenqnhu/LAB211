/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import module.HotelInformation;
import view.Menu;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import tool.Confirm;

/**
 *
 * @author nguyennhu
 */
public class Hotel_Management implements HotelManagment {

    ArrayList<HotelInformation> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public boolean isEmpty() {
        return this.list.size() == 0;
    }

    /**
     *
     * for inputter input id
     */
    public String inputId(String mes) {
        String id = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(mes);
            id = sc.nextLine().toUpperCase().trim();
            if (id.matches("^H\\d{2}+$")) {
                return id.toUpperCase();

            }
            if (id.trim().isEmpty()) {
                System.err.println("ID Can't Not Empty!");

            }
            if (!id.matches("^H\\d+$")) {
                System.err.println("PLease Enter True Format Id (H**)");
            }

        } while (true);
    }

    /**
     *
     * input name
     */
    public String inputName(String mes) {
        Scanner sc = new Scanner(System.in);
        String ten;
        do {
            System.out.println(mes);
            ten = sc.nextLine().trim().toUpperCase();
            if (ten.isEmpty()) {
                System.err.println("Do Not Empty!");
            } else {
                return ten;
            }
        } while (true);
    }

    /**
     *
     * input int
     */
    public int inputInt(String msg, int x, int y) {
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        boolean check = true;
        int input;
        String rs;
        while (check) {
            try {
                rs = sc.nextLine().trim();
                if (rs.isEmpty()) {
                    System.err.println("Do Not Be Empty!");
                }
                input = Integer.parseInt(rs);
                if (input < x || input > y) {
                    System.err.println("This Number Must Be " + x + "  to  " + y);
                    check = true;
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.err.println("This Must Be Number " + x + "  to  " + y);
                check = true;
            }
        }
        return 0;
    }

    /**
     *
     * input address
     */
    public String inputAddress(String msg) {
        Scanner sc = new Scanner(System.in);
        String address = "";
        do {
            System.out.println(msg);
            address = sc.nextLine();
            if (address.isEmpty()) {
                System.err.println("Address Cannot Empty");
            }
        } while (address.trim().isEmpty());
        return address;
    }

    /**
     *
     * input phone number
     */
    public int inputPhone(String mess) {
        Scanner sc = new Scanner(System.in);
        String phone;
        do {
            System.out.println(mess);
            phone = sc.nextLine().trim();
            if (phone.isEmpty()) {
                System.err.println("Phone Can Not Empty");

            }
            if (!phone.matches("^(0[789])+([0-9]{8})$")) {
                System.err.println("PLease Enter True Phone's Format (0*********)");

            } else {
                return Integer.parseInt(phone);
            }
        } while (true);
    }

    /**
     *
     * input string
     */
    public String inputString(String mes) {
        Scanner sc = new Scanner(System.in);
        String s;
        do {
            System.out.println(mes);
            s = sc.nextLine();
            if (s.isEmpty()) {
                System.out.println("Can not empty");
            }
        } while (s.trim().isEmpty());
        return s;
    }

    /**
     *
     * input rating
     */

    public int inputRating(String mes) {
        Scanner sc = new Scanner(System.in);
        int rating;
        boolean check = false;
        while (true) {
            try {
                System.out.print(mes + ": ");
                rating = Integer.parseInt(sc.nextLine().trim());
                if (rating < 1 || rating > 5) {
                    System.err.println("Rating must be between 1 and 5");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a valid number.");
            }
        }
        return rating;
    }

    /**
     * hàm để tìm bằng id
     *
     *
     */
    public HotelInformation searchId(String id) {
        for (HotelInformation hotelinformation : list) {
            if (id.equals(hotelinformation.getHotel_Id())) {
                return hotelinformation;
            }
        }
        return null;
    }

    /**
     * hàm để tìm bằng name
     *
     *
     */
    public HotelInformation searchName(String name) {
        for (HotelInformation hotelinformation : list) {
            if (name.equals(hotelinformation.getHotel_Name())) {
                return hotelinformation;
            }
        }
        return null;
    }

    public HotelInformation checkId(String idnumber) {
        for (HotelInformation hotelInformation : list) {
            if (idnumber.equalsIgnoreCase(hotelInformation.getHotel_Id())) {
                return hotelInformation;
            }
        }
        return null;
    }

    // functions update information
    public String inputUpdateId(String mes, HotelInformation ht) {
        System.out.println(mes);
        String id;
        do {
            id = sc.nextLine().trim().toUpperCase();
            if (checkId(id) != null) {
                System.err.println("Id Hotel Existed");
                System.out.println("Please Enter Again!");
            }

            if (id.trim().isEmpty()) {
                return ht.getHotel_Id();
            }
            if (!id.matches("^H\\d+$")) {
                System.err.println("PLease Enter True Format Id (H**)");
            }
            if (id.matches("^H\\d+$")) {
                return id.toUpperCase();
            }
        } while (true);
    }

    /**
     *
     * update name
     */

    public String inputUpdateName(String mes, HotelInformation ht) {

        System.out.println(mes);
        do {
            String name = sc.nextLine().toUpperCase().trim();
            if (name.trim().isEmpty()) {
                return ht.getHotel_Name();
            } else if (!name.matches("^[A-Za-z]+(?:[ -][A-Za-z]+)*$")) {
                System.out.println("Please enter again!");

            } else {
                return name;
            }

        } while (true);
    }

    /**
     *
     * update rating
     */
    public int inputUpdateRating(String msg, int a, int b, HotelInformation ht) {
        System.out.println(msg);
        boolean check = true;
        int result;
        String input;
        do {
            try {
                input = sc.nextLine().trim();
                if (input.trim().isEmpty()) {
                    return ht.getHotel_Room_Available();
                }
                result = Integer.parseInt(input);
                if (result < a || result > b) {
                    System.err.println("This number must be " + a + " to " + b);
                } else {
                    return result;
                }
            } catch (NumberFormatException e) {
                System.err.println("This must be a number");
                check = true;
            }
        } while (check);
        return 0;
    }

    /**
     *
     * update phone number
     */
    public int inputUpdatePhone(String mess, HotelInformation ht) {
        Scanner sc = new Scanner(System.in);
        String phone;
        do {
            System.out.println(mess);
            phone = sc.nextLine().trim();
            if (phone.trim().isEmpty()) {
                return ht.getHotel_Phone();
            }
            if (!phone.matches("^(0[789])+([0-9]{8})$")) {
                System.err.println("PLease Enter True Phone's Format (0*********)");

            } else if (phone.isEmpty()) {
                System.err.println("Phone Can Not Empty");

            } else {
                return Integer.parseInt(phone);
            }
        } while (true);
    }

    /**
     *
     * update address
     */
    public String inputUpdateAddress(String msg, HotelInformation ht) {
        System.out.println(msg);
        do {
            String address = sc.nextLine();

            if (address.trim().isEmpty()) {
                return ht.getHotel_Address();
            } else {
                return address;
            }
        } while (true);

    }

    /**
     *
     * update room
     */
    public int inputUpdateRoomAvailable(String msg, int x, int y, HotelInformation ht) {
        System.out.println(msg);
        boolean check = true;
        int result;
        String input;
        do {
            try {
                input = sc.nextLine().trim();
                if (input.trim().isEmpty()) {
                    return ht.getHotel_Room_Available();
                }
                result = Integer.parseInt(input);
                if (result < x || result > y) {
                    System.err.println("This number must be " + x + " to " + y);
                } else {
                    return result;
                }
            } catch (NumberFormatException e) {
                System.err.println("This must be a number");
                check = true;
            }
        } while (check);
        return 0;
    }

    /**
     * function add information
     *
     *
     */
    @Override
    public void addHotel() {

        String id;
        boolean yesNo = true;
        do {
            id = inputId("Enter hotel id:");
            if (searchId(id) != null) {
                System.out.println("Duplicate");
                System.out.println("Add fail!");
                break;
            } else {
                HotelInformation ht = new HotelInformation();
                ht.setHotel_Id(id);
                ht.setHotel_Name(inputName("Enter name of hotel:"));
                ht.setHotel_Phone(inputPhone("Enter phone number:"));
                ht.setHotel_Address(inputAddress("Enter an address of hotel:"));
                ht.setHotel_Room_Available(inputInt("Enter room available of hotel:", 1, 1000));
                ht.setHotel_Rating(inputInt("Enter rating of hotel:", 1, 5));
                list.add(ht);
                yesNo = Confirm.Confirm("Do you want to add more? Choose Y for Yes and N for No");
            }
            System.out.println("Add information successfully !");
        } while (yesNo);

    }

    /**
     * delete function
     *
     *
     */

    @Override
    public void deleteHotel() {
        boolean flag;
        String id = inputId("Enter Id You Want To Delete");
        HotelInformation ht = searchId(id);
        if (ht != null) {
            System.out.println("Found Hotel !");
            System.out.println("*----|-----------------|----------|--------------------------------------------------------|-----------|-----------|*");
            System.out.println("* ID |      NAME       |   ROOM   |                       ADDRESS                          |   PHONE   |    RATING |*");
            System.out.println(ht);
            flag = Confirm.Confirm("Do you want to delete this hotel? Choose Y for Yes and N for No");
            if (flag) {
                list.remove(ht);
                System.out.println("Delete successfully !");
            }

        } else {
            System.out.println("No found hotel id!");
            System.out.println("Delete Fail!");
        }
    }

    /**
     * check exist function
     *
     *
     */
    @Override
    public void checkExistHote() {

        String id = inputId("Enter ID want to search:");
        HotelInformation ht = checkId(id);

        if (ht != null) {
            System.out.println("Hotel exist");
            System.out.println("*----|-----------------|----------|--------------------------------------------------------|-----------|-----------|*");
            System.out.println("* ID |      NAME       |   ROOM   |                       ADDRESS                          |   PHONE   |    RATING |*");
            System.out.println(ht);

        } else {
            System.out.println("No Found Hotel");
        }

    }

    /**
     * update function
     *
     *
     */
    @Override
    public void updateHotel() {
    boolean yesNo;
    boolean flag= true;
   String newId;
     
        if (list.isEmpty()) {
            System.out.println("List is empty");
        }
        String id = inputId("Please Check Id You Want To Update");
        HotelInformation ht = checkId(id);
        if(ht!=null){
              
            System.out.println("Hotel Existed");
            System.out.println("Found Hotel");
            System.out.println(ht);
            yesNo = Confirm.Confirm("Do You Want To Continue Update  [Enter(Y/N)]");
            if (yesNo) {
                do {
                   newId= inputUpdateId("nhap id moi", ht);
                    if (checkId(newId) != null&&id!=newId) {
                        System.out.println("Hotel Existed!");
                        }
                    else {
                        ht.setHotel_Id(newId);
                        break;
                    }
                    } while (flag);
              ht.setHotel_Id(newId);
              ht.setHotel_Name(inputUpdateName("Enter new name hotel", ht));
              ht.setHotel_Address(inputUpdateAddress("Enter new address hotel", ht));
              ht.setHotel_Phone(inputUpdatePhone("Enter new phone", ht));
              ht.setHotel_Rating(inputUpdateRating("Enter new rating", 1, 5, ht));
              ht.setHotel_Room_Available(inputUpdateRoomAvailable("Enter new room available", 1, 1000, ht));
               System.out.println("Update succesfully");
                System.out.println(ht);
            } else {
                System.err.println("Update fail!");
            }
        } else {
            System.out.println("No Found Hotel To Update");
            System.err.println("Update Fail!");
        }

                    }
        
    
    /**
     * display descended by hotel name
     *
     *
     */
//thu tu giam dan
    @Override
    public void displayHotel() {
        System.out.println("Hotel List is descended by Name:");
        System.out.println("*----|-----------------|----------|--------------------------------------------------------|-----------|-----------|*");
        System.out.println("* ID |      NAME       |   ROOM   |                       ADDRESS                          |   PHONE   |    RATING |*");

        Collections.sort(list, Comparator.comparing(HotelInformation::getHotel_Name).reversed());
        for (HotelInformation hotelinformation : list) {
            System.out.println(hotelinformation);

        }
    }

    /**
     * search hotel by id
     *
     *
     */
    @Override
    public void searchHotelByID() {
        String id = inputId("Enter id you want to search");
        boolean check = true;
        if (list.isEmpty()) {
            System.err.println("List is empty");
            return;
        }
        for (HotelInformation hotelinformation : list) {
            if (hotelinformation.getHotel_Id().contains(id)) {
                System.out.println("*----|-----------------|----------|--------------------------------------------------------|-----------|-----------|*");
                System.out.println("* ID |      NAME       |   ROOM   |                       ADDRESS                          |   PHONE   |    RATING |*");
                System.out.println(hotelinformation);
                check = true;
            }

        }
        if (!check) {
            System.out.println("Can't found Id: " + id);

        }

    }

    /**
     * search hotel by name
     *
     *
     */
    @Override
    public void searchHotelByName() {
        String name = inputName("Enter name you want to search");
        boolean check = true;
        if (list.isEmpty()) {
            System.err.println("List is empty");
        }
        for (HotelInformation hotelinformation : list) {
            if (hotelinformation.getHotel_Name().equals(name)) {
                System.out.println("*----|-----------------|----------|--------------------------------------------------------|-----------|-----------|*");
                System.out.println("* ID |      NAME       |   ROOM   |                       ADDRESS                          |   PHONE   |    RATING |*");
                System.out.println(hotelinformation);
                check = true;
            } else if (!check) {
                System.out.println("Can't found name:" + name);
            }
        }
    }

    /**
     * save file
     *
     *
     */
    public void saveFile(String file) {
        // Save product data
        if (list.isEmpty()) {
            System.err.println("Empty product list");
            return;
        } else {
            try {
                FileOutputStream fos = new FileOutputStream(file);//tạo một FileOutputStream để ghi dữ liệu vào tệp file.
                ObjectOutputStream oos = new ObjectOutputStream(fos);//ghi các đối tượng từ danh sách vào tệp 
                for (int i = 0; i < list.size(); i++) {
                    oos.writeObject(list.get(i));
                }
                oos.close();
                fos.close();
            } catch (IOException e) {
                System.err.println("Error saving product data to file: " + file);
            }
        }
    }

    /**
     * read file
     *
     *
     */
    public void readFile(String file) {
        try {
            FileInputStream fos = new FileInputStream(file);// FileInputStream để đọc từ file
            ObjectInputStream oos = new ObjectInputStream(fos);// để đọc đối tượng từ tệp tin và ép kiểu chúng thành HotelInformation.
            while (true) {
                try {
                    // Đọc một đối tượng và ép kiểu thành hoteliom d
                    HotelInformation hotel = (HotelInformation) oos.readObject();
                    list.add(hotel);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception i) {
            System.out.println("Error to read File:" + file);
        }
    }

}
