package net.wpd2_coursework_group10.view;


import net.wpd2_coursework_group10.controller.MessageBoard;
import net.wpd2_coursework_group10.model.Topic;

public class MessageBoardMenu {

    private Utility eventUtility;

    private boolean flag = false;

    private int currentTopicId;

    private char optChar;

    private MessageBoard messageBoard;

    public MessageBoardMenu() { this.messageBoard = new MessageBoard("Main Menu"); }

    public void displayMessageBoardMenu(){

        MessageBoardBanner("Main");

        MessageBoardMenuEvent();
    }

    private void MessageBoardBanner(String context) {

        System.out.println("--------------------------------");
        System.out.println("=== WELCOME TO MESSAGE BOARD ===");
        System.out.println("--------------------------------\n" +
                "    "+context+" Menu:");
    }



    public void help(){

        System.out.println("\n"+
                "1: List topics\n"+
                "2: Add topic\n" +
                "3: Select topic\n" +
                "4: Delete topic\n" +
                "5: Edit topic\n" +
                "6: Help\n" +
                "7: Quit\n");
    }

    private void MessageBoardMenuEvent(){

        help();

        this.eventUtility = new Utility();

        do {

            int option = eventUtility.readInt("root@localhost");

            switch (option) {

                case 1:
//                do...
                    if (this.messageBoard.getNumberOfTopics() == 0) {

                        System.out.println("No available topic to display!");

                    } else {

                        System.out.println("\nNO  TOPICS");
                        System.out.println("=============================================");
                        this.messageBoard.display();
                        System.out.println();
                    }

                    break;

                case 2:
//                do...

                    String title = this.eventUtility.readString("Enter title of the topic");

                    Topic myTopic = new Topic(title);

                    this.messageBoard.addTopics(myTopic);

                    break;

                case 3:
//                 do...

                    if (this.messageBoard.getNumberOfTopics() > 0) {

                        System.out.println("\nNO  TOPICS");
                        System.out.println("=============================================");
                        this.messageBoard.display();
                        System.out.println();

                        this.currentTopicId = this.eventUtility.readInt("Enter topic id number") - 1;

                        if (this.currentTopicId < 0 || this.currentTopicId > this.messageBoard.getNumberOfTopics()) {

                            System.out.println("Sorry message does not exist");
                        } else {

                            System.out.println("\n\n\n");

                            MessageBoardBanner("Topic");

                            System.out.println("\n    TOPIC SELECTED:\t" + this.messageBoard.getTopics(this.currentTopicId).getTopicDescription());

                            this.messageBoard.getTopics(this.currentTopicId).displayMessage();

                            TopicMenu topicMenu = new TopicMenu(this.currentTopicId, this.messageBoard.getTopics(this.currentTopicId));

                            topicMenu.displayTopicMenu();

                            System.out.println("\n\n");

                            MessageBoardBanner("Main");

                            help();

                        }

                    } else {

                        System.out.println("No topic is available");
                    }

                    break;

                case 4:
//                do...

                    if (this.messageBoard.getNumberOfTopics() > 0) {


                        System.out.println("Deleting a topic");

                        System.out.println("\nNO  TOPICS");
                        System.out.println("=============================================");
                        this.messageBoard.display();
                        System.out.println();

                        int removedTopic = this.eventUtility.readInt("Enter a topic id to be deleted") - 1;

                        if (removedTopic < 0 || removedTopic >= this.messageBoard.getNumberOfTopics()) {

                            System.out.println("Topic does not exist!");

                        } else {

                            optChar = this.eventUtility.readCharacter("Are you sure you want this topic to be deleted Y | n", "YyNn");

                            if (optChar == 'Y' || optChar == 'y') this.messageBoard.deleteTopic(removedTopic);

                        }

                    }else {

                        System.out.println("No topic is available");
                    }


                        break;

                case 5:
//                do...

                    if (this.messageBoard.getNumberOfTopics() > 0) {

                        System.out.println("Editing a topic");

                        System.out.println("\nNO  TOPICS");
                        System.out.println("=============================================");
                        this.messageBoard.display();
                        System.out.println();

                        int editedTopic = this.eventUtility.readInt("Enter a topic id to be edited")-1;

                        if (editedTopic < 0 || editedTopic >= this.messageBoard.getNumberOfTopics()){

                            System.out.println("Topic does not exist!");

                        }else{

                            String tempVal = this.eventUtility.readString("Update topic");

                            optChar = this.eventUtility.readCharacter("Save changes Y | n", "YyNn");

                            if (optChar == 'Y' || optChar == 'y') this.messageBoard.getTopics(editedTopic).setTopicDescription(tempVal);

                        }

                    }else {

                        System.out.println("No topic is available");
                    }


                    break;

                case 6:
//                do...

                    new MessageBoardMenu().help();
                    break;

                case 7:
//                do...
                    System.out.println("Exiting MessageBoard, Bye!");
                    this.flag = true;

                    break;
            }

        }while(!flag);

    }


}
