/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallerNode = new ListNode(-1);
        ListNode smaller = smallerNode;
        

        ListNode geraternode = new ListNode(-1);
        ListNode gerater= geraternode;

        ListNode curr=head;
        while(curr!=null){
            if(curr.val<x){
                smaller.next = curr;
                smaller =smaller.next;
            } 
            else {
                gerater.next = curr;
                gerater =gerater.next;
            }
            curr=curr.next;
        }


      smaller.next = geraternode.next;
      gerater.next = null;
      return smallerNode.next;

    }
}