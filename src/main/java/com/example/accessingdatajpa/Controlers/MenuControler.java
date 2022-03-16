package com.example.accessingdatajpa.Controlers;

import com.example.accessingdatajpa.Context;
import com.example.accessingdatajpa.Entities.AppUser;
import com.example.accessingdatajpa.Entities.Preferences;
import com.example.accessingdatajpa.Entities.Property;
import com.example.accessingdatajpa.Entities.Userr;
import com.example.accessingdatajpa.Services.PropertyCSVImporter;
import com.example.accessingdatajpa.Repository.PreferencesRepository;
import com.example.accessingdatajpa.Repository.PropertyRepository;
import com.example.accessingdatajpa.Repository.UserrRepository;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Scanner;

@Controller
public class MenuControler {
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private UserController userController;
    @Autowired
    private PropertyControler propertyControler;
    @Autowired
    private PreferencesRepository preferencesRepository;
    private PropertyCSVImporter propertyCSVImporter;
    Context context;
    boolean exit;

    public MenuControler() {
        this.context = Context.getInstance();
    }

    @Autowired
    private UserrRepository userrRepository;

    private void printHeader() {
        System.out.println("Welcome to my app!");
    }

    private void printChoose() {
        System.out.println("What would you like to do?");
    }

    private void printMenu_Seller() {
        System.out.println("1. See your properties.");
        System.out.println("2. Update a property.");
        System.out.println("3. Add a property.");
        System.out.println("4. Delete a property.");
        System.out.println("5. Logout");
        System.out.println("0. Exit");
    }

    private void printMenu_User() {
        System.out.println("1. See your preferences.");
        System.out.println("2. Update preference.");
        System.out.println("3. Add preferences.");
        System.out.println("4. Delete preferences.");
        System.out.println("6. Show my properties for me.");
        System.out.println("5. Logout");
        System.out.println("0. Exit");
    }

    private String getLogin() {
        System.out.println("Please enter your email! :(Type Exit to close the app.)");
        Scanner scanner = new Scanner(System.in);
        String email;
        email = scanner.nextLine();
        if (email.toLowerCase().equals("exit")) {
            System.exit(0);
        }
        return email;
    }

    private int getChoiceSeller() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice < 0 || choice > 6) {
            try {
                System.out.println("Enter your choice.");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Please enter a number again.");
            }
        }
        return choice;
    }

    private int getChoiceUser() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice < 0 || choice > 6) {
            try {
                System.out.println("Enter your choice.");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Please enter a number again.");
            }
        }
        return choice;
    }

    private void performActionSeller(int choice) {

        switch (choice) {
            case 0:
                System.out.println("Thanks, for using my app, it will close now.");
                System.exit(0);
                break;
            case 1:
                System.out.println("Showing your properties.");
                //this.printOutProperties();
                break;
            case 2:
                System.out.println("Updating your property.");
                break;
            case 3:
                System.out.println("Adding properties.");
                propertyControler.loadPropertyFromPath("abc");
                break;
            case 4:
                System.out.println("Deleting a property.");
                break;
            case 5:
                this.context.setCurrentUser(null);
                break;
        }
    }

    private void performActionUser(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Thanks, for using my app, it will close now.");
                System.exit(0);
                break;
            case 1:
                System.out.println("Showing your preferences.");
                this.printOutPreferenes();
                break;
            case 2:
                System.out.println("Updating your preferences.");
                break;
            case 3:
                System.out.println("Adding new preferences.");
                Preferences preferences = this.addPreference();
                break;
            case 4:
                System.out.println("Deleting a preference.");
                break;
            case 5:
                this.context.setCurrentUser(null);
                break;
            case 6:
                this.printOutProperties();
                break;
        }
    }

    private Userr addUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user type: (Choose between 'AppUser' or 'Seller')");
        String type = scanner.nextLine();
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        Userr newUser = userController.addNewUser(name, email, type);
        return newUser;
    }

    private Userr checkIfWantsToAddUser() {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Would you like to add a new user? (Press '1' [YES], press '0' [NO])");
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid selection. Please enter a number again.");
        }
        switch (choice) {
            case 1:
                return this.addUser();
            default:
                return null;
        }
    }

    private Preferences addPreference() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter minimum amount of bedrooms: ");
        int nrOfBedrooms = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter maximum price: ");
        int price = Integer.parseInt(scanner.nextLine());
        Preferences newPreference = userController.addNewPreference(price, nrOfBedrooms);
        userController.propertiesEvaluation(propertyControler.getAllProperties(), newPreference);
        return newPreference;
    }

    private Userr setLoginUser(String login) {
        Userr loginUser = userrRepository.findTopOneUserrByEmail(login);
        context.setCurrentUser(loginUser);
      // if (loginUser != null)
            /*if (loginUser.getType().equals("AppUser"))
                this.checkPrefrences();*/
        return loginUser;
    }

    private void checkPrefrences() {
        AppUser user = (AppUser)context.getCurrentUser();
        List<Preferences> userPreferences  = user.getPreferences();
        if (userPreferences.size() != 0) {
            for (Preferences onePreference : userPreferences) {
                List<Property> props = propertyControler.findPropertyByIdGreaterThan(onePreference.getLastPropertyChecked());
                if (props != null) {
                    userController.propertiesEvaluation(props, onePreference);
                    System.out.println("Updated your properties.");
                }
            }
        }
    }

    private void printOutPreferenes(){
        List<Preferences> preferencesToPrintout = ((AppUser)context.getCurrentUser()).getPreferences();
        for(Preferences preference : preferencesToPrintout){
            preference.toString();
        }
    }
    private void printOutProperties() {
        List<Preferences> preferencesToPrintout = ((AppUser) context.getCurrentUser()).getPreferences();
        for (Preferences preference : preferencesToPrintout) {
            List<Property> propertiesToPrintout = preference.getPropertiesToPref();
            for(Property property : propertiesToPrintout){
                System.out.println(property.toString());
            }
        }
    }


    public void runMenu() {
        propertyCSVImporter = new PropertyCSVImporter();
        this.printHeader();
        while (!exit) {
            while (this.context.getCurrentUser() == null) {
                String login = this.getLogin();
                Userr userr = setLoginUser(login);
                if (userr == null) {
                    context.setCurrentUser(this.checkIfWantsToAddUser());
                }
            }
            Userr curentUser = context.getCurrentUser();
            String type = curentUser.getType();
            if (type.equals("AppUser")) {
                this.printMenu_User();
                this.performActionUser(this.getChoiceUser());
            } else if (type.equals("Seller")) {
                this.printMenu_Seller();
                this.performActionSeller(this.getChoiceSeller());
            } else {
                break;
            }

        }
    }
}


