package ui;

import javax.swing.*;
import model.*;

import java.util.Calendar;
import java.util.Random;

public class ReadX {

    Calendar date;
    ReadXControler controler;
    Random random;

    public ReadX(){
        date = Calendar.getInstance();
        controler = new ReadXControler();
        random = new Random();
    }
    public static void main(String[] args) {
        ReadX AppReadX = new ReadX();
        AppReadX.menu();

    }
    public void menu() {
        boolean onLoop = true;
        while (onLoop) {
            String[] opciones = {"Register Client", "Register Manager", "Login user", "","Exit"};
            String option = (String) JOptionPane.showInputDialog(null, "Choose an option", "Menu", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            switch (option) {
                case "Register Client":
                    addUser();
                    break;
                case "Register Manager":
                    addManger();
                    break;
                case "Login user":
                    loginUser();
                    break;
                case "Exit":
                    onLoop = false;
                    break;
            }
        }
    }
    public void addManger(){
        String name = JOptionPane.showInputDialog("Enter your Nick name \n " +
                "example: Quigua123");
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter your password: "));
        JOptionPane.showMessageDialog(null, controler.addManager(name,id));
    }
    public void addUser() {
        String name = JOptionPane.showInputDialog("Enter your Nick name \n " +
                "example: Quigua123");
        int typeId = Integer.parseInt(JOptionPane.showInputDialog("Enter type id: " + " \n " +
                "1. CitizenShip Card" + " \n " +
                "2. Identity Card" + " \n " +
                "3. Passport" + " \n "));
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter your ID: "));
        String email = JOptionPane.showInputDialog("Enter your Email");

        String[] botones = {"Premium", "Basic", "Critical"};
        int ventana = JOptionPane.showOptionDialog(null,
                "Choose your type User:",
                "ReadX",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                botones, botones[0]);
        if (ventana == 0) {
            String creditCard = JOptionPane.showInputDialog("Enter your Credit card number");
            String avatar = JOptionPane.showInputDialog("Enter your avatar url");
            JOptionPane.showMessageDialog(null, controler.addUser(name, typeId, id, email, creditCard, avatar));
        } else if (ventana == 1) {
            JOptionPane.showMessageDialog(null, controler.addUser(name, typeId, id, email));
        } else if (ventana == 2) {
            String blog = JOptionPane.showInputDialog("Enter your url blog: ");
            String creditCard = JOptionPane.showInputDialog("Enter your Credit card number");
            String avatar = JOptionPane.showInputDialog("Enter your avatar url");
            String area = JOptionPane.showInputDialog("Enter your interest area: ");
            int critics = Integer.parseInt(JOptionPane.showInputDialog("Enter the critics number: "));
            JOptionPane.showMessageDialog(null, controler.addUser(name, typeId, id, email, creditCard, avatar, area, blog, critics));
        }

    }
    public void addBibliographyProduct(){
        String[] botones = {"Book", "Magazine"};
        int ventana = JOptionPane.showOptionDialog(null,
                "Choose your type bibliography that you want register:",
                "ReadX",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                botones, botones[0]);
        if (ventana == 0) {
            String name = JOptionPane.showInputDialog("Enter the book name: ");
            int numberPages = Integer.parseInt(JOptionPane.showInputDialog("Enter pages numbers: " ));
            int gender = Integer.parseInt(JOptionPane.showInputDialog("Enter book gender: "  + " \n " +
                    "1. Sciencie Fiction" + " \n " +
                    "2. Fancy" + " \n " +
                    "3. Historical novel"));

            int day = Integer.parseInt(JOptionPane.showInputDialog(null, "Day of the publication: "));
            int moth = Integer.parseInt(JOptionPane.showInputDialog(null, "Month of the publication: "));
            int year = Integer.parseInt(JOptionPane.showInputDialog(null, "Year of the publication: "));
            Calendar cal = Calendar.getInstance();
            cal.set(day, moth, year);

            String review =  JOptionPane.showInputDialog("Enter a short review: ");
            double value = Double.parseDouble(JOptionPane.showInputDialog("Enter the book value: " ));
            String frontPage = JOptionPane.showInputDialog("Enter the URL of front page: ");
            int numSales = Integer.parseInt(JOptionPane.showInputDialog("Enter a number of copies sold: " ));

            String message = controler.addProduct(name, cal, numberPages, review, value, gender, frontPage, numSales);
            JOptionPane.showMessageDialog(null, message);

        } else if (ventana == 1) {
            String name = JOptionPane.showInputDialog("Enter magazine name: ");

            int day = Integer.parseInt(JOptionPane.showInputDialog(null, "Day of the publication: "));
            int moth = Integer.parseInt(JOptionPane.showInputDialog(null, "Month of the publication: "));
            int year = Integer.parseInt(JOptionPane.showInputDialog(null, "Year of the publication: "));
            Calendar cal = Calendar.getInstance();
            cal.set(day, moth, year);

            int numPages = Integer.parseInt(JOptionPane.showInputDialog("Enter the pages of magazines: " ));
            double valueSubscription = Double.parseDouble(JOptionPane.showInputDialog("Enter the magazine value: " ));

            int typeMagazine = Integer.parseInt(JOptionPane.showInputDialog("Enter type: " +
                    "1. Sciencie " + " \n " +
                    "2. Design " + " \n " +
                    "3. Varieties" + " \n "));
            int issuancePeriodicity = Integer.parseInt(JOptionPane.showInputDialog("Enter type: " +
                    "1. Daily " + " \n " +
                    "2. Weekly " + " \n " +
                    "3. Monthly " + " \n "+
                    "4. Yearly "));
            int activeSubscriptions = Integer.parseInt(JOptionPane.showInputDialog("Enter the active Subcriptions: " ));
            JOptionPane.showMessageDialog(null, controler.addProduct(name,  cal,  numPages,  valueSubscription,  issuancePeriodicity, typeMagazine, activeSubscriptions));
        }
    }
    public void modifyProduct(){
        String[] botones = {"Modify Book", "Modify Magazine", "Delete product"};
        int ventana = JOptionPane.showOptionDialog(null,
                "Choose your type User:",
                "ReadX",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                botones, botones[0]);

        if (ventana == 0) {
            String id = JOptionPane.showInputDialog("enter the ID product: ");
            BibliographyProduct product = controler.searchProducts(null,id);

            if(product != null){
                int option = Integer.parseInt(JOptionPane.showInputDialog("Choose the option that you change: " + "\n" +
                        "1. Name " + "\n" +
                        "2. page numbers " + "\n" +
                        "3. Review " + "\n" +
                        "4. Gender"));
                switch (option){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error. there is no product with that ID");
            }

        } else if (ventana == 1) {

        } else if (ventana == 2) {

        }
    }
    public void addRandomUser(){
        String[] button = {"Free", "Premium"};
        int window = JOptionPane.showOptionDialog(null,
                "Choose the user type for generate random: ",
                "ReadX",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                button, button[0]);
        if (window == 0) {
            JOptionPane.showMessageDialog(null, controler.generateRandomUsersFree());
        } else if (window == 1) {
            JOptionPane.showMessageDialog(null, controler.generateRandomUsersPremium());
        }
    }
    public void generateAllPays(){
        JOptionPane.showMessageDialog(null,  controler.generateAllPayments());

    }
    public void generateSurprise(){
        String[] botones = {"Generate all Surprises"};
        int ventana = JOptionPane.showOptionDialog(null,
                "Choose who the surprise goes to:",
                "ReadX",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                botones, botones[0]);
        if (ventana == 0) {
            JOptionPane.showMessageDialog(null, controler.surpriseGenerate());
        }
    }
    public void maxCritic(){
        JOptionPane.showMessageDialog(null, controler.maxCritic());
    }
    public void addRandomProduct(){
        String[] button = {"Book", "Magazine"};
        int window = JOptionPane.showOptionDialog(null,
                "Choose the product for generate random: ",
                "ReadX",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                button, button[0]);
        if (window == 0) {
            JOptionPane.showMessageDialog(null, controler.generateRandomBook());
        } else if (window == 1) {
            JOptionPane.showMessageDialog(null, controler.generateRandomMagazine());
        }
    }
    public void loginUser(){

        String[] button = {"Client", "Manager"};
        int window = JOptionPane.showOptionDialog(null,
                "Choose the typer user: ",
                "ReadX",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                button, button[0]);
        if (window == 0) {
            String nickname = JOptionPane.showInputDialog(null, "WELCOME.\n" + "Enter your Nickname: ");
            int password = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your ID.:"));

            User userLogged = controler.searchUser(password,nickname);
            if (userLogged != null && userLogged instanceof UserFree) {
                JOptionPane.showMessageDialog(null, controler.generateAdds(userLogged.getId()));
                JOptionPane.showMessageDialog(null,"WELCOME " + userLogged.getName());
                loginMenu(userLogged);
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect User or password, TRY AGAIN.");
                loginUser();
            }
        } else if (window == 1) {
            String nickname = JOptionPane.showInputDialog(null, "WELCOME.\n" + "Enter your Nickname: ");
            int password = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your ID.:"));

            Manager managerLogged = controler.searchManager(nickname, password);
            if (managerLogged != null) {
                JOptionPane.showMessageDialog(null,"WELCOME " + managerLogged.getName());
                managerMenu();
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect User or password, TRY AGAIN.");
                loginUser();
            }
        }
    }
    public void managerMenu(){
        boolean onLoop = true;
        while (onLoop) {
            String[] opciones = {"Modify Product", "Register Bibliography Product","Add random user", "Add random product","Generate all register payments","Generate surprise to users","Exit"};
            String option = (String) JOptionPane.showInputDialog(null, "Choose an option", "Menu", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            switch (option) {
                case "Modify Product":
                    modifyProduct();
                    break;
                case "Register Bibliography Product":
                    addBibliographyProduct();
                    break;
                case "Add random user":
                    addRandomUser();
                    break;
                case "Add random product":
                    addRandomProduct();
                    break;
                case "Generate all register payments":
                    generateAllPays();
                    break;
                case "Generate surprise to users":
                    generateSurprise();
                    break;
                case "Max critic User critic":
                    maxCritic();
                    break;
                case "Exit":
                    menu();
                    break;
            }
        }
    }
    public void loginMenu(User userLogged) {
        boolean onLoop = true;
        while (onLoop) {
            String[] opciones = {"Buy bibliografic product", "Consult own library", "Cancel subscription magazine","Exit"};
            String option = (String) JOptionPane.showInputDialog(null, "Choose an option", "Menu", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            switch (option) {
                case "Buy bibliografic product":
                    buyProduct(userLogged);
                    break;
                case "Consult own library":
                    library(userLogged);
                    break;
                case "Cancel subscription magazine":
                    cancelSubscription(userLogged);
                    break;
                case "Exit":
                    menu();
                    break;
            }
        }
    }
    public void buyProduct(User userLogged){
        String[] button = {"Book", "Magazine"};
        int window = JOptionPane.showOptionDialog(null,
                "Buy a book or Subscribe to a magazine:",
                "ReadX",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                button, button[0]);
        if (window == 0) {
            if(userLogged instanceof UserFree) {
                JOptionPane.showMessageDialog(null, controler.generateAdds(userLogged.getId()));
                String creditCard = JOptionPane.showInputDialog("enter the credit card to which you want to charge the payment ");
                int chooseBook = Integer.parseInt(JOptionPane.showInputDialog("Choose what book do you want to buy: \n" + controler.showBooks()));
                JOptionPane.showMessageDialog(null, controler.buyBook(chooseBook, userLogged, creditCard));
            } else {
                int chooseBook = Integer.parseInt(JOptionPane.showInputDialog("Choose what book do you want to buy: \n" + controler.showBooks()));
                JOptionPane.showMessageDialog(null, controler.buyBook(chooseBook, userLogged,null));
            }
        } else if (window == 1) {
            if(userLogged instanceof UserFree) {
                controler.generateAdds(userLogged.getId());
                String creditCard = JOptionPane.showInputDialog("enter the credit card to which you want to charge the payment ");
                int chooseBook = Integer.parseInt(JOptionPane.showInputDialog("Choose what magazine do you want to subscribe: \n" + controler.showMagazines()));
                JOptionPane.showMessageDialog(null, controler.subscribeMagazine(chooseBook, userLogged, creditCard));
            } else {
                int chooseBook = Integer.parseInt(JOptionPane.showInputDialog("Choose what magazine do you want to subscribe: \n" + controler.showMagazines()));
                JOptionPane.showMessageDialog(null, controler.subscribeMagazine(chooseBook, userLogged,null));
            }
        }
    }
    public void library(User userLogged){
        if(userLogged instanceof UserFree){
            JOptionPane.showMessageDialog(null, controler.generateAdds(userLogged.getId()));
        }
        JOptionPane.showMessageDialog(null, controler.showLibrary(userLogged) + "\n Choose the product, enter the x,y coordinates for starting a reading session." );

        int xCoord = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter de x coordinates"));
        int ycoord = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter de y coordinates"));
        boolean control = false;

        for (int i = 0; i < 1000 && !control; i++) {
            String message = controler.readingSimulator(xCoord, ycoord, userLogged, 0);
            String[] button = {"Back page", "Next page", "Back to menu"};
            int window = JOptionPane.showOptionDialog(null,
                    message,
                    "ReadX",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null,
                    button, button[0]);
            if (window == 0) {
                JOptionPane.showMessageDialog(null, controler.readingSimulator(xCoord, ycoord, userLogged, -1));
            } else if (window == 1) {
                JOptionPane.showMessageDialog(null, controler.readingSimulator(xCoord, ycoord, userLogged, 1));
            } else if (window == 2){
                loginMenu(userLogged);
                control = true;
            }
        }
    }
    public void cancelSubscription(User userLoggead){
        JOptionPane.showMessageDialog(null, "Choose the coordinates of magazine that do you want cancel: " +  controler.showMagazinesUser(userLoggead));

        int xCoord = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter de x coordinates"));
        int ycoord = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter de y coordinates"));

        JOptionPane.showMessageDialog(null, controler.cancelSubscription(userLoggead,xCoord,ycoord));

    }

}
