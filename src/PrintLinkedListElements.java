/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adegoke.obasa
 */
public class PrintLinkedListElements {

    class Node {
        int data;
        Node next;
    }
    
    void Print(Node head) {
        do {
            if(head == null) {
                break;
            }
            System.out.println(head.data);
            head = head.next;
        } while(head != null);
    }
}
