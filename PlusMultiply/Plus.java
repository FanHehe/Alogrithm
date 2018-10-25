public class Plus {

    public static String sum(String one, String another) {

    String more = one.length() > another.length() ? one : another;
    String less = one.length() > another.length() ? another : one;

    int moreLength = more.length();
    int lessLength = less.length();

    boolean flag = false;
    StringBuffer result = new StringBuffer();

    for (int i = moreLength - 1, j = lessLength - 1; i >=0; i--, j--) {

        if (j < 0) {

            int sum = more.charAt(i) - '0' + (flag ? 1 : 0);

            flag = sum >= 10;

            result.insert(0, sum % 10);

            continue;
        }

        int sum = more.charAt(i) + less.charAt(j) - '0' - '0' + (flag ? 1 : 0);

        flag = sum >= 10;

        result.insert(0, sum % 10);
    }

    if (flag) result.insert(0, 1);

    return result.toString();
}
}
