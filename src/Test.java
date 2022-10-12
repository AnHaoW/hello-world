import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


public class Test {
    public static void main(String[] args) {
//        String s=convert("AB",1);
//        int i = new Test().reverse(-1534);
//        int i = new Test().MFGFmyAtoi(" 42");
        Test test = new Test();

        int[] height = new int[]{0, 0, 0, -1000000000, -1000000000, -1000000000, -1000000000};

        ListNode listNode1 = new ListNode(99);
        ListNode listNode2 = new ListNode(-9, listNode1);
        ListNode listNode3 = new ListNode(1, listNode2);
        ListNode listNode4 = new ListNode(8);
        ListNode listNode5 = new ListNode(5, listNode4);
        ListNode listNode6 = new ListNode(1, listNode5);
        ListNode listNode = null;

        ConcurrentHashMap<String, Integer> ccmap = new ConcurrentHashMap<String,Integer>();
        ccmap.put("qqq",111);
        ReadWriteLock readWriteLock = null;
        Lock lock= readWriteLock.writeLock();
        lock.lock();
        lock.unlock();
        System.out.println(test.generateParenthesis(3));
    }

    //22
    public List<String> generateParenthesis(int n) {
        List<String> Strings = new ArrayList<String>();
        generateParenthesisDG(Strings,new StringBuilder(),0,0,n);
        return Strings;
    }
    public void generateParenthesisDG(List<String> listStrings ,StringBuilder sb,int i,int j,int max) {
        if(sb.length()==2*max){
            listStrings.add(sb.toString());
            return;
        }
        if(i<max){
            sb.append('(');
            generateParenthesisDG(listStrings,sb,i+1,j,max);
            sb.delete(sb.length()-1,sb.length());
        }
        if(j<i){
            sb.append(')');
            generateParenthesisDG(listStrings,sb,i,j+1,max);
            sb.delete(sb.length()-1,sb.length());
        }
    }
    //21
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode result = new ListNode(0, l1);
        ListNode resultHead = result;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        while (l1 != null) {
            if (l2 == null) {
                break;
            }
            if (l1.val > l2.val) {
                result.next = l2;
                l2 = l2.next;
            } else {
                if (l2 != null) {
                    result.next = l1;
                    l1 = l1.next;
                }
            }
            result = result.next;
        }
        while (l2 != null) {
            result.next = l2;
            l2 = l2.next;
            result = result.next;
        }
        while(l1!=null){
            result.next = l1;
            l1 = l1.next;
            result = result.next;
        }
        return resultHead.next;
    }

    //20
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<Character, Character> bracket = new HashMap<Character, Character>();
        bracket.put('(', ')');
        bracket.put('[', ']');
        bracket.put('{', '}');

        Deque stack = new ArrayDeque();
        for (int i = 0; i < n; i++) {
            if (bracket.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (stack.isEmpty() || bracket.get(stack.getFirst()) != s.charAt(i)) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    //19题
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = nodeLength(head);
        ListNode nodeHead = new ListNode(0, head);
        ListNode nodeResult = nodeHead;
        ListNode nodeWork = nodeHead;
        for (int i = 0; i < length - n; i++) {
            nodeWork = nodeWork.next;
        }
        nodeWork.next = nodeWork.next.next;
        return nodeResult.next;
    }

    public int nodeLength(ListNode head) {
        int length = 1;
        while (head.next != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    //18题
    public List<List<Integer>> fourSumGF(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (null == nums || nums.length < 4) {
            return results;
        }
        Arrays.sort(nums);
        int one, two, three, four;
        for (one = 0; one < nums.length - 3; one++) {
            if (one > 0 && nums[one] == nums[one - 1]) {
                continue;
            }
            if (sum(one, one + 1, one + 2, one + 3, nums) > target) {
                break;
            }
            if ((long) nums[one] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                continue;
            }
            for (two = one + 1; two < nums.length - 2; two++) {
                if (two > one + 1 && nums[two] == nums[two - 1]) {
                    continue;
                }
                if (sum(one, two, two + 1, two + 2, nums) > target) {
                    break;
                }
                if ((long) nums[one] + nums[two] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                    continue;
                }
                four = nums.length - 1;
                three = two + 1;
                while (three < four) {
                    if (sum(one, two, three, four, nums) == target) {
                        results.add(Arrays.asList(nums[one], nums[two], nums[three], nums[four]));
                        while (three < four - 1 && nums[three] == nums[three + 1]) {
                            three++;
                        }
                        three++;
                        while (four - 1 > three && nums[four] == nums[four - 1]) {
                            four--;
                        }
                        four--;
                    }
                    if (sum(one, two, three, four, nums) < target) {
                        while (three < four - 1 && nums[three] == nums[three + 1]) {
                            three++;
                        }
                        three++;
                    }
                    if (sum(one, two, three, four, nums) > target) {
                        while (four - 1 > three && nums[four] == nums[four - 1]) {
                            four--;
                        }
                        four--;
                    }
                }
            }
        }
        return results;
    }

    public long sum(int i, int j, int k, int l, int[] nums) {
        return (long) nums[i] + nums[j] + nums[k] + nums[l];
    }

    public static void test() {
        HashMap hashMap = new HashMap();
        hashMap.put(1, "111");
        hashMap.put(-1, "-1-1");
        hashMap.put("hashMap", "hashMap");
        System.out.println(hashMap.toString());
        Hashtable hashtable = new Hashtable();
        hashtable.put(2, "222");
        System.out.println(hashtable.toString());
        HashSet hashSet = new HashSet();
        hashSet.add("HashSet");
        hashSet.add(2);
        hashSet.add("AAA");
        hashSet.add("");
        hashSet.add("");
        System.out.println(hashSet.iterator().next());
        TreeSet treeSet = new TreeSet();
        treeSet.add("treeSet");
        List arrayList = new ArrayList();
        arrayList.add("arrayList");
        arrayList.add("1arrayList");
        arrayList.add("");
        arrayList.add("");
        arrayList.set(0, "0arrayList");
        System.out.println(arrayList.toString());
        List linkedList = new LinkedList();
        linkedList.add("LinkedList");
        linkedList.add(1);
        List<String> stringList = new LinkedList<String>();
        stringList.add("StringList");
    }

    public int myAtoi(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-' && i != s.length() - 1 && s.charAt(i + 1) <= '9' && s.charAt(i + 1) >= '0') {
                if (str.equals("")) {
                    str += s.charAt(i);
                } else {
                    break;
                }
            } else if ((s.charAt(i) == '+' || s.charAt(i) == ' ') && i != s.length() - 1 && s.charAt(i + 1) <= '9' && s.charAt(i + 1) >= '0') {
                if (str.equals("")) {
                    continue;
                } else {
                    break;
                }
            } else if (s.charAt(i) == ' ' && i != s.length() - 1 &&
                    ((s.charAt(i + 1) <= '9' && s.charAt(i + 1) >= '0') || s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-' || s.charAt(i + 1) == ' ')) {
                if (str.equals("")) {
                    continue;
                } else {
                    break;
                }
            } else if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                if (s.charAt(i) == '0') {
                    if (i == s.length() - 1) {
                        if (str.equals("") || str.equals("-")) {
                            continue;
                        } else {
                            str += s.charAt(i);
                        }
                    } else if (s.charAt(i + 1) == '-' || s.charAt(i + 1) == ' ' || s.charAt(i + 1) == '+') {
                        break;
                    } else {
                        if (str.equals("") || str.equals("-")) {
                            continue;
                        } else {
                            str += s.charAt(i);
                        }
                    }

                } else {
                    str += s.charAt(i);
                }
            } else {
                break;
            }
        }
        if (s.equals("") || str.equals("") || str.equals("-")) {
            return 0;
        }
        int result;
        if (str.length() > 11) {
            if (str.charAt(0) == '-') {
                result = Integer.MIN_VALUE;
            } else {
                result = Integer.MAX_VALUE;
            }
        } else {
            Long l = Long.valueOf(str);
            if (l > Integer.MAX_VALUE) {
                result = Integer.MAX_VALUE;
            } else if (l < Integer.MIN_VALUE) {
                result = Integer.MIN_VALUE;
            } else {
                result = Integer.valueOf(str);
            }
        }
        return result;
    }

    public int MFGFmyAtoi(String str) {
        String strTrim = str.trim();
        if (strTrim.equals("")) {
            return 0;
        }
        if (strTrim.charAt(0) != '+' && strTrim.charAt(0) != '-' && !Character.isDigit(strTrim.charAt(0))) {
            return 0;
        }
        boolean neg = strTrim.charAt(0) == '-';
        int i = !Character.isDigit(strTrim.charAt(0)) ? 1 : 0;
        int result = 0;
        for (; i < strTrim.length(); i++) {
            if (Character.isDigit(strTrim.charAt(i))) {
                int tmp = ((neg ? Integer.MIN_VALUE : Integer.MIN_VALUE + 1) + (strTrim.charAt(i) - '0')) / 10;
                if (tmp > result) {
                    return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result = result * 10 - (strTrim.charAt(i) - '0');
            } else {
                break;
            }
        }
        return neg ? result : -result;
    }

    public int GFmyAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        if (!Character.isDigit(str.charAt(0))
                && str.charAt(0) != '-' && str.charAt(0) != '+')
            return 0;
        int ans = 0;
        boolean neg = str.charAt(0) == '-';
        int i = !Character.isDigit(str.charAt(0)) ? 1 : 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int tmp = ((neg ? Integer.MIN_VALUE : Integer.MIN_VALUE + 1) + (str.charAt(i) - '0')) / 10;
            if (tmp > ans) {
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 - (str.charAt(i++) - '0');
        }
        return neg ? ans : -ans;
    }

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            result = result * 10 + x % 10;
            x = x / 10;
        }

        return result;
    }

    static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<String> strList = new LinkedList<String>();
        for (int i = 0; i < numRows; i++) {
            strList.add("");
        }
        for (int i = 0, k = 0, flag = 0; i < s.length(); i++) {
            if (flag == 0) {
                strList.set(k, strList.get(k).concat(String.valueOf(s.charAt(i))));
                k++;
                if (k == numRows - 1) {
                    flag = 1;
                }
            } else if (flag == 1) {
                strList.set(k, strList.get(k).concat(String.valueOf(s.charAt(i))));
                k--;
                if (k == 0) {
                    flag = 0;
                }
            }
        }
        String str = "";
        for (int i = 0; i < numRows; i++) {
            str += strList.get(i);
        }
        return str;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = Integer.toString(x);
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    //第十题
    public boolean isMatch(String s, String p) {
        int len = s.length();
        boolean flag = false;
        for (int i = 0, j = 0; i < len; i++) {
            if (i > 0 && s.charAt(i) != s.charAt(i - 1) && j > 0 && p.charAt(j - 1) != '*') {
                flag = false;
            }
            for (; j < p.length(); ) {
                if (p.charAt(j) == '.') {
                    flag = true;
                    j++;
                    break;
                } else if (p.charAt(j) == '*') {
                    if (flag == true) {
                        break;
                    } else {
                        j++;
                    }
                } else {
                    if (s.charAt(i) == p.charAt(j)) {
                        flag = true;
                        j++;
                        break;
                    } else {
                        if (j == 0) {
                            j++;
                        } else {
                            return false;
                        }
                    }
                }
            }
            if (j >= p.length() && i != len - 1) {
                return false;
            }
        }
        return true;
    }


    public int maxArea(int[] height) {
        int left = 0, area = 0;
        int right = height.length - 1;
        area = area(left, right, height);
        while (left < right) {
            int area1 = area(left, right, height);
            area = area >= area1 ? area : area1;
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }

    private int area(int left, int right, int[] height) {
        int high = 0;
        if (height[left] > height[right]) {
            high = height[right];
        } else {
            high = height[left];
        }
        return (right - left) * high;
    }

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String roman = "";

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman += symbols[i];
            }
        }
        return roman;

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int k = nums.length - 1;
            for (int j = i + 1; j < nums.length; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (j < k && nums[i] + nums[j] + nums[k] > 0) {
                    --k;
                }
                if (j == k) {
                    break;
                }
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> result = new ArrayList<Integer>();
                    result.add(nums[i]);
                    result.add(nums[j]);
                    result.add(nums[k]);
                    results.add(result);
                }
            }
        }
        return results;
    }

    //17
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (digits.length() == index) {
            combinations.add(combination.toString());
        } else {
            char num = digits.charAt(index);
            String str = phoneMap.get(num);
            for (int i = 0; i < str.length(); i++) {
                combination.append(str.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(combination.length() - 1);
            }
        }
    }

}
