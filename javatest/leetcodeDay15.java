import java.util.HashMap;

class leetcodeDay15 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
            
    public static int lengthOfLongestSubstring(String s) {
        // 滑动窗口法
        int start=0,end=0;
        int n = s.length();
        int ans = 0;
        HashMap<Character,Integer> dict = new HashMap<Character,Integer>(); // 哈希表，记录每个字符出现的位置

        while(end<n){
            Character c = s.charAt(end);
            if(dict.containsKey(s.charAt(end))){
                while(start <= dict.get(c) ){
                    start++;
                }
                dict.remove(c);
                dict.put(c,end);
            }
            else{
                dict.put(c,end);
            }
            ans = Math.max(ans,end-start+1);
            end++;
            
        }
        return ans;
    }
}