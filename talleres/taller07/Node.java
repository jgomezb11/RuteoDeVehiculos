package Taller07;

/**
 *  @author Julian Gomez, Juan Pablo Rincon.
 *  @version 1
 */
// Un nodo para una lista simplemente enlazada
public class Node
{
    public int data;
    public Node next;
    public Node(int data)
    {
        next = null;
        this.data = data;
    }
}