import java.util.HashMap;
import java.util.Map;

public class LCDay18 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ans = solution.twoSum(new int[]{2,7,11,15},9);
        System.err.println(ans);
    }
}
class Solution {
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