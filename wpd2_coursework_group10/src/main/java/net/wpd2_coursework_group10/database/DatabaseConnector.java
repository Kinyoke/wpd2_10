package net.wpd2_coursework_group10.database;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import net.wpd2_coursework_group10.model.AccountLog;
import net.wpd2_coursework_group10.model.Milestone;
import net.wpd2_coursework_group10.model.User;
import org.bson.Document;

import java.awt.peer.SystemTrayPeer;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
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
        String[] myCollection = {"Account", "Milestones", "AccountLogs"};
        for (String name : database.listCollectionNames()) {
            if (name.equals(myCollection[pointer])){
                myCollection[pointer] = null;
                pointer++;
            }
        }

        if (pointer < myCollection.length-1) for (String s : myCollection) if (s != null) database.createCollection(s);

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

    public boolean insertMilestone(Milestone milestone, String userEmail, String description){
        // Retrieving a collection
        System.out.println("Selecting a collection Milestone...");
        collections = database.getCollection("Milestones");
        MongoCursor<Document> cursor = collections.find(eq("user", userEmail)).iterator();
        try{
            while (cursor.hasNext()){
                Document cursorData = cursor.next();
                if (cursorData.get("Description").equals(description)) return false;
            }
        }finally {
            cursor.close();
        }
        int id = getCollectionCount("Milestones", "user", userEmail);
        id+=1;
        Document document = new Document().append("milestoneId", id).append("Author", milestone.getAuthor()).append("Description", milestone.getDescription()).append("dueDate", milestone.getDueDate()).append("actualCompDate", milestone.getActualCompletionDate()).append("user", milestone.getUser()).append("status", "pending");
        System.out.println("Inserting document into a collection...");
        // insert into a collection
        collections.insertOne(document);
        System.out.println("Document inserted successfully");

        return true;
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

    public int getCollectionCount(String collectionName){ return (int) database.getCollection(collectionName).countDocuments(); }

    public int getCollectionCount(String collectionName, String fieldName, String value){
        collections = database.getCollection(collectionName);
        collections.find(eq(fieldName, value));
        collections.countDocuments();
        return (int) collections.countDocuments();
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


    public String[] getUserNames(String email){
        String[] names = new String[3];
        collections = database.getCollection("Account");
        MongoCursor<Document> cursor = collections.find(eq("emailAddress", email)).iterator();
        try {
            while (cursor.hasNext()) {
                Document cdata = cursor.next();
                names[0] = cdata.get("firstName").toString();
                names[1] = cdata.get("middleName").toString();
            }
        }finally {
            cursor.close();
        }
        return names;
    }

    public boolean isLogged(String email) {
        collections = database.getCollection("AccountLogs");
        cursor = collections.find(eq("userAccount", email)).iterator();
        if (cursor.hasNext()){
            try {
                while (cursor.hasNext()) {
                    Document doc = cursor.next();
                    if (doc.get("status").equals("ACTIVE")){
                        cursor.close();
                        return true; // already looged in
                    }
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


    public Milestone getMilestone(String userEmail, int id){
        Milestone milestone = new Milestone();
        collections = database.getCollection("Milestones");
        MongoCursor<Document> cursor = collections.find(eq("user", userEmail)).iterator();
        try{
            while (cursor.hasNext()){
                Document cursorData = cursor.next();
                if (cursorData.getInteger("milestoneId") == id){
                    milestone.setMilestoneId(cursorData.getInteger("milestoneId"));
                    milestone.setAuthor(cursorData.getString("Author"));
                    milestone.setUser(cursorData.getString("user"));
                    milestone.setDueDate(cursorData.getString("dueDate"));
                    milestone.setActualCompletionDate(cursorData.getString("actualCompDate"));
                    milestone.setDescription(cursorData.getString("Description"));
                    milestone.setStatus(cursorData.getString("status"));
                    break;
                }
            }
        }finally {
            cursor.close();
        }

        return milestone;
    }

    public void updateId(String collectionName, String user){
        collections = database.getCollection(collectionName);
        MongoCursor<Document> cursor = collections.find(eq("user", user)).iterator();
        int i = 1;
        try {
            int colLength = getCollectionCount(collectionName, "user", user);
            while (cursor.hasNext()){
                int mid = cursor.next().getInteger("milestoneId");
                collections.updateOne(Filters.eq("milestoneId", mid), Updates.set("milestoneId", (i)));
                i++;
            }
        }finally {
            cursor.close();
        }
    }

    public void deleteMilestone(String user, int id){
        collections = database.getCollection("Milestones");
        collections.find(eq("user", user));
        collections.deleteOne(Filters.eq("milestoneId", id));
        updateId("Milestones", user);
    }

    public void updateMilestone(Milestone milestone, String user, int id){
        collections = database.getCollection("Milestones");
        MongoCursor<Document> cursor = collections.find(eq("user", user)).iterator();
        try {
            while (cursor.hasNext()){
                Document cursorData = cursor.next();
                if (cursorData.getInteger("milestoneId") == milestone.getMilestoneId()) {
                    String descr = cursorData.getString("Description");
                    String dueDate = cursorData.getString("dueDate");
                    String actComplitionDate = cursorData.getString("actualCompDate");
                    String status = cursorData.getString("status");
                    collections.updateOne(Filters.eq("Description", descr), Updates.set("Description", milestone.getDescription()));
                    collections.updateOne(Filters.eq("dueDate", dueDate), Updates.set("dueDate", milestone.getDueDate()));
                    collections.updateOne(Filters.eq("actualCompDate", actComplitionDate), Updates.set("actualCompDate", milestone.getActualCompletionDate()));
                    collections.updateOne(Filters.eq("status", status), Updates.set("status", milestone.getStatus()));
                }
            }
        }finally {
            cursor.close();
        }

    }

    public List<Milestone> getMilestoneList(String userEmail){
        Milestone milestone = null;
        List<Milestone> milestoneList = new ArrayList<Milestone>();
        collections = database.getCollection("Milestones");
        MongoCursor<Document> cursor = collections.find(eq("user", userEmail)).iterator();
        try{
            while (cursor.hasNext()){
                Document cursorData = cursor.next();
                milestone = new Milestone();
                milestone.setMilestoneId(cursorData.getInteger("milestoneId"));
                milestone.setAuthor(cursorData.getString("Author"));
                milestone.setUser(cursorData.getString("user"));
                milestone.setDueDate(cursorData.getString("dueDate"));
                milestone.setActualCompletionDate(cursorData.getString("actualCompDate"));
                milestone.setDescription(cursorData.getString("Description"));
                milestone.setStatus(cursorData.getString("status"));
                milestoneList.add(milestone);
            }
        }finally {
            cursor.close();
        }

        return milestoneList;
    }

    public String getSessionId(String email) {
//        if (isLogged(email)){
            collections = database.getCollection("AccountLogs");
            cursor = collections.find(eq("userAccount", email)).iterator();
            try {
                while (cursor.hasNext()) {
                    Document ncursor =  cursor.next();
                    if (ncursor.get("status").equals("ACTIVE")) return ncursor.get("session").toString();

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
            collections.find(eq("userAccount", email));
            collections.updateOne(eq("status", "ACTIVE"), set("status","INACTIVE"));
        }

    }


}
