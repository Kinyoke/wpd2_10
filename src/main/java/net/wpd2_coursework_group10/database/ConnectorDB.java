package net.wpd2_coursework_group10.database;



import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import org.bson.Document;


public class ConnectorDB {


    private static String username = "group10@wpd2";

    private static String password_s = "Th3f1v3guys";

    private static char[] password = password_s.toCharArray();

    private static String host = "172.17.2.16";

    private static int port_no = 27017;

    private static String myDatabase = "Planner";


    public void setUsername(String username) { this.username = username; }

    public void setPassword_s(String password_s) { this.password_s = password_s; }

    public void setHost(String host) { this.host = host; }

    public void setPort_no(int port_no) { this.port_no = port_no; }

    public static void main(String args[] ) {

        // Creating a Mongo client
        MongoClient mongo = new MongoClient( host , port_no );

        // Creating Credentials
        MongoCredential credential;
        credential = MongoCredential.createCredential(username, myDatabase, password);
        System.out.println("Connected to the database successfully");

        // Accessing the database
        MongoDatabase database = mongo.getDatabase(myDatabase);
        System.out.println("Credentials ::"+ credential);



        //Creating a collection
        database.createCollection("Milestone");
        System.out.println("Collection created successfully");


        // Retieving a collection
        MongoCollection<Document> collection = database.getCollection("Milestone");
        System.out.println("Collection Milestone selected successfully");


//        // Creating a Mongo client
//        MongoClient mongo = new MongoClient( "localhost" , 27017 );
//
//        // Creating Credentials
//        MongoCredential credential;
//        credential = MongoCredential.createCredential("sampleUser", "myDb",
//                "password".toCharArray());
//        System.out.println("Connected to the database successfully");
//
//        // Accessing the database
//        MongoDatabase database = mongo.getDatabase("myDb");
//
//        // Retrieving a collection
//        MongoCollection<Document> collection = database.getCollection("sampleCollection");
//        System.out.println("Collection sampleCollection selected successfully");
//
//        Document document = new Document("title", "MongoDB")
//                .append("id", 1)
//                .append("description", "database")
//                .append("likes", 100)
//                .append("url", "http://www.tutorialspoint.com/mongodb/")
//                .append("by", "tutorials point");
//        collection.insertOne(document);
//        System.out.println("Document inserted successfully");


//        // Creating a Mongo client
//        MongoClient mongo = new MongoClient( "localhost" , 27017 );
//
//        // Creating Credentials
//        MongoCredential credential;
//        credential = MongoCredential.createCredential("sampleUser", "myDb",
//                "password".toCharArray());
//        System.out.println("Connected to the database successfully");
//
//        // Accessing the database
//        MongoDatabase database = mongo.getDatabase("myDb");
//
//        // Retrieving a collection
//        MongoCollection<Document> collection = database.getCollection("sampleCollection");
//        System.out.println("Collection sampleCollection selected successfully");
//
//        // Getting the iterable object
//        FindIterable<Document> iterDoc = collection.find();
//        int i = 1;
//
//        // Getting the iterator
//        Iterator it = iterDoc.iterator();
//
//        while (it.hasNext()) {
//            System.out.println(it.next());
//            i++;
//        }





//        // Creating a Mongo client
//        MongoClient mongo = new MongoClient( "localhost" , 27017 );
//
//        // Creating Credentials
//        MongoCredential credential;
//        credential = MongoCredential.createCredential("sampleUser", "myDb",
//                "password".toCharArray());
//        System.out.println("Connected to the database successfully");
//
//        // Accessing the database
//        MongoDatabase database = mongo.getDatabase("myDb");
//
//        // Retrieving a collection
//        MongoCollection<Document> collection = database.getCollection("sampleCollection");
//        System.out.println("Collection myCollection selected successfully");
//
//        collection.updateOne(Filters.eq("id", 1), Updates.set("likes", 150));
//        System.out.println("Document update successfully...");
//
//        // Retrieving the documents after updation
//        // Getting the iterable object
//        FindIterable<Document> iterDoc = collection.find();
//        int i = 1;
//
//        // Getting the iterator
//        Iterator it = iterDoc.iterator();
//
//        while (it.hasNext()) {
//            System.out.println(it.next());
//            i++;
//        }



        // Creating a Mongo client
//        MongoClient mongo = new MongoClient( "localhost" , 27017 );
//
//        // Creating Credentials
//        MongoCredential credential;
//        credential = MongoCredential.createCredential("sampleUser", "myDb",
//                "password".toCharArray());
//        System.out.println("Connected to the database successfully");
//
//        // Accessing the database
//        MongoDatabase database = mongo.getDatabase("myDb");
//
//        // Retrieving a collection
//        MongoCollection<Document> collection = database.getCollection("sampleCollection");
//        System.out.println("Collection sampleCollection selected successfully");
//
//        // Deleting the documents
//        collection.deleteOne(Filters.eq("id", 1));
//        System.out.println("Document deleted successfully...");
//
//        // Retrieving the documents after updation
//        // Getting the iterable object
//        FindIterable<Document> iterDoc = collection.find();
//        int i = 1;
//
//        // Getting the iterator
//        Iterator it = iterDoc.iterator();
//
//        while (it.hasNext()) {
//            System.out.println("Inserted Document: "+i);
//            System.out.println(it.next());
//            i++;
//        }




//        // Creating a Mongo client
//        MongoClient mongo = new MongoClient( "localhost" , 27017 );
//
//        // Creating Credentials
//        MongoCredential credential;
//        credential = MongoCredential.createCredential("sampleUser", "myDb",
//                "password".toCharArray());
//        System.out.println("Connected to the database successfully");
//
//        // Accessing the database
//        MongoDatabase database = mongo.getDatabase("myDb");
//
//        // Creating a collection
//        System.out.println("Collections created successfully");
//
//        // Retieving a collection
//        MongoCollection<Document> collection = database.getCollection("sampleCollection");
//
//        // Dropping a Collection
//        collection.drop();
//        System.out.println("Collection dropped successfully");





//        // Creating a Mongo client
//        MongoClient mongo = new MongoClient( "localhost" , 27017 );
//
//        // Creating Credentials
//        MongoCredential credential;
//        credential = MongoCredential.createCredential("sampleUser", "myDb",
//                "password".toCharArray());
//
//        System.out.println("Connected to the database successfully");
//
//        // Accessing the database
//        MongoDatabase database = mongo.getDatabase("myDb");
//        System.out.println("Collection created successfully");
//        for (String name : database.listCollectionNames()) {
//            System.out.println(name);
//        }



    }
}
