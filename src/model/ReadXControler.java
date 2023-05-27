package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Calendar;

public class ReadXControler {
    Calendar date = Calendar.getInstance();
    Date dateRegister = new Date();
    Random random = new Random();
    private ArrayList<User> users;
    private ArrayList<BibliographyProduct> produtcs;
    private ArrayList<Manager> managers;
    private static final String[] FIRST_NAMES = {"Emma56565", "LOLITA._.XD", "JuanElToro33", "PepitoSurxxxx", "MartinOliviaaa", "Noah0xv", "Ava_Nuñez132", "Ethan_Jogger", "SophiaPrimo56565", "DarthVaderF", "Mia_.Hernandez", "MasonElFiera1", "MarcoAurelioST", "AngaritaCranckedPalmiran", "MiguelElMoni777", "epitectoRamos666", "AndreaSantolla___", "MarianaRios1240", "_AnitaPasteleria_", "Messi4455454"};
    private static final String[] ADDS = {"¡Suscríbete al Combo Plus y llévate Disney+ y Star+ a un precio increíble!", "Ahora tus mascotas tienen una app favorita: Laika. Los mejores productos para tu peludito.", "¡Estamos de aniversario! Visita tu Éxito más cercano y sorpréndete con las mejores ofertas."};
    private static final String[] NAME_BOOKS = {"Meditaciones de Marco Aurelio", "Un mundo feliz - Aldous Huxley", "Ensayo sobre la ceguera - Jose Saramago", "Cuento completos de Jorge Luis Borges", "Pensar rapido, pensar despacio - Daniel Kahneman", "El miedo a la libertar - Erich Froom", "48 leyes del poder - Robert Greene", "Amor liquido - zygmunt bauman", "El Arte de amar - Erich Froom", "Crimen y castigo - Fiódor Dostoyevski", "Memorias de un subsuelo - Fiódor Dostoyevski", "La metamorfosis - Frankz Kafka", ",La condena - Frankz Kafka", "Eichmann en Jerusalem - Hannah Arendt", "La condición humana - Hannah Arendt", "La resistencia - Ernesto Sabato", "1984 - George Orwell", "Como pensar como einstein - Scott Thorpe", "Calculo de una variable - James Stewar", "100 años de soledad - Gabriel Garcia Marquez"};
    private static final String[] NAME_MAGAZINES = {"El Tiempo", "La Migala", "Evon", "Diario Marca", "Sapiens", "Philosophical Transactions of the Royal Society", "Revista del Banco de la República", "Revista ANDI", "Revista interamericana de bibliotecología", "Colombia médica", "Boletín cultural y bibliográfico", "Revista del Banco de la República", "Pulzo", "El Espectador", "Extra", "El Q´hubo", "La Nacion", "Aranajuez", "Revista Icesi", "El Diaro"};

