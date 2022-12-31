package sportfacility.logic;

import sportfacility.data.entities.Customer;
import sportfacility.data.entities.facilities.Facility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Menu {
    private Scanner reader = new Scanner(System.in);
    private LinkedList<Customer> customerLinkedList = new LinkedList<>();
    private LinkedList<Facility> facilitiesLinkedList = new LinkedList<>();

    public void start() {
        try {
            LoadCustomers();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("WELCOME TO OUR SPORT FACILITY");
        System.out.println();
        MainMenu();
    }

    private void MainMenu() {
        char c = 0;
        boolean exit = false;
        while (!exit) {
            System.out.println("DO YOU WANT TO SIGN UP(s) OR REGISTER(r) OR EXIT(e)?");
            c = reader.next().charAt(0);
            switch (c) {
                case 's':
                    SignUp();
                    break;
                case 'r':
                    Register();
                    break;
                case 'e':
                    Exit();
                    exit = true;
                    break;
                default:
                    System.out.println("Input " + c + " not understood");
            }
        }
    }

    private void Exit() {
        System.out.println("THE APPLICATION WILL SHUT DOWN");
        System.out.println("SEE YOU OTHER TIME!");
    }

    private void Register() {
        System.out.println("THANK YOU FOR CHOOSING US!");
        System.out.println("LETS CREATE YOUR ACCOUNT!");
        Customer cus = NewCustomerInfo();
        System.out.println("NEW ACCOUNT CREATED!!");
        System.out.println("THANK YOU " + cus.getName() + " YOUR MEMBERSHIP NUMBER IS " + cus.getMembershipNumber());
        //See if the new customer was added
        for (Customer c : customerLinkedList) {
            System.out.println(c.toString());
        }
        System.out.println();
    }

    private Customer NewCustomerInfo() {
        System.out.println("Introduce the required information");
        Scanner reader = new Scanner(System.in);
        System.out.print("Name: ");
        String name = reader.next();
        System.out.print("Surname: ");
        String surname = reader.next();
        System.out.print("Age: ");
        int age = AskForValidAge();
        System.out.print("ID: ");
        String id = AskForValidID();
        int membershipNumber = GetNonExistingMembershipNumber();

        Customer newCustomer = new Customer(name, surname, age, id, membershipNumber);
        customerLinkedList.add(newCustomer);

        return newCustomer;
    }

    private String AskForValidID() {
        String id;
        while (true) {
            Scanner u = new Scanner(System.in);
            id = u.next();
            try {
                Customer c = new Customer("A", "A", 18, id, 0001);
            } catch (IllegalArgumentException e) {
                System.out.println("Please try to enter a ID (6 numbers followed by 1 letter)");
                System.out.print("ID: ");
                continue;
            }
            break;
        }
        return id;
    }

    private int AskForValidAge() {
        int age;
        while (true) {
            Scanner u = new Scanner(System.in);
            try {
                age = u.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please try to enter a valid age");
                System.out.print("Age: ");
                continue;
            }
            if (age < 18) {
                System.out.println("Please try to enter an age over 18");
                System.out.print("Age: ");
                continue;
            }
            break;
        }
        return age;
    }

    private int GetNonExistingMembershipNumber() {
        boolean found = false;
        int n = 0;
        while (!found) {
            found = true;
            Random r = new Random();
            n = r.nextInt(10000);
            for (Customer c : customerLinkedList) {
                if (c.getMembershipNumber() == n)
                    found = false;
            }
        }
        return n;
    }

    private void SignUp() {
        System.out.println("s");
    }

    private void LoadCustomers() throws FileNotFoundException {
        Scanner input = new Scanner(new File("src/main/java/sportfacility/data/files/Customers"));

        while (input.hasNext()) {
            String[] line = input.nextLine().split("-");
            String name = line[0];
            String surname = line[1];
            int age = Integer.valueOf(line[2]);
            String id = line[3];
            int membershipNumber = Integer.valueOf(line[4]);

            Customer newCustomer = new Customer(name, surname, age, id, membershipNumber);
            customerLinkedList.add(newCustomer);
        }
        input.close();
    }
}
