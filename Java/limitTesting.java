public class limitTesting {

    public static boolean isPalindrome(long number) {
        if (number < 0) {
            return false;
        }

        String stringNumber = Long.toString(number);
        int size = stringNumber.length();

        if (size > 1) {
            for (int i = 0; i < (size / 2); i++) {
                if (stringNumber.charAt(i) != stringNumber.charAt(size - 1 - i)) {
                    return false;
                }
            }
            return true;
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.printf("%b", isPalindrome(884994887));

    }

}