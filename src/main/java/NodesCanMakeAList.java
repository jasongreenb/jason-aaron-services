import com.example.Node;



public class NodesCanMakeAList {



    public static void main(String[] args){
        Node node1 = new Node(1, "Jason");
        Node node2 = new Node(2, "Aaron");
        Node node3 = new Node(3, "Ariel");
        Node node4 = new Node(4, "Safta");
        Node node5= new Node(5, "Ima");
        Node node6= new Node(6, "Dad");



        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

        node2 = node5;


        Node head = node1;
        System.out.println(String.format("head: %s, head.name: %s, head.value: %d", head.name, head.name, head.value));

        while(head.next != null) {
            System.out.println(String.format("head.next: %s, head.next.name: %s, head.next.value: %d", head.next.name, head.next.name, head.next.value));
            head = head.next;
        }
    }
}
