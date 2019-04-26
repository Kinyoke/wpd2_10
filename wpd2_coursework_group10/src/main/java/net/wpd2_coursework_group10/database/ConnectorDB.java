package net.wpd2_coursework_group10.database;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import net.wpd2_coursework_group10.model.AccountLog;
import net.wpd2_coursework_group10.model.Milestone;
import net.wpd2_coursework_group10.model.User;
import org.bson.Document;

public class ConnectorDB {


    private static String username = "root";

    private static String password = "";

    private static String host = "localhost";

    private static int port_no = 27017;

    private MongoClient mongo;

    private MongoDatabase database;

    private MongoCollection<Document> collections;

    private static final String myDatabase = "Milestone";



    public void setUsername(String username) { this.username = username; }

    public void setPassword_s(String password) { this.password = password; }

    public void setHost(String host) { this.host = host; }

    public void setPort_no(int port_no) { this.port_no = port_no; }


    private class databaseAccess {


        private void initConnection(){
            // Creating a Mongo client
            mongo = new MongoClient(host , port_no);

            // Creating Credentials
            MongoCredential credential;
            credential = MongoCredential.createCredential(username, myDatabase, password.toCharArray());
            System.out.println("Connected to the database successfully");

            // Accessing the database
            database = mongo.getDatabase(myDatabase);
            System.out.println("Credentials ::"+ credential);

        }


        public void createCollection(){
            // Retieving and creating a collection if not available
            System.out.println("Creating collection...");
            int pointer = 0;
            String myCollection[] = {"Account", "Milestones", "AccountLogs"};
            for (String name : database.listCollectionNames()) {
                if (name.equals(myCollection[pointer])){
                    myCollection[pointer] = null;
                    pointer++;
                }
            }

            if (pointer < myCollection.length-1){

                for (int j = 0; j < myCollection.length; j++) {

                    if (!myCollection[j].equals(null)) database.createCollection(myCollection[j]);

                }
            }

            System.out.println("Collection created successfully");
        }


        // insert ops

        public void insertAccount(User account){
            // Retrieving a collection
            System.out.println("Selecting a collection Account...");
            collections = database.getCollection("Account");
            Document document = new Document().append("firstName", account.getFirstName()).append("middleName", account.getMiddleName()).append("lastName", account.getLastName()).append("email", account.getEmailAddres()).append("password", account.getPassword());
            System.out.println("Inserting document into a collection...");
            // insert into a collection
            collections.insertOne(document);
            System.out.println("Document inserted successfully");
        }

        public void insertMilestone(Milestone milestone){
            // Retrieving a collection
            System.out.println("Selecting a collection Milestone...");
            collections = database.getCollection("Milestones");
            Document document = new Document().append("Author", milestone.getAuthor()).append("Description", milestone.getDescription()).append("dueDate", milestone.getDueDate()).append("actualCompDate", milestone.getActualCompletionDate()).append("user", milestone.getUser()).append("status", milestone.getStatus());
            System.out.println("Inserting document into a collection...");
            // insert into a collection
            collections.insertOne(document);
            System.out.println("Document inserted successfully");
        }

        public void insertLogs(AccountLog accountLog){
            // retrieving a collection
            System.out.println("Selecting a collection AccountLog...");
            collections = database.getCollection("AccountLogs");
            Document document = new Document().append("userAccount", accountLog.getUserAccount()).append("LoginTime", accountLog.getLoginTime()).append("session", accountLog.getSession()).append("status", accountLog.getStatus());
            System.out.println("Inserting document into a collection...");
            // insert into a collection
            collections.insertOne(document);
            System.out.println("Document inserted successfully");
        }

        // update

        // delete

        // search






    }

    private void run(){
        databaseAccess dao = new databaseAccess();
        dao.initConnection();
        dao.createCollection();

        User user = new User();
        user.setFullName("Faisal Burhan Abdu");
        user.setEmailAddres("manisman@gmail.com");
        user.setPassword("secrete_word");

        Milestone milestone = new Milestone();
        milestone.setAuthor(user.getFirstName()+" "+user.getLastName());
        milestone.setUser(user.getEmailAddres());
        milestone.setDescription("WPD2 is awesome");
        milestone.setDueDate("2019 - 04 - 24");
        milestone.setActualCompletionDate("2019 - 04 - 24");
        milestone.setStatus("pending");

        AccountLog accountLog = new AccountLog();
        accountLog.setUserAccount(user.getEmailAddres());
        accountLog.setLoginTime();
        accountLog.setSession(user.getEmailAddres()+" "+user.getPassword()+" "+accountLog.getLoginTime());
        accountLog.setStatus("ACTIVE");

        dao.insertAccount(user);
        dao.insertMilestone(milestone);
        dao.insertLogs(accountLog);
    }


    public static void main(String args[]){
        ConnectorDB myDatabase = new ConnectorDB();
        myDatabase.run();
    }



}
