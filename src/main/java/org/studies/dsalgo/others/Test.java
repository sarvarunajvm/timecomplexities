package org.studies.dsalgo.others;

public class Test {

    public static void main(String[] args) {
        String str1 = "altimetrikabc";
        String str2 = "abcaltimetrikalti";
        Test test = new Test();
        test.findLongestSubsequents(str1, str2);
    }

    public void findLongestSubsequents(String str1, String str2) {


        char[] string1Arr = str1.toCharArray();
        char[] string2Arr = str2.toCharArray();

        int num = lcs(string1Arr, string2Arr, string1Arr.length, string2Arr.length);

        System.out.println(num);

    }

    public int commonSubSeq(char[] string1Arr, char[] string2Arr, int string1Len, int string2Len) {

        // compare it from right to left
//        System.out.println(string1Arr);
//        System.out.println(string2Arr);
//        System.out.println(string1Len);
//        System.out.println(string2Len);

        if (string1Len == 0 || string2Len == 0) {
            return 0;
        }

        // minus one is to avoid arrayindexoutofbounds
        if (string1Arr[string1Len - 1] == string2Arr[string2Len - 1]) {
            System.out.println("Equals");
            System.out.println(string1Arr[string1Len - 1]);
            System.out.println(string2Arr[string2Len - 1]);
            return 1 + commonSubSeq(string1Arr, string2Arr, string1Len - 1, string2Len - 1);
        } else {
            return max(commonSubSeq(string1Arr, string2Arr, string1Len, string2Len - 1), commonSubSeq(string1Arr, string2Arr, string1Len - 1, string2Len));
        }

    }

    int lcs( char[] X, char[] Y, int m, int n )
    {
        int L[][] = new int[m+1][n+1];

    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i-1] == Y[j-1])
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = max(L[i-1][j], L[i][j-1]);
            }
        }
        return L[m][n];
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }
}
