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
    public int pairSum(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            
        }
        ListNode prev=null;
        ListNode curr=slow;
        while(curr!=null)
        {
            ListNode nextnode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextnode;

        }
        ListNode first=head;
        ListNode second=prev;
        int max=0;
        while(second!=null)
        {
            max=Math.max(max,first.val+second.val);
            first=first.next;
            second=second.next;
        }
        return max;
        

        
        
    }
}