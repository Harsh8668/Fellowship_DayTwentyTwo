package com.javaprojects.daytwentytwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<UserInterface> addressArray = new ArrayList<UserInterface>();
    static Main main = new Main();

    public static void main(String[] args) {
//        Main main = new Main();
        int option = 0;
        while (option != 5) {
            option = main.showMainMenu(option);
            main.handleUserSelection(option);
        }
    }

    //Option to be chosen for the activity
    public int showMainMenu(int option) {
        System.out.println("Choose an option : \n 1. Add Contact \n 2. Display \n " +
                "3. Delete \n 4. Edit \n 5. duplicateEntries \n 6. findPerson" +
                "\n 7. viewPersonInCityOrState \n 8. getCountOfCityAndState" +
                "\n 9. Exit");
        return (sc.nextInt());
    }

    public void handleUserSelection(int option) {
        switch (option) {
            case 1:
                addContact();
                break;
            case 2:
                displayContact();
                break;
            case 3:
                deleteContact();
                break;
            case 4:
                editContact();
                break;
            case 5:
                System.out.println("enter a  name");
                String personName=sc.next();
                duplicateEntries(personName);
                break;
            case 6:
                System.out.println("Enter a city and state:-");
                String city=sc.next();
                String state=sc.next();
                searchPersonInCityOrState(city, state);
                break;
            case 7:
                viewPersonInCityOrState();
                break;
            case 8:
                getCountOfCityAndState();
                break;
            case 9:
                break;
            default:
                System.out.println("Invalid option");
        }
    }


    //Adding the contacts
    private void addContact() {
        UserInterface ui = new UserInterface();
        System.out.println("Enter your First name");
        String firstName = sc.next();
        ui.setFirstName(sc.next());
        System.out.println("Enter your Last name");
        String lastName = sc.next();
        ui.setLastName(sc.next());
        System.out.println("Enter your Address");
        String address = sc.next();
        ui.setAddress(sc.next());
        System.out.println("Enter your City");
        String city = sc.next();
        ui.setCity(sc.next());
        System.out.println("Enter your State");
        String state = sc.next();
        ui.setState(sc.next());
        System.out.println("Enter your Email address");
        String email = sc.next();
        ui.setEmail(sc.next());
        System.out.println("Enter your Zip Code");
        int zipCode = sc.nextInt();
        ui.setZipCode(sc.nextInt());
        System.out.println("Enter your Phone number");
        int phoneNumber = sc.nextInt();
        ui.setPhoneNumber(sc.nextInt());

        addressArray.add(ui);
        UserInterface person1 = new UserInterface(firstName, lastName, address, city,
                state, email, zipCode, phoneNumber);
        addressArray.add(person1);
        System.out.println(addressArray);
        System.out.println("Contact Added Successfully");
    }

    //Displaying the contacts
    private void displayContact() {
        for (int i = 0; i < addressArray.size(); i++) {
            UserInterface user = addressArray.get(i);
            System.out.println();
            System.out.println("FirstName" + ":=" + user.getFirstName() + "\n" + "lastname" + ":= " + user.getLastName() + "\n" +
                    "Address" + ":= " + user.getAddress() + "\n" + "City" + ":= " + user.getCity() + "\n" +
                    "State" + ":=" + user.getState() + "\n" + "Zip" + ":= " + user.getZipCode() + "\n" +
                    "PhoneNumber" + ":= " + user.getPhoneNumber() + "\n" + "Email" + ":= " + user.getEmail());
        }
    }


    //Deleting the contacts
    private void deleteContact() {
        System.out.println("Enter the name to delete the contact");
        String name = sc.next();
        for (int i = 0; i < addressArray.size(); i++) {
            if (addressArray.get(i).getFirstName().equalsIgnoreCase(name)) {
                UserInterface ui = addressArray.get(i);
                addressArray.remove(ui);
            }
        }
        System.out.println(addressArray);
    }


    //Editing the contacts
    private void editContact() {
        System.out.println("Enter a name:");
        String name = sc.next();
        for (int i = 0; i < addressArray.size(); i++) {
            if (addressArray.get(i).getFirstName().equalsIgnoreCase(name)) {
                System.out.println("select options");
                System.out.println("\n1.First Name\n2.Last Name\n3.Address\n4.City\n5.State\n6.Zip\n7.Phone Number\n8.Email");
                int option = sc.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Enter a First name:");
                        String editFirstName = sc.next();
                        addressArray.get(i).setFirstName(editFirstName);
                        System.out.println(editFirstName);
                        break;
                    case 2:
                        System.out.print("Enter a Last name:");
                        addressArray.get(i).setLastName(sc.next());
                        break;
                    case 3:
                        System.out.print("Enter a Address:");
                        addressArray.get(i).setAddress(sc.next());
                        break;
                    case 4:
                        System.out.print("Enter a city:");
                        addressArray.get(i).setCity(sc.nextLine());
                        break;
                    case 5:
                        System.out.print("Enter a state:");
                        addressArray.get(i).setState(sc.nextLine());
                        break;
                    case 6:
                        System.out.print("Enter a zip code:");
                        addressArray.get(i).setZipCode(sc.nextInt());
                        break;
                    case 7:
                        System.out.print("Enter a phone number:");
                        addressArray.get(i).setPhoneNumber(sc.nextLong());
                        break;
                    case 8:
                        System.out.print("Enter a email:");
                        addressArray.get(i).setEmail(sc.nextLine());
                        break;
                    default:
                        System.out.println("enter valid contact");
                }
            }
            System.out.println("Edited list is:");
            System.out.println(addressArray);
        }
    }

    public void duplicateEntries(String name){
        List<UserInterface> RemoveDuplicates = addressArray.stream().filter(names ->names.getFirstName().equalsIgnoreCase(name)).distinct().collect(Collectors.toList());
        System.out.println("Removing duplicate elements"+RemoveDuplicates);
    }

    public void searchPersonInCityOrState(String city, String state){
        List<UserInterface> findPerson = addressArray.stream().filter(cities ->cities.getCity().equals(city)).filter(states ->states.getState().equals(state)).collect(Collectors.toList());
        System.out.println("Finding person in a city or state is:"+findPerson);
    }

    public void viewPersonInCityOrState(){
        Map<String, Map<String, List<UserInterface>>> people1=addressArray.stream().collect(Collectors.groupingBy(UserInterface::getCity, Collectors.groupingBy(UserInterface::getState)));
        System.out.println("After grouping by city and state is:-"+people1);
    }

    public void getCountOfCityAndState() {
        Map<String, Map<String, Long>> people=addressArray.stream().collect(Collectors.groupingBy(UserInterface::getCity, Collectors.groupingBy(UserInterface::getState, Collectors.counting())));
        System.out.println("Counting People by city and state is:-"+people);
    }
}
