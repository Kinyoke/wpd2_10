package net.wpd2_coursework_group10.database;


import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import net.wpd2_coursework_group10.model.AccountLog;
import net.wpd2_coursework_group10.model.Milestone;
import net.wpd2_coursework_group10.model.User;
import org.bson.Document;

import javax.json.stream.JsonGenerationException;
import java.io.IOException;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.Updates.set;

public class DatabaseConnector implements DAOinterface{


    private static String username = "root";

    private static String password = "";

    private static String host = "localhost";

    private static int port_no = 27017;

    private MongoClient mongo;

    private MongoDatabase database;

    private MongoCollection<Document> collections;

    private static final String myDatabase = "Milestone";

    private MongoCursor<Document> cursor;


    //    constructor bellow
    public DatabaseConnector(){ run(); }

    public void setUsername(String username) { this.username = username; }

    public void setPassword_s(String password) { this.password = password; }

    public void setHost(String host) { this.host = host; }

    public void setPort_no(int port_no) { this.port_no = port_no; }

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
        Document document = new Document().append("firstName", account.getFirstName()).append("middleName", account.getMiddleName()).append("lastName", account.getLastName()).append("emailAddress", account.getEmailAddres()).append("password", account.getPassword());
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


    private void run(){ initConnection(); createCollection(); }

    public int getCollectionCount(String collectionName){

        return (int) database.getCollection(collectionName).count();
    }


    public int varifyUser(String email, String password) {
        AccountLog accountLog = new AccountLog();
        collections = database.getCollection("Account");
        MongoCursor<Document> cursor = collections.find(eq("emailAddress", email)).iterator();
        if (!cursor.hasNext()) {
            cursor.close();
            return 0; // account do not exist
        }
        else{
            try {
                while (cursor.hasNext()){
                    if (cursor.next().get("password").equals(password)) {
                        collections = database.getCollection("AccountLogs");
                        cursor = collections.find(eq("userAccount", email)).iterator();
                        if (cursor.hasNext()){
                            try {
                                while (cursor.hasNext()) if (cursor.next().get("status").equals("ACTIVE")) {
                                    cursor.close();
                                    return 2; // already looged in
                                }
                                accountLog.setUserAccount(email);
                                accountLog.setLoginTime();
                                accountLog.setSession(email+accountLog.getLoginTime());
                                accountLog.setStatus("ACTIVE");
                                insertLogs(accountLog);
                                return 1; // logged in successfully.
                            }finally {
                                cursor.close();
                            }
                        }else{
                            accountLog.setUserAccount(email);
                            accountLog.setLoginTime();
                            accountLog.setSession(email+" "+password+" "+accountLog.getLoginTime());
                            accountLog.setStatus("ACTIVE");
                            insertLogs(accountLog);
                            return 1; // looged in successfully
                        }
                    }else{
                        return 3; // wrong password
                    }
                }
            }finally {
                cursor.close();
            }
        }
        return 0;
    }

    public boolean isLogged(String email) {
        collections = database.getCollection("AccountLogs");
        cursor = collections.find(eq("userAccount", email)).iterator();
        if (cursor.hasNext()){
            try {
                while (cursor.hasNext()) if (cursor.next().get("status").equals("ACTIVE")){
                    cursor.close();
                    return true; // already looged in
                }
                return false;
            }finally {
                cursor.close();
            }

        }

        return false;
    }

    public AccountLog getLog(String email) {
//        if (isLogged(email)){
            collections = database.getCollection("AccountLogs");
            cursor = collections.find(eq("userAccount", email)).iterator(); // projection(excludeId())
            try {
                while (cursor.hasNext()){
                    Document cursortmp = cursor.next();
                    if (cursortmp.get("status").equals("ACTIVE")){
                        AccountLog accountLog = new AccountLog();// mapper.readValue(cursortmp.toJson(), AccountLog.class);
                        accountLog.setUserAccount(cursortmp.getString("userAccount"));
                        accountLog.setLoginTime(cursortmp.getString("LoginTime"));
                        accountLog.setSession(cursortmp.getString("session"));
                        accountLog.setStatus(cursortmp.getString("status"));
                        return accountLog;
                    }
                }
            }finally {
                cursor.close();
            }
//        }
        return null;
    }

    public List<AccountLog> getLogList(String email) {
        return null;
    }

    public boolean createUserAccount(User user) {
        collections = database.getCollection("Account");
        cursor = collections.find(eq("emailAddress", user.getEmailAddres())).iterator();
        if (!cursor.hasNext()){
            insertAccount(user);
            return true;
        }
        return  false;
    }

    public String getSessionId(String email) {
//        if (isLogged(email)){
            collections = database.getCollection("AccountLogs");
            cursor = collections.find(eq("userAccount", email)).iterator();
            try {
                while (cursor.hasNext()) {
                    Document ncursor =  cursor.next();
                    if (ncursor.get("status").equals("ACTIVE")) {
                        String val = ncursor.get("session").toString();
                        return val;
                    }
                }
            }finally {
                cursor.close();
            }
//            }
        return  "";
    }

    public void resetAccPassword(String email) { }

    public void updateLogStatus(String email, String session) {
        if (isLogged(email)){
            collections = database.getCollection("AccountLogs");
            collections.updateOne(eq("userAccount", email), set("status","INACTIVE"));
        }

    }


}
