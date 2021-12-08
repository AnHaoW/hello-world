import java.util.*;

public class Test {
    public static void main(String[] args) {
        System.out.println("hello");
//        String s=convert("AB",1);
//        int i = new Test().reverse(-1534);
        int i = new Test().MFGFmyAtoi(" 42");
        System.out.println(i);
        Hashtable hashtable = new Hashtable();
        hashtable.put("1","222");
        System.out.println(hashtable.toString());
    }

    public static void test(){
        HashMap hashMap = new HashMap();
        hashMap.put(1,"111");
        Hashtable hashtable = new Hashtable();
        hashtable.put(2,"222");
        HashSet hashSet = new HashSet();
        hashSet.add("HashSet");
        List arrayList = new ArrayList();
        arrayList.add("arrayList");
        arrayList.set(2,"2arrayList");
        List linkedList = new LinkedList();
        linkedList.add("LinkedList");
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
}
