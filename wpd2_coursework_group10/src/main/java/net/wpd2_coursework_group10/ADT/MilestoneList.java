package net.wpd2_coursework_group10.ADT;


import net.wpd2_coursework_group10.model.Milestone;

public class MilestoneList implements MilestoneListInterface<Milestone> {

    // declare field variables
    private Node<Milestone> HEAD, TAIL;

    private int length;

    /**
     *create a constructor of type ContactList
     */
    public MilestoneList() { HEAD = null; TAIL = null; length = 0; }
    /**
     * @return HEAD, returns a Node object of type Student representing the value of head
     */
    public Node<Milestone> getHead() { return HEAD; }

    /**
     * @param HEAD, takes a Node as an argument of type Student representing the value to be set as head
     */
    public void setHead(Node<Milestone> HEAD) { this.HEAD = HEAD; }

    /**
     * @return NEXT_NODE, returns a Node object of type Student representing the value of tail node
     */
    public Node<Milestone> getTailNode() { return TAIL; }

    /**
     * @param TAIL, takes a Node object of type Student representing the value to be set as next node
     */
    public void setNextNode(Node<Milestone> TAIL) { this.TAIL = TAIL; }

    /**
     * @param student, takes an argument of type Student representing the value to be set as data in the node element.
     * method inserts a new Student and hence increase the length
     */

    public void insert(Milestone student) {

        Node<Milestone> temp = new Node<Milestone>(student);

        if (isEmpty())
        {
            temp.setNext(temp);
            temp.setPrevious(temp);
            this.setHead(temp);
            this.setNextNode(this.getHead());
        }
        else
        {
            temp.setPrevious(this.getTailNode());
            this.getTailNode().setNext(temp);
            this.getHead().setPrevious(temp);
            temp.setNext(this.getHead());
            this.setHead(temp);
        }

        length++;

    }

    /**
     * @param id, takes an argument of type string that represents student name or student id to be removed
     * from the list.
     * @return false, returns false if there is no student object to be removed
     */


    public boolean remove(int id) {

        if(!isEmpty())
        {

            for(int i = 0; i < this.length(); i++)
            {
                if(this.HEAD.getData().getId() == id) {
                    System.out.println("[INFO] -> Removing Milestone "+this.getHead().getData().getDescription());
                    this.getHead().getPrevious().setNext(getHead().getNext());
                    this.getHead().getNext().setPrevious(getHead().getPrevious());
                    this.setHead(this.getHead().getNext());
                    length--;
                    return true;
                }

                this.setHead(this.getHead().getNext());
            }
        }

        return false;
    }

    /**
     * @param milestoneID, takes an int argument representing a student id to be returned from the list.
     * @return, return a student object
     */


    public Milestone search(int milestoneID) {
        for(int i = 0; i < this.length; i++) {
            if(this.HEAD.getData().getId() == milestoneID) { return this.getHead().getData(); }
            this.setHead(HEAD.getNext());

        }
        return new Milestone();
    }

    /**
     * @param milestoneDescription, takes a string argument that represents a student name to be retrieved.
     * @return, returns an object of type Student
     */


    public Milestone search(String milestoneDescription) {
        for(int i = 0; i < this.length; i++) {
            if(this.HEAD.getData().getDescription().equals(milestoneDescription)) { return this.getHead().getData(); }
            this.setHead(HEAD.getNext());

        }
        return new Milestone();
    }

    /**
     * @return, returns a boolean object that represents if the list is empty
     */


    public boolean isEmpty() {
        return (this.length == 0);
    }

    /**
     * @return, returns an int value representing a the length of the list
     */


    public int length() {
        return this.length;
    }

    // displays the contents from the MilestoneList to the screen

    public void display() {

        float average = 03f;
        int totalMarks = 0;

        for (int i = 0; i < length; i++){

            System.out.println(

                            "Milestone ID: "+this.HEAD.getData().getId()+"\n" +
                            "Milestone Description: "+this.HEAD.getData().getDescription()+"\n" +
                            "Milestone Author: "+this.HEAD.getData().getAuthor()+"\n"+
                            "Milestone Duedate: "+this.HEAD.getData().getDueDate()+"\n" +
                            "Milestone Actual completion date: "+this.HEAD.getData().getActualCompletionDate()+"\n" +
                            "Milestone status: "+this.HEAD.getData().getStatus()+"\n"

            );

            this.setHead(this.getHead().getNext());

        }


    }
}
