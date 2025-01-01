import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
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

    public void moveZeroes(int[] nums) {
        
    }

    // 将有序数组转换为二叉搜索树:递归，注意递归的边界条件
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    public TreeNode helper(int[] nums,int left,int right){
        if(left>right){
            return null;
        }
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,left,mid-1);
        root.right = helper(nums,mid+1,right);
        return root;
    }

    // 二叉树的直径:递归，注意递归的边界条件
    static int max_d = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max_d-1;
    }
    public static int depth(TreeNode node){
        if(node==null){
            return 0;
        }
        int L =depth(node.left);
        int R = depth(node.right);
        max_d = Math.max(max_d,L+R+1);
        return Math.max(L,R)+1;
    }
    // 对称二叉树:递归，注意递归的边界条件
    public boolean isSymmetric(TreeNode root) {
        return check(root.left,root.right);
    }
    public static boolean check(TreeNode p,TreeNode q){
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        if(p.val==q.val&&check(p.left,q.right)&&check(p.right,q.left)){
            return true;
        }
        return false;
    }

    //翻转二叉树:递归，注意递归的边界条件
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode newLeft = invertTree(root.left);
        TreeNode newRight = invertTree(root.right);
        root.left = newRight;
        root.right = newLeft;
        return root;
    }

    // 判断两个二叉树是否相同:递归，单纯的递归，深度优先的逻辑比较简单，但是广度有限可以使用对列表示，就很优雅，所以这里使用广度优先（深度广度复杂度都一样）,注意递归的边界条件
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> tmpQueue = new LinkedList<TreeNode>();
        tmpQueue.offer(p);
        tmpQueue.offer(q);
        while(!tmpQueue.isEmpty()){
            p = tmpQueue.poll();
            q = tmpQueue.poll();
            if(p==null&&q==null){
                continue;
            }
            if(p==null || q==null||p.val!=q.val){
                return false;
            }
            tmpQueue.offer(p.left);
            tmpQueue.offer(q.left);

            tmpQueue.offer(p.right);
            tmpQueue.offer(q.right);
        }
        return true;
    }

    // 二叉树的最大深度:递归，注意递归的边界条件
    public int maxDepth(TreeNode root) {
        if(root ==null){
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight,rightHeight)+1;
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