//         9  8
// ×       2  1
// -------------
//        (9)(8)
//   (18)(16)
// -------------
//   (18)(25)(8)
// ---------------------

public class Multiply {

    public void multiply(String one, String another) {

        int[] result = new int[one.length() + another.length()];

        for (int i = 0; i < one.length(); i++) {
            for (int j = 0; j < another.length(); j++) {
                result[i + j + 1] += (one.charAt(i) - '0') * (another.charAt(j) - '0');
            }
        }

        for (int k = result.length - 1; k > 0; k--) {
            result[k - 1] += result[k] / 10;
            result[k] = result[k] % 10;
        }

        Arrays.stream(result).forEach(System.out::print);
    }

    public void karatsuba(String one, String another) {

    }
}
