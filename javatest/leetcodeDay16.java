

public class leetcodeDay16 {
    public String minWindow(String S, String t) {
        char[] s = S.toCharArray();
        int m = s.length;
        int ansLeft = -1;
        int ansRight = m;
        int[] cntS = new int[128]; // s 子串字母的出现次数
        int[] cntT = new int[128]; // t 中字母的出现次数

        // 初始化 t 中字母的出现次数
        for (char c : t.toCharArray()) {
            cntT[c]++;
        }

        int left = 0;
        int requiredChars = t.length(); // 需要匹配的字符数
        int matchedChars = 0; // 当前匹配的字符数

        for (int right = 0; right < m; right++) { // 移动子串右端点
            char rightChar = s[right];
            if (cntT[rightChar] > 0) {
                cntS[rightChar]++;
                if (cntS[rightChar] <= cntT[rightChar]) {
                    matchedChars++;
                }
            }

            // 当前窗口包含所有需要的字符
            while (matchedChars == requiredChars) {
                if (right - left < ansRight - ansLeft) { // 找到更短的子串
                    ansLeft = left; // 记录此时的左右端点
                    ansRight = right;
                }

                char leftChar = s[left];
                if (cntT[leftChar] > 0) {
                    cntS[leftChar]--;
                    if (cntS[leftChar] < cntT[leftChar]) {
                        matchedChars--;
                    }
                }
                left++;
            }
        }

        return ansLeft < 0 ? "" : S.substring(ansLeft, ansRight + 1);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        leetcodeDay16 leetcodeDay16 = new leetcodeDay16();

        String ans = leetcodeDay16.minWindow(s, t);

        System.out.println(ans);
    }
}