    public ReadXControler() {

        users = new ArrayList<>();
        produtcs = new ArrayList<>();
        managers = new ArrayList<>();

        Book books = new Book("Icesi te apoya -  Icesi", date, 344, "A beautiful Book", 45, generateID(),TypeGender.FANCY, "Icesi.com", 356);
        Magazine magazine = new Magazine("La gazeta", date, 45, 25,generateID(), TypePerodicity.MONTHLY, TypeMagazine.SCIENCIE, 45);
        produtcs.add(books);
        produtcs.add(magazine);

        User userFree = new UserFree("RaulQuiguaTilin123", TypeID.PASSPORT, 111181914, dateRegister, "Raul@gmail.com");
        User userPremium = new UserPremium("Geoffrey0Pv", TypeID.PASSPORT, 1006332375, dateRegister, "Geoffreypv00@gmail.com","34343434334", "avatar.jpg");
        users.add(userFree);
        users.add(userPremium);
    }
    public String addManager(String name, int id){
        Manager managerSearch = searchManager(name, id);
        String message = "";
        if(managerSearch != null ){
            message = "TRY AGAIN. User had already been registered. ";
        } else {
            Manager manager = new Manager(name, id);
            managers.add(manager);
            message = "Manager has been added succesfuly " + manager;
        }
        return message;
    }
    public Manager searchManager(String name, int id){
        Manager managerSearch = null;
        for(Manager manager : managers){
            if(manager.getId() == id && manager.getName().equalsIgnoreCase(name)){
                managerSearch = manager;
            }
        }
        return managerSearch;
    }
    /**
     * Adds a user to the system with the specified details.
     *
     * @param name       the name of the user
     * @param typeId     the type ID indicating the type of identification document
     * @param id         the user's identification number
     * @param email      the user's email address
     * @param creditCard the user's credit card information
     * @param avatar     the user's avatar
     * @return a message indicating the result of the operation
     */
    public String addUser(String name, int typeId, int id, String email, String creditCard, String avatar) {
        String message;
        User UserPremium = searchUser(id, name);
        TypeID idCard;
        switch (typeId) {
            case 1:
                idCard = TypeID.CITIZENSHIPCARD;
                break;
            case 2:
                idCard = TypeID.IDENTITYCARD;
                break;
            case 3:
                idCard = TypeID.PASSPORT;
                break;
            default:
                idCard = null;
                break;
        }
        if (UserPremium != null) {
            message = "TRY AGAIN. User had already been registered. ";
        } else {
            User userPremium = new UserPremium(name, idCard, id, dateRegister, email, creditCard, avatar);
            users.add(userPremium);
            message = "User premium add succesfuly \n" + generatePay(id);
        }
        return message;
    }
    /**
     * Adds a user to the system with the specified details.
     *
     * @param name   the name of the user
     * @param typeId the type ID indicating the type of identification document
     * @param id     the user's identification number
     * @param email  the user's email address
     * @return a message indicating the result of the operation
     */
    public String addUser(String name, int typeId, int id, String email) {
        String message;
        TypeID idCard;
        switch (typeId) {
            case 1:
                idCard = TypeID.CITIZENSHIPCARD;
                break;
            case 2:
                idCard = TypeID.IDENTITYCARD;
                break;
            case 3:
                idCard = TypeID.PASSPORT;
                break;
            default:
                idCard = null;
                break;
        }
        User userfree = searchUser(id, name);
        if(userfree != null){
            message = "TRY AGAIN. User had already been registered. ";
        } else {
            User userFree = new UserFree(name, idCard, id, dateRegister, email);
            users.add(userFree);
            message = "User regular register succesfuly. \n" + userFree;
        }
        String adds = generateAdds(id);
        return message + "\n" + adds;
    }/**
     * Adds a premium critical user to the system with the specified details.
     *
     * @param name       the name of the user
     * @param typeId     the type ID indicating the type of identification document
     * @param id         the user's identification number
     * @param creditCard the user's credit card information
     * @param avatar     the user's avatar
     * @param area       the user's area
     * @param email      the user's email address
     * @param blog       the user's blog
     * @param critics    the number of critics made by the user
     * @return a message indicating the result of the operation
     */
    public String addUser(String name, int typeId, int id, String creditCard, String avatar, String area, String email, String blog, int critics){
        String message;
        User UserPremium = searchUser(id, name);
        TypeID idCard;
        switch (typeId) {
            case 1:
                idCard = TypeID.CITIZENSHIPCARD;
                break;
            case 2:
                idCard = TypeID.IDENTITYCARD;
                break;
            case 3:
                idCard = TypeID.PASSPORT;
                break;
            default:
                idCard = null;
                break;
        }
        if (UserPremium != null) {
            message = "TRY AGAIN. User had already been registered. ";
        } else {
            User userCritical = new UserCritical(name, idCard, id, dateRegister, email, creditCard, avatar, area, blog, critics);
            users.add(userCritical);
            message = "User premium critical add sucesfuly" +
                    "\n" + generatePay(id);
        }
        return message;
    }
    /**
     * Adds a book product to the system with the specified details.
     *
     * @param name      the name of the book
     * @param date      the publication date of the book
     * @param numPages  the number of pages in the book
     * @param review    the review of the book
     * @param value     the value of the book
     * @param gender    the gender of the book
     * @param frontPage the front page of the book
     * @param numSales  the number of sales of the book
     * @return a message indicating the result of the operation
     */
    public String addProduct(String name, Calendar date, int numPages, String review, double value, int gender, String frontPage, int numSales) {
        String message;
        TypeGender genderType;
        switch (gender) {
            case 1:
                genderType = TypeGender.SCIENCIE_FICTICCION;
                break;
            case 2:
                genderType = TypeGender.FANCY;
                break;
            case 3:
                genderType = TypeGender.HISTORICAL_NOVEL;
                break;
            default:
                genderType = null;
                break;
        }
        String id = generateID();
        BibliographyProduct book = searchProducts(name, id);
        if(book != null){
            message = "TRY AGAIN. Magazine had already been registered. ";
        } else {
            BibliographyProduct books = new Book(name, date,  numPages,  review,  value, id,  genderType, frontPage, numSales);
            produtcs.add(books);
            message = "Book register succesfuly. ";
        }
        return message;
    }
    /**
     * Adds a magazine product to the system with the specified details.
     *
     * @param name                the name of the magazine
     * @param date                the publication date of the magazine
     * @param numPages            the number of pages in the magazine
     * @param value               the value of the magazine
     * @param issuancePeriodicity the issuance periodicity of the magazine
     * @param typeMagazine        the type of the magazine
     * @param activeSubscriptions the number of active subscriptions for the magazine
     * @return a message indicating the result of the operation
     */
    public String addProduct(String name, Calendar date, int numPages, double value, int issuancePeriodicity, int typeMagazine, int activeSubscriptions){
        String message;
        TypePerodicity periodicity;
        switch (issuancePeriodicity) {
            case 1:
                periodicity = TypePerodicity.DAILY;
                break;
            case 2:
                periodicity = TypePerodicity.WEEKLY;
                break;
            case 3:
                periodicity = TypePerodicity.MONTHLY;
                break;
            case 4:
                periodicity = TypePerodicity.YEARLY;
                break;
            default:
                periodicity = null;
                break;
        }
        TypeMagazine category;
        switch (typeMagazine) {
            case 1:
                category = TypeMagazine.SCIENCIE;
                break;
            case 2:
                category = TypeMagazine.DESIGN;
                break;
            case 3:
                category = TypeMagazine.VARIETIES;
                break;
            default:
                category = null;
                break;
        }
        String id = generateID();
        BibliographyProduct magazine = searchProducts(name, id);
        if(magazine != null){
            message = "TRY AGAIN. Magazine had already been registered. ";
        } else {
            BibliographyProduct magazines = new Magazine( name,  date,  numPages,  value,  id,periodicity,  category, activeSubscriptions);
            produtcs.add(magazines);
            message = "Magazine register succesfuly. " + magazines;
        }
        return message;
    }
    /**
     * Generates a unique ID consisting of a random character, a random number, and another random character.
     *
     * @return The generated ID as a string.
     */
    public String generateID() {
        int num = random.nextInt(9) + 1;
        String character = "abcdefghijklmnopqrstyxz";
        String message;
        char randomCharacter = '0';
        for (int i = 0; i < 10; i++) {
            int indice = random.nextInt(character.length());
            randomCharacter = Character.toUpperCase(character.charAt(indice));
        }
        char randomCharacter2 = '0';
        for (int i = 0; i < 10; i++) {
            int indice = random.nextInt(character.length());
            randomCharacter2 = Character.toUpperCase(character.charAt(indice));
        }
        message = String.valueOf(randomCharacter) + num + (randomCharacter2);
        return message;
    }
    /**
     * Searches for a user in the system based on the specified ID and name.
     *
     * @param id   the ID of the user to search for
     * @param name the name of the user to search for
     * @return the found User object or null if no user is found
     */
    public User searchUser(int id, String name) {
        User userSearch = null;
        for(User user : users){
            if (user.getId() == id && user.getName().equalsIgnoreCase(name)){
                userSearch = user;
            }
        }
        return userSearch;
    }
    /**
     * Searches for a product in the system based on the specified name.
     *
     * @param name the name of the product to search for
     * @return the found BibliographyProduct object or null if no product is found
     */
    public BibliographyProduct searchProducts(String name, String id) {
        BibliographyProduct productSearch = null;
        for (BibliographyProduct product : produtcs) {
            if(product.getName().equalsIgnoreCase(name) || (product.getId().equalsIgnoreCase(id))){
                productSearch = product;
            }
        }
        return productSearch;
    }/**
     * Generates a random user with free membership.
     *
     * @return the information about the generated user and their additional details
     */
    public String generateRandomUsersFree (){
        String name = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String email = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)] + "@hotmail.com";
        int typeId = random.nextInt(3) + 1;
        int id = random.nextInt(900000000) + 100000000;
        String message;

        User free = searchUser(typeId, name);
        TypeID idCard;
        switch (typeId) {
            case 1:
                idCard = TypeID.CITIZENSHIPCARD;
                break;
            case 2:
                idCard = TypeID.IDENTITYCARD;
                break;
            case 3:
                idCard = TypeID.PASSPORT;
                break;
            default:
                idCard = null;
                break;
        }
        if(free != null){
            message = "The user already create";
        } else {
            User userFree = new UserFree(name, idCard, id, dateRegister, email);
            users.add(userFree);
            message = userFree.toString();
            }
        String adds = generateAdds(id);
        return message + "\n" + adds;
    }
    /**
     * Generates a random user with premium membership.
     *
     * @return the message indicating the success of user creation and payment details
     */
    public String generateRandomUsersPremium (){
        StringBuilder chain = new StringBuilder();
        String name = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String email = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)] + "@hotmail.com";
        String avatar = "GenericAvatarRandom.jpg";
        int typeId = random.nextInt(3) + 1;
        int id = random.nextInt(900000000) + 100000000;

        //Genera de forma random el numero de tarjeta de credito de forma aleatoria
        String caracteres = "1234567890";
        String creditCard  ="";
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(caracteres.length());
            char randomCharacter = caracteres.charAt(index);
            chain.append(randomCharacter);
            creditCard = chain.toString();
        }
        String message = "";
        User premium = searchUser(id,name);
        TypeID idCard;
        switch (typeId) {
            case 1:
                idCard = TypeID.CITIZENSHIPCARD;
                break;
            case 2:
                idCard = TypeID.IDENTITYCARD;
                break;
            case 3:
                idCard = TypeID.PASSPORT;
                break;
            default:
                idCard = null;
                break;
        }
        if(premium != null){
            message = "The user already create";
        } else {
            User userPremium = new UserPremium(name, idCard, id, dateRegister, email, creditCard, avatar);
            users.add(userPremium);
        }
        String messagepay = generatePay(id);
        return message + "\n" + "\n" + messagepay;
    }
    /**
     * Generates a random book and adds it to the product database.
     *
     * @return the message indicating the success of book addition
     */
    public String generateRandomBook(){
        String message;
        String bookName = NAME_BOOKS[random.nextInt(NAME_BOOKS.length)];
        String id = generateID();
        BibliographyProduct book = searchProducts(bookName, id);
        int numPages = random.nextInt(500) + 50;
        int value = random.nextInt(800) + 50;
        int numSales = random.nextInt(10000000) + 50;
        int gender = random.nextInt(3) + 1;
        String review = "Good book";
        String frontPage = "genericFrontpage.com";

        TypeGender genderType;
        switch (gender) {
            case 1:
                genderType = TypeGender.SCIENCIE_FICTICCION;
                break;
            case 2:
                genderType = TypeGender.FANCY;
                break;
            case 3:
                genderType = TypeGender.HISTORICAL_NOVEL;
                break;
            default:
                genderType = null;
                break;
        }
        if(book != null){
            message = "TRY AGAIN. The book already exist in the database.";
        } else {
            BibliographyProduct newBook = new Book(bookName, date,  numPages,  review,  value,  id, genderType, frontPage, numSales);
            produtcs.add(newBook);
            message = "The book has been added succesfully" + newBook;
        }
        return message;
    }
    /**
     * Generates a random magazine and adds it to the product database.
     *
     * @return the message indicating the success of magazine addition
     */
    public String generateRandomMagazine(){
        String message;
        String magazineName = NAME_MAGAZINES[random.nextInt(NAME_MAGAZINES.length)];

        BibliographyProduct magazine = searchProducts(magazineName, generateID());
        int numPages = random.nextInt(80) + 10;
        int value = random.nextInt(90) + 10;
        int option = random.nextInt(4) + 1;
        int activeSubscriptions = random.nextInt(100000) + 10;

        TypePerodicity periodicity;
        switch (option) {
            case 1:
                periodicity = TypePerodicity.DAILY;
                break;
            case 2:
                periodicity = TypePerodicity.WEEKLY;
                break;
            case 3:
                periodicity = TypePerodicity.MONTHLY;
                break;
            case 4:
                periodicity = TypePerodicity.YEARLY;
                break;
            default:
                periodicity = null;
                break;
        }
        TypeMagazine category;
        switch (option) {
            case 1:
                category = TypeMagazine.SCIENCIE;
                break;
            case 2:
                category = TypeMagazine.DESIGN;
                break;
            case 3:
                category = TypeMagazine.VARIETIES;
                break;
            default:
                category = null;
                break;
        }
        if(magazine != null){
            message = "TRY AGAIN. The magazine already exist in the database.";
        } else {
            BibliographyProduct magazines = new Magazine( magazineName,  date,  numPages,  value,  generateID(), periodicity,  category, activeSubscriptions);
            produtcs.add(magazines);
            message = "Magazine register succesfuly. " + magazines;
        }
        return message;
    }
    /**
     * Generates a payment message for the user with the specified ID.
     *
     * @param id the ID of the user
     * @return the payment message for the user
     */
    public String generatePay(int id) {
        String message = "";
        for (User user: users) {
            if(user instanceof UserPremium && user.getId() == id){
                message = "Your payment has been registered successfully" + "\n" + ((UserPremium) user).generateMouthPay() + "\n";
            }
        }
        return message;
    }
    /**
     * Generates payment messages for all premium users.
     *
     * @return the concatenated payment messages for all premium users
     */
    public String generateAllPayments() {
        String message = "";
        for (User user: users) {
            if(user instanceof UserPremium){
                message += "Your payment has been registered successfully \n" + ((UserPremium) user).generateMouthPay() + "\n";
            }
        }
        return message;
    }
    /**
     * Generates adds messages for a specific user (regular-free).
     *
     * @param id the ID of the user
     * @return the generated additional message for the user
     */
    public String generateAdds(int id){
        String messageAdds = "";
        for (User user: users) {
            if(user instanceof UserFree && user.getId() == id && ((UserFree) user).getAdds()){
                messageAdds = ADDS[random.nextInt(ADDS.length)];
            }
        }
        return messageAdds;
    }
    /**
     * Retrieves the user with the highest number of critics.
     *
     * @return the message indicating the user with the highest number of critics
     */
    public String maxCritic () {
        String message = "";
        int max = 0;
        for(User user : users){
            if(user instanceof UserCritical){
                if( (((UserCritical) user).getCriticsCount()>max)){
                    max = ((UserCritical) user).getCriticsCount();
                    message = user.getName()+ " is the person with more critics";
                }
        }
    } 
        return message;
    }
    /**
     * Generates a surprise message for each user.
     *
     * @return the generated surprise messages for each user
     */
    public String surpriseGenerate(){
        Random random = new Random();
        String message = "";
        int mouthRandom = random.nextInt(12) + 1;
        String character = "abcdefghijklmnopqrstyxz";
        int numRandom = random.nextInt(10000) + 1000;

        char randomCharacter = '0';
            for (int i = 0; i < 10; i++) {
                int indice = random.nextInt(character.length());
                randomCharacter = Character.toLowerCase(character.charAt(indice));
            }
            for (User user : users) {
                message += user.surprise(mouthRandom, randomCharacter, numRandom) + "\n";
        }
        return message;
    }
    /**
     * Generates a string listing all the books in the product database.
     *
     * @return a string listing all the books
     */
    public String showBooks(){
        String message = "";
        int i = 0;
        for(BibliographyProduct product: produtcs){
            if(product instanceof Book){
                message += i + ". " + product.getName()+ " value: " + product.getValue() + "\n";
            }
            i++;
        }
        return message;
    }
    /**
     * Generates a string listing all the magazines in the product database.
     *
     * @return A string listing all the magazines.
     */
    public String showMagazines(){
        String message = "";
        int i = 0;
        for(BibliographyProduct product: produtcs){
            if(product instanceof Magazine){
                message += i + ". " + product.getName() + " value: " + product.getValue() + "\n";
            }
            i++;
        }
        return message;
    }
    /**
     * Buys a book for the specified user and adds it to their collection.
     *
     * @param j    The index of the book to be bought.
     * @param user   The user.
     * @return A message indicating the success of the purchase and the user to whom the book was added.
     */
    public String buyBook(int j, User user, String creditCard){
        String message = "";
        BibliographyProduct bookBuy;

        for(BibliographyProduct product: produtcs){
            if(product instanceof Book && user instanceof UserFree){
                generateAdds(user.getId());
                bookBuy = produtcs.get(j);
                ((UserFree) user).setCreditCard(creditCard);
                ((Book) product).setNumSales(((Book) product).getNumSales() + 1);
                message = user.addBook(bookBuy) + " was added succesfuly to userfree library: " + user.getName() + "\n"
                        + "\n Bill payment." + "\n The value book "+ bookBuy.getValue() + " Has charged to credit card: " + ((UserFree) user).getCreditCard() + "\n* Sales: " + ((Book) product).getNumSales();

            } else if (product instanceof Book && user instanceof UserPremium){
                bookBuy = produtcs.get(j);
                ((Book) product).setNumSales(((Book) product).getNumSales() + 1);
                message = user.addBook(bookBuy) + " was added succesfuly to userpremium library: " + user.getName() + "\n" +
                         "\n Bill payment." + "\n * The value book "+ bookBuy.getValue() + " Has charged to credit card: " + ((UserPremium) user).getCreditCard() + "\n* Sales: " + ((Book) product).getNumSales();
            }
        }
            return message;
    }
    /**
     * Subscribes a magazine for the specified user and adds it to their collection.
     *
     * @param j    The index of the magazine to be subscribed.
     * @param user The name of the user.
     * @return A message indicating the success of the subscription and the user to whom the magazine was added.
     */
    public String subscribeMagazine(int j, User user, String creditCard){
        String message = "";
        BibliographyProduct magazineSub;

        for(BibliographyProduct product: produtcs){
            if(product instanceof Magazine && user instanceof UserFree){
                magazineSub = produtcs.get(j);
                ((UserFree) user).setCreditCard(creditCard);
                ((Magazine) magazineSub).setActiveSubscriptions(((Magazine) magazineSub).getActiveSubscriptions()+1);
                message = user.addMagazine(magazineSub) + " was added succesfuly to userfree: " + user.getName() + "\n"
                        + "\n The value book "+ magazineSub.getValue() + " Has charged to credit card: " + ((UserFree) user).getCreditCard() +
                        "\n * Active subscriptions: " + ((Magazine) magazineSub).getActiveSubscriptions();
            } else if (product instanceof Magazine && user instanceof UserPremium){
                magazineSub = produtcs.get(j);
                ((Magazine) magazineSub).setActiveSubscriptions(((Magazine) magazineSub).getActiveSubscriptions()+1);
                message = user.addMagazine(magazineSub) + " was added succesfuly to userpremium: " + user.getName() + "\n" +
                        "\n Bill payment." +  "\n The subscription value "+ magazineSub.getValue() + " Has charged to credit card: " + ((UserPremium) user).getCreditCard() +
                        "\n * Active subscriptions: " + ((Magazine) magazineSub).getActiveSubscriptions();
            }
        }
        return message;
    }
}


