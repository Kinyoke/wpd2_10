package net.wpd2_coursework_group10.ADT;



public interface MilestoneListInterface<E> {

    /**
     * @param e, takes in a object of type E
     */
    public void insert(E e);

    /**
     * @param id, takes an argument of type String
     */
    public boolean remove(int id);

    /**
     * @param milestoneDescription, takes in an argument of type String
     */
    public E search(String milestoneDescription);


    /**
     * @param milestoneID, takes in an argument of type int
     */
    public E search(int milestoneID);

    /**
     * @return a boolean object representing if the list is empty or not
     */
    public boolean isEmpty();

    /**
     *@return an integer object representing the length of items in the list
     */
    public int length();

}

