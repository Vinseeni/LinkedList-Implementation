public class LinkList {

    Node head;

    public void append(int data){
        //Create new node for the data
        Node insertedData = new Node(data);

        //if head is null return
        if(head == null){
            head = insertedData;
            return;
        }

        //appending to tail
        Node current = head;
        while(current.next !=null){
            current = current.next;
        }
        current.next = insertedData; //insertedData goes to end of LinkedList
    }

    public void printLinkedList(){
        Node current = head;

        if (current ==null){
            System.out.println("Empty LinkedList");
        }
        else{
            while(current.next!= null){
                System.out.println(current.data);
                current = current.next;
            }
                System.out.println(current.data);
        }
        System.out.println("\n");
    }

    public void deleteWithValue(int data) {

        Node current = head;
        if (head == null) {
            return;
        }

        if (current.data == data) {
            head = current.next;
            return;
        }

        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }

        System.out.println("Value to delete is not in LinkedList\n");
    }

    public int getTotalListItems(){

        int index = 0;
        if(head==null){
            return index;
        }
        Node current = head;
        while(current.next !=null){
            current = current.next;
            index++;
        }
        index++;
        return index;
    }

    public int getIndex(int data){
        int index =0;
        if(head.data==data){
            return index;
        }

        Node current = head;
        while(current.next!=null){
            if(current.next.data ==data){
                index++;
                return index;
            }
            current = current.next;
            index++;
        }
        System.out.println("Value not found in LinkedList");
        return -1;

    }

    public void insert(int index, int data){

        if(index>=getTotalListItems()|| index<0) {
            System.out.println("Index to insert is out of Bounds\n");
            return;
        }
        int reference =0;
        Node insertedData = new Node(data);
        if (index==0){
            insertedData.next=head;
            head = insertedData;
            return;
        }

            Node current = head;
            while (current.next != null) {
                if(reference ==index-1){
                    insertedData.next = current.next;
                   current.next = insertedData;

                   }
                current = current.next;
                reference++;
            }

        }


    public static void main(String[] args){

        LinkList LL1 = new LinkList();
        LL1.append(1);
        LL1.append(2);
        LL1.append(5);
        LL1.append(3);
        LL1.append(15);


        LL1.printLinkedList();

        System.out.println("Number of Items"+ LL1.getTotalListItems());

        LL1.deleteWithValue(23);
        LL1.printLinkedList();

        System.out.println("Number of Items: "+ LL1.getTotalListItems());

        int numberToFind = 15;
        System.out.println("Index position of value " + numberToFind+ " is: " +LL1.getIndex(numberToFind) );

        LL1.insert(0,2024);
        LL1.printLinkedList();

    }

}