public class Solution {
    /**
     * @param a: a number
     * @param b: a number
     * @return: the result
     */
    public String addBinary(String a, String b) {
        // write your code here
        
        
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        char[] result = new char[Math.max(A.length, B.length) + 1];
        
        System.out.println(new String(result));
        
        int i = A.length - 1;
        int j = B.length - 1;
        int k = result.length - 1;
        
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                result[k--] = B[j--];
            } else if (j < 0) {
                result[k--] = A[i--]; 
            } else {
                result[k--] = (char)(A[i--] + B[j--]);
            }
        }
        
        System.out.println(new String(result));
        
        int flag = 0;
        
        for (int u = result.length - 1; u >= 0; u--) {
            
            int current = result[u] + flag;
            
            if (current > 1) {
                flag = current / 2;
                result[u] = (char)(current % 2);
            } else {
                flag = 0;
            }
        }
        
        String item = new String(result);
        
        return item.length() > 1 && item.charAt(0) == '\000' ? item.substring(1) : item;
    }

    public static void main(String[] args) {
        System.out.println(args[0]);
        System.out.println(args[1]);
        new Solution().addBinary(args[0], args[1]);
    }
}
