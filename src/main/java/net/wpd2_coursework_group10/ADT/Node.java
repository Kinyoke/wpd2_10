package net.wpd2_coursework_group10.ADT;


public class Node<E> {

    private Node<E> PREVIOUS;

    private E DATA;

    private Node<E> NEXT;

    /**
     * @param e, takes an object of type generic.
     */

    public Node(E e) { this.DATA = e; this.NEXT = null; this.PREVIOUS = null; }

    /**
     * @return returns an object of type generic representing the value of data
     */
    public E getData() {return DATA; }

    /**
     * @return returns an object Node of type generic representing the value of next object
     */
    public Node<E> getNext() { return NEXT; }

    /**
     * @param NEXT takes a Node object of type generic representing the value to be set as the next value
     */
    public void setNext(Node<E> NEXT) { this.NEXT = NEXT; }

    /**
     * @return returns an object of type generic node representing the value of the previous object
     */
    public Node<E> getPrevious() { return PREVIOUS; }

    /**
     * @param PREVIOUS takes an object of type node that represents the value to be set as the PREVIOUS node's value
     */
    public void setPrevious(Node<E> PREVIOUS) { this.PREVIOUS = PREVIOUS; }
}