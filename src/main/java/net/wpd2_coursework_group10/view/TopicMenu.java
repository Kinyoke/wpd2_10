package net.wpd2_coursework_group10.view;




import net.wpd2_coursework_group10.model.Message;
import net.wpd2_coursework_group10.model.Topic;

import java.util.Date;

public class TopicMenu {


    private boolean isInstanceTopic = false;

    private Utility eventUtility;

    private int currentTopic;

    private Topic myTopic;

    Message myMessage;

    public TopicMenu(int currentTopic, Topic topic) { this.currentTopic = currentTopic; this.myTopic = topic; this.eventUtility = new Utility(); }

    public void displayTopicMenu(){

        topicMenuEvent();

    }

    public void help(){

        System.out.println(
                "\n"+
                "1: Post a new message\n" +
                "2: List all the message for this topic\n" +
                "3: Delete message\n" +
                "4: help\n" +
                "5: Return to the message board menu\n"
        );

    }


    private void topicMenuEvent(){

        help();

        do {

            int option = this.eventUtility.readInt("root@localhost");

            switch (option){

                case 1:

                    System.out.println("Posting a new message to the topic");

                    myMessage = new Message();

                    myMessage.setSubject(this.eventUtility.readString("Enter message subject"));

                    myMessage.setBody(this.eventUtility.readString("Enter message body"));

                    myMessage.setPostedtime(new Date());

                    this.myTopic.addMessage(myMessage);

                    break;

                case 2:

                    if (this.myTopic.getMessageCount() > 0) {

//                        for (int i = 0; i < this.myTopic.getMessageCount(); i++){

//                            System.out.println("\n    "+(i+1)+":  MESSAGE");

                            this.myTopic.displayMessage();

//                        }


                    }else{

                        char opt = this.eventUtility.readCharacter("No messages available, would you like to post a new message? Y | n", "YyNn");

                        switch (opt){

                            case 'Y':
                            case 'y':

                                myMessage = new Message();

                                myMessage.setSubject(this.eventUtility.readString("Enter message subject"));

                                myMessage.setBody(this.eventUtility.readString("Enter message body"));

                                myMessage.setPostedtime(new Date());

                                this.myTopic.addMessage(myMessage);

                                break;

                            case 'N':
                            case 'n':
                                break;
                        }

                    }

                    break;

                case 3:

                    if (this.myTopic.getMessageCount() > 0) {


                        this.myTopic.displayMessage();

                        int removeThis = this.eventUtility.readInt("Enter a message id number") - 1;

                        if (removeThis < 0 || removeThis > this.myTopic.getMessageCount()) {

                            System.out.println("Message does not exist!");

                        }else{

                            char response = this.eventUtility.readCharacter("Are you sure you want to delete this message Y | n", "YyNn");

                            if (response == 'Y' || response == 'y') this.myTopic.deleteMessage(removeThis);
                        }

                    }else{

                        System.out.println("It seems like there are no available messages!");
                    }

                        break;

                case 4:

                    help();

                    break;

                case 5:

                    isInstanceTopic = true;

                    System.out.println("Exiting topic!");

                    break;

            }

        }while (!isInstanceTopic);


    }




}
