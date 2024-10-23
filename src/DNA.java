

/**
 * DNA
 * <p>
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *</p>
 * <p>
 * Completed by: NIKO MADRIZ
 *</p>
 */

public class DNA {

    /**
     * TODO: Complete this function, STRCount(), to return longest consecutive run of STR in sequence.
     */
    private static long hashP;
    private static int hash;
    private static int m;
    private static long p = 718064159;
    private static int R = 256;
    private static long rm;
    public static int STRCount(String sequence, String STR) {
        hash = 0;
        int n = sequence.length();
        m = STR.length();
        rm = 1;
        long textHash = 0;
        int counter = 0;
        for (int i = 0; i <= m; i++) {
            rm = (R * rm) % p;
        }
        for (int i = STR.length(); i < sequence.length(); i++) {
            hashP = hash(STR, m, i);
            textHash = hash(STR, m, i);
            if (hashP == textHash) {
                counter++;
            }
            textHash = (textHash + p - rm * sequence.charAt(i - m) % p) % p;
            textHash = (textHash * R + sequence.charAt(i)) % p;
            if (hashP == textHash) {
                while (hashP == textHash) {
                    counter++;
                    hash(sequence, m, i);
                }
            }
        }
        return counter;
    }


    private static long hash(String key, int m, int start) {
        long h = 0;
        for (int i = start; i < start + m; i++) {
            h = (R * h + key.charAt(i)) % p;
        }
        return h;
    }
}
