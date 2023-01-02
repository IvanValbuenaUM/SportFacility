package sportfacility.logic;

import sportfacility.data.entities.Customer;
import sportfacility.data.entities.Timetable;
import sportfacility.data.entities.facilities.BasketCourt;
import sportfacility.data.entities.facilities.Facility;
import sportfacility.data.entities.facilities.FootballCourt;
import sportfacility.data.entities.facilities.PadelCourt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Menu {
    private List<Customer> customerLinkedList = new LinkedList<>();
    private List<Facility> facilitiesLinkedList = new LinkedList<>();

    public void start() {
        try {
            LoadCustomers();
            LoadFacilities();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("WELCOME TO OUR SPORT FACILITY");
        System.out.println();
        MainMenu();
    }



    private void MainMenu() {
        int c = 1;
        boolean exit = false;
        while (!exit) {
            Scanner u = new Scanner(System.in);
            System.out.println("What do you want to do?"+"\n"+"(1) Sign up"+"\n"+ "(2) Register"+"\n"+"(3) Exit?");
            try {
                c = u.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please try to introduce a valid input");
                continue;
            }
            switch (c) {
                case 1:
                    SignUp();
                    break;
                case 2:
                    Register();
                    break;
                case 3:
                    Exit();
                    exit = true;
                    break;
                default:
                    System.out.println("Input " + c + " not understood");
            }
        }
    }

    private void Exit() {
        System.out.println();
        System.out.println("The application will shutdown");
        System.out.println("See you another day!");
    }

    private void Register() {
        System.out.println("Thank you for choosing us!");
        System.out.println("Lets create your account!");
        Customer cus = NewCustomerInfo();
        System.out.println("New account created!!");
        System.out.println("Thank you " + cus.getName() + " your membership number is " + cus.getMembershipNumber());
        //See if the new customer was added
        /*
        for (Customer c : customerLinkedList) {
            System.out.println(c.toString());
        }
        */

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
                System.out.println("Please try to introduce a ID (6 numbers followed by 1 letter)");
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
                System.out.println("Please try to introduce a valid age");
                System.out.print("Age: ");
                continue;
            }
            if (age < 18) {
                System.out.println("Please try to introduce an age over 18");
                System.out.print("Age: ");
                continue;
            }
            break;
        }
        return age;
    }
    private int AskForValidMembershipNumber() {
        int mem;
        while (true) {
            Scanner u = new Scanner(System.in);
            try {
                mem = u.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please try to introduce a valid membership number");
                System.out.print("Membership nº: ");
                continue;
            }
            try {
                Customer c = new Customer("A", "A", 18, "111111A", mem);
            } catch (IllegalArgumentException e) {
                System.out.println("Please try to introduce a membership number (number between 0 and 9999)");
                System.out.print("Membership nº: ");
                continue;
            }
            break;
        }
        return mem;
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
        System.out.println();
        System.out.println("Please introduce your customer information");
        System.out.print("ID: ");
        String id = AskForValidID();
        System.out.print("Membership nº: ");
        int mem = AskForValidMembershipNumber();
        boolean existed = false;
        Customer found = null;
        for (Customer c: customerLinkedList) {
            if (c.getId().equals(id) && c.getMembershipNumber() == mem) {
                found = c;
                existed = true;
            }
        }
        if (existed)
            MemberMenu(found);
        else
            System.out.println("No customer with that information found!");
    }

    private void MemberMenu(Customer c) {
        System.out.println();
        System.out.println("Welcome back " + c.getName() + "!");
        System.out.println("What would you like to do?");
        System.out.println();
        int i = 0;
        boolean exit = false;
        while (!exit) {
            Scanner u = new Scanner(System.in);
            PrintOptionsMember();
            try {
                i =u.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please try to introduce a valid option");
                continue;
            }
            switch (i) {
                case 1:
                    SeeMyReservations(c);
                    break;
                case 2:
                    MakeAReservation(c);
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Going back to the main menu " + c.getName());
                    System.out.println();
                    exit = true;
                    break;
                default:
                    System.out.println("Input " + i + " is not valid");
            }
        }
    }

    private void MakeAReservation(Customer c) {
        System.out.println();
        System.out.println("Choose what kind of facility you want");
        System.out.println();
        int i = 0;
        boolean exit = false;
        while (!exit) {
            Scanner u = new Scanner(System.in);
            PrintOptionsFacility();
            try {
                i =u.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please try to introduce a valid option");
                continue;
            }
            switch (i) {
                case 1:
                    ReserveBasketCourt(c);
                    break;
                case 2:
                    ReserveFootballCourt(c);
                    break;
                case 3:
                    ReservePadelCourt(c);
                    break;
                case 4:
                    ReserveTennisCourt(c);
                    break;
                case 5:
                    System.out.println();
                    System.out.println("Going back to the member menu " + c.getName());
                    System.out.println();
                    exit = true;
                    break;
                default:
                    System.out.println("Input " + i + " is not valid");
            }
        }
    }

    private void ReserveTennisCourt(Customer c) {
    }

    private void ReservePadelCourt(Customer c) {
    }

    private void ReserveFootballCourt(Customer c) {
    }

    private void ReserveBasketCourt(Customer c) {
        ShowAvailableBasketCourts();
    }

    private void ShowAvailableBasketCourts() {
        System.out.println("Basketball Courts:");
        List<Facility> basketCourts = new LinkedList<>();
        for (Facility f: facilitiesLinkedList) {
            if (f.getFacilityCode().charAt(0) == 'b')
                basketCourts.add(f);
        }
        for (Facility f: basketCourts) {
            System.out.println(f.AvailableString());
        }
    }

    private void PrintOptionsMember() {
        System.out.println("(1) My reservations");
        System.out.println("(2) Make a reservation");
        System.out.println("(3) Exit");
    }

    private void SeeMyReservations(Customer c) {

        if (c.getReservations().isEmpty()) {
            System.out.println();
            System.out.println("Miguel, you do not have any reservations yet");
        }
        else {
            System.out.println("Miguel, your reservations are:");
            for (Timetable t: c.getReservations()) {
                t.toString();
            }
        }
        System.out.println();
    }

    private void PrintOptionsFacility() {
        System.out.println("(1) Basket Court");
        System.out.println("(2) Football Court");
        System.out.println("(3) Padel Court");
        System.out.println("(4) Tennis Court");
        System.out.println("(5) Exit");
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
        /*
        for (Customer c: customerLinkedList) {
            System.out.println(c.toString());
        }
        */
        input.close();
    }
    private void LoadFacilities() throws FileNotFoundException {
        Scanner input = new Scanner(new File("src/main/java/sportfacility/data/files/Facilities"));

        while (input.hasNext()) {
            String[] line = input.nextLine().split("-");
            String code = line[0];
            int capacity = Integer.valueOf(line[1]);
            int priceHour = Integer.valueOf(line[2]);
            int nChangingRooms = Integer.valueOf(line[3]);
            int nFloodLights = Integer.valueOf(line[4]);
            int extraLightsPrice = Integer.valueOf(line[5]);
            Facility f = null;
            if (code.charAt(0) == 'b') {
                int basketBallsRented = Integer.valueOf(line[6]);
                f = new BasketCourt(code, capacity, priceHour, nChangingRooms, nFloodLights, extraLightsPrice, basketBallsRented);
            } else if (code.charAt(0) == 'f') {
                int footBallsRented = Integer.valueOf(line[6]);
                f = new FootballCourt(code, capacity, priceHour, nChangingRooms, nFloodLights, extraLightsPrice, footBallsRented);
            } else if (code.charAt(0) == 'p') {
                int padelRacquetsRented = Integer.valueOf(line[6]);
                int padelBallsRented = Integer.valueOf(line[7]);
                f = new PadelCourt(code, capacity, priceHour, nChangingRooms, nFloodLights, extraLightsPrice, padelRacquetsRented, padelBallsRented);
            } else if (code.charAt(0) == 't') {
                int tennisRacquetsRented = Integer.valueOf(line[6]);
                int tennisBallsRented = Integer.valueOf(line[7]);
                f = new PadelCourt(code, capacity, priceHour, nChangingRooms, nFloodLights, extraLightsPrice, tennisRacquetsRented, tennisBallsRented);
            }
            facilitiesLinkedList.add(f);
        }
        input.close();
    }
}
