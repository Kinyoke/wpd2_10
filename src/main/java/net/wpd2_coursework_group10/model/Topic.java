package net.wpd2_coursework_group10.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Topic {

    //declare a collection storage for storing messages
    private ArrayList<Message> messages;

    //declare and instantiate a topic description
    private String topicDescription = null;

    //create a constructor to initialize the message array
    public Topic(String topicDescription) {

        this.topicDescription = topicDescription;

        this.messages = new ArrayList<>();
    }

    /**
     * @param topicDescription , takes a string argument as a new value of the topic description.
     */
    public void setTopicDescription(String topicDescription){ this.topicDescription = topicDescription; }

    /**
     * @return , returns the current existing value from the topicDescription.
     */
    public String getTopicDescription() { return this.topicDescription; }

    /**
     * @param message , takes a message object as an argument representing a new message
     */
    public void addMessage(Message message){ this.messages.add(message); }

    /**
     * @param index , takes an integer as an argument representing a position of the message to be returned
     * @return , return a message object represented by the given position.
     */
    public Message getMessage(int index) { return this.messages.get(index); }

    /**
     * @param index , takes an integer argument that represents a position where to remove a message from
     */
    public void deleteMessage(int index) { this.messages.remove(index); }

    /**
     * @return , returns the count of all elements existing in the messages collection
     */
    public int getMessageCount() { return this.messages.size(); }


    public void displayMessage(){

        String messageContent = "";

        for (int i = 0; i < getMessageCount(); i++){

            messageContent += "        Subject: "+this.getMessage(i).getSubject()+"\n";

            messageContent += "        Body: "+this.getMessage(i).getBody()+"\n";

            DateFormat dateFormat = new SimpleDateFormat("dd / mm / yyyy hh:mm a");

            messageContent += "        Sent: "+dateFormat.format(this.getMessage(i).getPostedtime());

            System.out.println();

            System.out.println(String.format("    %d:  %s", (i+1), "MESSAGE"));

            System.out.println(messageContent+"\n");

            messageContent = "";

        }

    }


}
