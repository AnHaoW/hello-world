import bean.SingletonEnum;

import java.util.*;
import java.util.concurrent.*;
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
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
//        String s=convert("AB",1);
//        int i = new Test().reverse(-1534);
//        int i = new Test().MFGFmyAtoi(" 42");
        Test test = new Test();

        int[] nums1 = new int[]{1, 3, 4, 9};
        Integer[] nums2 = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9,3,3,3,3,3};
        int [][] intervals ={{1,3},{2,6},{8,10},{15,18}} ;
        String s1 = "aa bb cc aa";
        String s2 = "a*";
        String[] strs = s1.split(" ");
        System.out.println(Integer.MAX_VALUE);
        List<Integer> list = test.aliList(Arrays.asList(nums2));
        for(Integer i :list){
            System.out.println(i);
        }


    }

    //淘天
    public  List<Integer> aliList(List<Integer> list){
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();;;
        for(int i=0;i<list.size();i++){
            if(list.get(i)%2==0){
                list1.add(list.get(i));//偶数
            }else {
                list2.add(list.get(i));//奇数
            }
        }
        Integer [] nums1 = list1.toArray(new Integer[list1.size()]);
        Arrays.sort(nums1,(o1,o2) -> o2-o1);//倒序
        Integer [] nums2 = list2.toArray(new Integer[list2.size()]);
        Arrays.sort(nums2,(o1,o2) -> o2-o1);
        Collections.addAll(result,nums2);
        Collections.addAll(result,nums1);
        for(int i=0;i<result.size();i++){
            if(result.get(i)%3==0 && result.get(i)!=0){
                result.remove(i);
                i--;
            }
        }
        return result;
    }

    public void printALI() throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        for(int i=0;i<100;i++){

            Thread thread1 = new Thread(){
                @Override
                public void run(){
                    System.out.println("A");
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }

            };
            thread1.start();
            TimeUnit.MILLISECONDS.sleep(10);
            Thread thread2 = new Thread(){
                @Override
                public void run(){
                    System.out.println("L");
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }

            };
            thread2.start();
            TimeUnit.MILLISECONDS.sleep(10);
            Thread thread3 = new Thread(){
                @Override
                public void run(){
                    System.out.println("I");
                    try {
                        cyclicBarrier.await(10, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    } catch (TimeoutException e) {
                        e.printStackTrace();
                    }
                }

            };
//            thread1.start();
//            thread2.start();
            thread3.start();
            TimeUnit.MILLISECONDS.sleep(10);
            cyclicBarrier.reset();
        }
    }



    //od1
    public void od1(){
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int sum= in.nextInt();
        String[][] all = new String[sum][sum];
        String[] firstp = in.next().split(",");
        String[] result = new String[sum];
        String[] result2 = new String[sum];
        String[] result3 = new String[sum];

        for(int i=0;i<sum;i++){
            all[i] = in.next().split(",");
        }
        int k=0;
        for(int i=0;i<sum;i++) {
            for(int j=0;j<sum;j++){
                if(all[i][j].equals("1") && i!=j){
                    for(int l=0;l<firstp.length;l++){
                        if(String.valueOf(i).equals(firstp[l])){
                            result[k++]=String.valueOf(j);
                        }
                    }
                }
            }
        }
        int v=0;
        int m=0;
        for(String str:firstp){
            if(str!=null){
                result2[v++] = str;
            }
        }
        for(String str:result){
            if(str!=null){
                result2[v++] = str;
                result3[m++] = str;
            }
        }
        result=new String[sum];

        while (result3[0]!=null){
            k=0;
            for(int i=0;i<sum;i++) {
                for(int j=0;j<sum;j++){
                    if(all[i][j].equals("1") && i!=j){
                        for(int l=0;l<result3.length;l++){
                            if(String.valueOf(i).equals(result3[l])){
                                for(int b=0;b<result2.length;b++){
                                    if(String.valueOf(j).equals(result2[b])){
                                        break;
                                    }
                                    if(b==result2.length-1)
                                    result[k++]=String.valueOf(j);
                                }
                            }
                        }
                    }
                }
            }
            m=0;
            result3 =new String[sum];
            for(String str:result){
                if(str!=null){
                    result2[v++] = str;
                    result3[m++] = str;
                }
            }
            result=new String[sum];
        }
        int r=0;
        for(String str:result2){
            if(str!=null){
                r++;
            }
        }
        r = r-firstp.length;
        System.out.println(r);
    }
    //od2
    public void od2(){
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int a = in.nextInt();
        String[] strs = new String[a];
        for (int i = 0; i < a; i++) {
            strs[i] = in.next();
        }
        String chars = in.next();
        int result = 0 ,flag=0,index=-1;
        int [] r = new int[a];
        for (int i = 0; i < a; i++) {
            String s = new String(chars);
            flag = 0;
            int clen = s.length();
            for (int j = 0; j < strs[i].length(); j++) {
                index = -1;
                for (int k = 0; k < clen; k++) {
                    if (strs[i].charAt(j) == s.charAt(k)) {
                        s=s.replaceFirst(strs[i].substring(j, j + 1), "");
                        clen--;
                        break;
                    }
                    if(s.charAt(k) == '?' && index == -1){
                        index = k;
                    }
                    if(k==s.length()-1){
                        if(index==-1){
                            flag=1;
                            break;
                        }
                        else{
                            chars = chars.replaceFirst("\\?","");
                            s = s.replaceFirst("\\?","");;
//                            chars.replaceFirst(chars.substring(index, index + 1),"");
                            clen--;
                        }
                    }
                }
                if(flag==1)
                    break;
            }
            if(flag==0){
                result++;
            }
        }
        System.out.print(result);
    }
    //字节

    public int[][] merge(int[][] intervals) {
        //此处需要注意，这里是重写了compare方法，用来告诉sort函数是按照升序还是降序来进行排序。
        Arrays.sort(intervals,new Comparator<>()
        {
            public int compare(int a[],int b[])
            {
                return a[0]-b[0];
            }
        });

        List<int[]> path=new ArrayList<>();
        int i=0;

        while(i<intervals.length)
        {
            int leftBound=intervals[i][0];
            int rightBound=intervals[i][1];
            while(i<intervals.length-1 && intervals[i+1][0]<=rightBound)
            {
                i++;
                rightBound=Math.max(intervals[i][1],rightBound);
            }
            path.add(new int[]{leftBound,rightBound});
            i++;

        }
        return path.toArray(new int[0][]);

    }
    //22
    public List<String> generateParenthesis(int n) {
        List<String> Strings = new ArrayList<String>();
        generateParenthesisDG(Strings, new StringBuilder(), 0, 0, n);
        return Strings;
    }

    public void generateParenthesisDG(List<String> listStrings, StringBuilder sb, int i, int j, int max) {
        if (sb.length() == 2 * max) {
            listStrings.add(sb.toString());
            return;
        }
        if (i < max) {
            sb.append('(');
            generateParenthesisDG(listStrings, sb, i + 1, j, max);
            sb.delete(sb.length() - 1, sb.length());
        }
        if (j < i) {
            sb.append(')');
            generateParenthesisDG(listStrings, sb, i, j + 1, max);
            sb.delete(sb.length() - 1, sb.length());
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
        while (l1 != null) {
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
        int i = s.length();
        int j = p.length();
        boolean[][] result = new boolean[i + 1][j + 1];
        //数组复制
        result[0][0] = true;
        for (int m = 0; m <= i; ++m) {
            for (int n = 1; n <= j; ++n) {
                if (p.charAt(n-1) == '*') {
                    result[m][n] = result[m][n - 2];
                    if (match(s, p, m, n - 1)) {
                        result[m][n] = result[m][n] || result[m - 1][n];
                    }
                } else {
                    if (match(s, p, m, n)) {
                        result[m][n] = result[m - 1][n - 1];
                    }
                }
            }
        }
        return result[i][j];

    }

    public boolean match(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j-1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
    class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();

            boolean[][] f = new boolean[m + 1][n + 1];
            f[0][0] = true;
            for (int i = 0; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (p.charAt(j - 1) == '*') {
                        f[i][j] = f[i][j - 2];
                        if (matches(s, p, i, j - 1)) {
                            f[i][j] = f[i][j] || f[i - 1][j];
                        }
                    } else {
                        if (matches(s, p, i, j)) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    }
                }
            }
            return f[m][n];
        }

        public boolean matches(String s, String p, int i, int j) {
            if (i == 0) {
                return false;
            }
            if (p.charAt(j - 1) == '.') {
                return true;
            }
            return s.charAt(i - 1) == p.charAt(j - 1);
        }
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

    //4
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int m = nums1.length, n = nums2.length;
//        int s = m + n;
//        int[] arr = new int[s];
//        int i = 0, j = 0, k = 0;
//        while (i < m && j < n && i + j <= s / 2) {
//            if (nums1[i] >= nums2[j]) {
//                arr[k++] = nums2[j++];
//            } else {
//                arr[k++] = nums1[i++];
//            }
//        }
//        while (i == m && i + j <= s / 2) {
//            arr[k++] = nums2[j++];
//        }
//        while (j == n && i + j <= s / 2) {
//            arr[k++] = nums1[i++];
//        }
//        double result;
//        if (s % 2 == 1) {
//            result = arr[s / 2];
//        } else {
//            result = (arr[s / 2 - 1] + arr[s / 2]) / 2.0;
//        }
//        return result;
//    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int s = m + n;
        double result;
        if (s % 2 == 1) {
            result = findMedian(nums1, nums2, s / 2 + 1);
            return result;
        } else {
            result = (findMedian(nums1, nums2, s / 2) + findMedian(nums1, nums2, s / 2 + 1)) / 2.0;
            return result;
        }

    }

    double findMedian(int[] nums1, int[] nums2, int k) {
        int index1 = 0, index2 = 0;
        int m = nums1.length, n = nums2.length;
        while (true) {
            if (m == index1) {
                return nums2[index2 + k - 1];
            }
            if (n == index2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, m) - 1;
            int newIndex2 = Math.min(index2 + half, n) - 1;
            if (nums1[newIndex1] <= nums2[newIndex2]) {
                k -= newIndex1 - index1 + 1;
                index1 = newIndex1 + 1;
            } else {
                k -= newIndex2 - index2 + 1;
                index2 = newIndex2 + 1;
            }
        }
    }

}
