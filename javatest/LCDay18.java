import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class LCDay18 {
    public static void main(String[] args) {
        // int n = 7;
        // boolean ans = isHappy(n);
        // int[] nums= {0,1,2,4,5,7};
        ListNode head = new ListNode(0)
        boolean ans = mergeTwoLists(list1, list2);
        System.err.println(ans);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                tail.next = list1;
                list1 = list1.next;
            }
            else{
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = list1!=null?list1:list2;
        return head.next;
    }

    // 环形链表:快慢指针，快慢指针相遇，说明有环，否则没有环。快指针速度是慢指针的两倍
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null){
            return false;
        }

        ListNode fast =head.next;
        ListNode low = head;

        while(low!=fast){
            if(fast==null||fast.next==null){
                return false;
            }
            low = low.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static boolean isValid(String s) {
        int length = s.length();
        if(length%2!=0){
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Deque<Character> stack = new LinkedList<>(); //只用来放左括号
        for(int i =0;i<length;i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(stack.isEmpty()||map.get(c)!= stack.peek()){
                    return false;
                }
                stack.pop();
            }
            else{
                stack.push(c);
            }
            
        }
        return stack.isEmpty();
    }

    // 汇总区间:用字符串缓冲区，注意边界条件，注意字符串缓冲区的append方法。（我自己用的方法就从左往右遍历，效果不好，总是要判断溢出，代码不够简洁，还是标准的双指针效果好）
    public static List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int length = nums.length;
        int i = 0;
        StringBuffer str = new StringBuffer();
        if (length == 0) return ans; // 处理空数组的情况
        str.append(nums[i]);
        while (i < length) {
            int start = nums[i];
            while (i < length - 1 && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            if (start != nums[i]) {
                str.append("->").append(nums[i]);
            }
            ans.add(str.toString());
            str = new StringBuffer();
            i++;
            if (i < length) {
                str.append(nums[i]);
            }
        }
        return ans;
    }
    // 存在重复元素:用哈希表记录，如果出现重复元素，返回true，否则返回false
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int length = nums.length;
        for(int i = 0;i<length;i++){
            if((map.containsKey(nums[i]))&&(i-map.get(nums[i])<=k)){
                return true;
            }
            else{
                map.put(nums[i],i);
            }
        }
        return false;
    }

    // 快乐数:我觉得考点是运用整除和取模的知识，注意不要搞错先后顺序
    public static boolean isHappy(int n) {
        Map<Integer,Integer> map = new HashMap<>();
        while(n!=1){
            map.put(n,1);
            int sum = 0;
            while(n!=0){
                sum+=(n%10)*(n%10);
                n/=10;
            }
            if(!map.containsKey(sum)){
                n = sum;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
class Solution1 {
    // 两数之和我记得是用双指针。但这里刷题的时候在哈希表题库下，所以用哈希表
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();//数字：索引
        int length = nums.length;
        for(int i=0;i<length;i++){
            int res = target-nums[i];
            if(map.containsKey(res)){
                return new int[]{map.get(res),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}