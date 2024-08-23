package org.practices;

public class largestpalindromeInString {

    public static void main(String[] args){
        longestPalin("pravneen");
    }
    static String longestPalin(String S){
        // code here
        int start=0;
        int end=0;
        int low,high;
        int n=S.length();
        for(int i=0;i<n;i++)
        {
            // even length
            low=i;
            high=i+1;

            while(low>=0 && high<n && S.charAt(low)==S.charAt(high))
            {
                if((end-start)<(high-low))
                {
                    start=low;
                    end=high;
                }
                low--;
                high++;
            }

            // Odd length

            low=i;
            high=i+2;
            while(low>=0 && high<n && S.charAt(low)==S.charAt(high))
            {
                if((end-start)<(high-low))
                {
                    start=low;
                    end=high;
                }
                low--;
                high++;
            }
        }
        return S.substring(start,end+1);
    }
}


