
import java.util.ArrayList;
import java.util.Hashtable;
import java.lang.Math;
/*
This program is a failed final round interview question for MicroSoft that has haunted me
since I failed...
The question was to find the longest contigous non-intersecting substring
This program outlines what I tried attempting during that interview which 
was the brute force method O(n^3) runtime
*/
class LongestNonInterContigSS{
    //MaxItem class to find all of the stuff we might need with the MaxSS
    static class MaxItem{
        private int val;
        private String word;
        public MaxItem(int val, String word){
            this.val = val;
            this.word = word;
        }
    }
    public static boolean safeCheck(String s1, String s2){
        return s1.equals(s2);
    }

    //method to find answer brute-force
    public static MaxItem findAnswer(String s){
        System.out.println(s);
        int maxSize = 0;
        String substring = "";
        int searchSize = s.length()/2;
        MaxItem res = new MaxItem(maxSize, substring);
        for(int i=0;i<searchSize;i++){
            for(int j=i;j<searchSize;j++){
                int len = ((j+j)-i)+2;
                String ss = s.substring(i,j+1);
                int ssLen = ss.length();
                if(safeCheck(ss, s.substring(j+1, len))){
                    if(ssLen > maxSize){
                        res = new MaxItem(ssLen, ss);
                        maxSize = ssLen;
                    }
                }
                else{
                    continue;
                }
            }
        }
        //System.out.println("resulting: "+res.val +" | "+res.word);
        //System.out.println("----------------------------");
        return res;
    }
    public static void main(String[] args){
        String[] testcases = {
            "abcabckababaz",
            "aaaaaaaaaaa",
            "aabaabaaba",
            "banana"
        };
        ArrayList<MaxItem> finals = new ArrayList<MaxItem>();
        for( int i=0;i<testcases.length;i++){
            finals.add(findAnswer(testcases[i]));
        }
        for(int index=0;index<finals.size();index++){
            MaxItem found = finals.get(index);
            System.out.println(found.val +" "+found.word);
            
        }
    }
}
