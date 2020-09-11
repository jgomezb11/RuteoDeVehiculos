package Taller07;

/**
 *  @author Julian Gomez, Juan Pablo Rincon.
 *  @version 1
 */
public class Laboratorio3 {
    public static void main(String[] args)
    {

        LinkedList list = new LinkedList();
        list.insert(5, 0);
        list.insert(4, 0);
        list.insert(3, 0);
        list.insert(2, 0);
        list.insert(1, 0);
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }

        System.out.println(list.contains(3));
        list.remove(2);
        System.out.println(list.contains(3));
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
    }

}