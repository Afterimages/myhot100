import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LCDay17 {
   public static void main(String[] args) {
        Solution0 solution = new Solution0();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ans = solution.groupAnagrams(strs);
        System.out.println(ans);
   } 
}
class Solution0 {
    // 频率统计方法的复杂度就是比排序法更低
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();//hashmap：{"字符+数字":["字符串1","字符串2"],}
        for(String item:strs){
            int[] counts = new int[26]; // 默认都为0
            int length = item.length();
            for(int i = 0;i<length;i++){
                counts[item.charAt(i)-'a']++; //数组索引即字符与‘a’的偏移值
            }
            StringBuffer sb = new StringBuffer();
            for(int i = 0;i<26;i++){
                if(counts[i]!=0){
                    sb.append((char)('a'+i)); // 字符+数字=数字（这跟python相反）
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key,new ArrayList<String>());
            list.add(item);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values()); //map.values() 会返回一个 Collection<List<String>>,需要做转换
    }
}

class Solution3 {
    // 我觉得只与词频有关，与位置无关
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Integer> s_freq = new HashMap<>();
        int len = s.length();
        for(int i=0;i<len;i++){
            Character s_item = s.charAt(i);
            Character t_item = t.charAt(i);
            s_freq.put(s_item,s_freq.getOrDefault(s_item,0)+1);
            s_freq.put(t_item,s_freq.getOrDefault(t_item,0)-1);
        }
        for(Character key:s_freq.keySet()){
            if(s_freq.get(key)!=0){
                return false;
            }
        }
        return true;
    }
}

class Solution2 {
    // 感觉与同构字符串是一个套路
    // 补充：感觉有点区别：1.要检查长度 2.可以只做单射
    public boolean wordPattern(String pattern, String s) {
        String[] s_split = s.split(" ");
        if(pattern.length()!=s_split.length){
            return false;
        }
        HashMap<Character,String> p2s = new HashMap<>();
        HashMap<String,Character> s2p = new HashMap<>();
        int len = pattern.length();
        for(int i= 0;i<len;i++){
            Character p_item = pattern.charAt(i);
            String s_item = s_split[i];
            if((p2s.containsKey(p_item) && !p2s.get(p_item).equals(s_item))
            // ||(s2p.containsKey(s_item) && s2p.get(s_item)!=p_item)
            ){
                return false;
            }
            p2s.put(p_item,s_item);
            s2p.put(s_item,p_item);
        }
        return true;
    }
}
class Solution1 {
    public boolean isIsomorphic(String s, String t) {
        // 同构字符串的充分必要条件是双射
        HashMap<Character,Character> s2t = new HashMap<Character,Character>();
        HashMap<Character,Character> t2s = new HashMap<Character,Character>();
        int len = s.length();
        for(int i = 0;i<len;i++){
            char s_item = s.charAt(i);
            char t_item = t.charAt(i);
            if((s2t.containsKey(s_item) && s2t.get(s_item)!=t_item) || (t2s.containsKey(t_item)&& t2s.get(t_item)!=s_item)){
                return false;
            }
            s2t.put(s_item,t_item);
            t2s.put(t_item,s_item);
        }
        return true;
    }
}