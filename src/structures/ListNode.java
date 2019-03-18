package structures;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    public void print(ListNode head){
        while(head!=null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static ListNode getList(){
        ListNode head = new ListNode(1);
        ListNode sec = new ListNode(3);
        ListNode third = new ListNode(5);

        head.next = sec;
        sec.next = third;

        return head;
    }

    public static ListNode getList2(){
        ListNode head = new ListNode(2);
        ListNode sec = new ListNode(4);
        ListNode third = new ListNode(6);

        head.next = sec;
        sec.next = third;

        return head;
    }
}
