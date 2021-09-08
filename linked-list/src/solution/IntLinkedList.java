package solution;

import java.util.Scanner;

public class IntLinkedList {
    private IntListNode root;
    IntLinkedList(){

    }
    IntLinkedList(IntListNode node){
        root = node;
    }

    public void makeList(){
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        while (!userInput.equals("done")){
            System.out.println("Please enter a legal integer or type \"done.\"");
            userInput = scanner.nextLine();
            try {
                int userNum = Integer.parseInt(userInput);
                insertListNode(-1,userNum);
            }catch (IllegalArgumentException e){
                if(userInput.equals("done")){
                    break;
                }
                System.out.println("Sorry, that was not a legal number.");
            }
        }
    }

    public void insertListNode (int location, int item){
        IntListNode runner = root;
        if(runner==null){
            root = new IntListNode(item);
        }else if(location<0){
            while(runner.next!=null){
                runner = runner.next;
            }
            runner.next = new IntListNode(item);
        }else if(location == 0){
            root = new IntListNode(item);
            root.next = runner;
        }else{
            int counter = 0;
            while (counter<location){
                runner = runner.next;
                counter++;
            }
            IntListNode tempNode = runner.next;
            runner.next = new IntListNode(item);
            runner.next.next = tempNode;
        }
    }

    public void printList(){
        IntListNode runner = root;
        while(runner!=null){
            System.out.println(runner.getIntItem());
            runner = runner.next;
        }
    }

    public IntLinkedList makeReversedList(IntListNode root){
        IntLinkedList reversedList = new IntLinkedList();
        IntListNode runner = root;
        if(runner == null){
            System.out.println("Can't print from null list!");
            return null;
        }
        while (runner!=null){
            reversedList.insertListNode(0,runner.getIntItem());
            runner = runner.next;
        }
        return reversedList;
    }

    public IntListNode getRoot(){
        return root;
    }
}
