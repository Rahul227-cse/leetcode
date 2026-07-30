class Solution {
    public int minimumPushes(String word) {
       int n = word.length();
       int a = 0;
       for(int i = 0;i < n ; i++){
        a += (i / 8) + 1;
       }
       return a; 
    }
}