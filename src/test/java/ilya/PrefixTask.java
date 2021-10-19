package ilya;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class PrefixTask {

    public static void main(String[] args) {
        String[] strs = new String[3];
        strs[0] = "ghower";
        strs[1] = "ghow";
        strs[2] = "ghight";
        System.out.println(getPrefix(strs));
    }

    public static String getPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        String lastAddedChar = "";
        for (int i = 0; i < 1; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            for (int k = 0; k < chars.length; k++) {
                if (String.valueOf(chars[k]).equals("l")) {
                    System.out.println("debug");
                }
                char aChar = chars[k];
                for (int j = 0; j < strs.length; j++) {
                    String s = strs[j];
                    if (s.contains(String.valueOf(aChar))) {
                        if (!result.toString().contains(String.valueOf(aChar))) {
                            result.append(aChar);
                        }
                    } else {
                        result.delete(result.length() - 1, result.length());
                        break;
                    }
                    if (j == strs.length - 1) {
                        if (k == 0) {
                            lastAddedChar = String.valueOf(aChar);
                            continue;
                        }
                        if (!String.valueOf(chars[k - 1]).equals(lastAddedChar)) {
                            result.delete(result.length() - 1, result.length());
                        } else {
                            lastAddedChar = String.valueOf(aChar);
                        }
                    }
                }
            }
        }
        return result.toString();
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int min = strs[0].length();
        for (int j = 1; j < strs.length; j++) {
            if (strs[j].length() < min) {
                min = strs[j].length();
            }
        }
        for (int nr = 0; nr < min; nr++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[0].toCharArray()[nr] != strs[j].toCharArray()[nr]) {
                    return strs[0].substring(0, nr);
                }
            }
        }

        return "";
    }

}
