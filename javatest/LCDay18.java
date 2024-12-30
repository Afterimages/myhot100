import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LCDay18 {
    public static void main(String[] args) {
        // int n = 7;
        // boolean ans = isHappy(n);
        int[] nums= {0,1,2,4,5,7};
        // int k = 3;
        List<String> ans = summaryRanges(nums);
        System.err.println(ans);
    }
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