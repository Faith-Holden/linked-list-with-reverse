package solution;

public class Main {
    public static void main(String[]args){
        IntLinkedList list1 = new IntLinkedList();
        list1.makeList();
        list1.printList();
        System.out.println("___________");
        System.out.println("reversed list:");
        IntLinkedList list2 = list1.makeReversedList(list1.getRoot());
        list2.printList();
    }
}
