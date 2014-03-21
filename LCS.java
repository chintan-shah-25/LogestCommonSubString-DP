/* public static void main(String[] args) {
        
        String x="abcba";
        String y="babca";
        int l=LCS.lengthLCS(x,y);
        System.out.println("Length of Longest Common SubString is "+l);
    }
*/

 public static int lengthLCS(String x, String y)
    {
      int m=x.length();
      int n=y.length();
      int result=0;
      if(m==0||n==0)                                            //If any of the substring is empty we retrun zero
          return 0;
      int res[][]=new int[m][n];
      for(int i=0;i<m;i++)
      {
        if(x.charAt(i)==y.charAt(0))
        {
            res[i][0] = 1;
            result=1;
         }
        else
            res[i][0]=0;
      }
      for(int j=0;j<n;j++)
      {
        if(y.charAt(j)==x.charAt(0))
        {
            res[0][j] = 1;
            result=1;
        }
            else
            res[0][j]=0;
      }
       for(int i=1;i<m;i++)
           for(int j=1;j<n;j++)
           {
               if(x.charAt(i)==y.charAt(j))
               {
                  result=Math.max(result,res[i-1][j-1]+1);       
                  res[i][j]=res[i-1][j-1]+1;
               }
               else
                   res[i][j]=0;
           }
       for(int i=0;i<m;i++)                                             //prints entire table for better understanding
       { System.out.println();
           for(int j=0;j<n;j++)
           {
             System.out.print("\t"+res[i][j]);
           }
       }
      return result;
    }

/*        b        a        c        b        a

   a      0        1        0        0        1
   b      1        0        2        0        0
   c      0        0        0        3        0
   b      1        0        1        0        0
   a      0        2        0        0        1
   
   first "b" of string "bacba" is compared with every character of "abcba"
   then every character of "abcba" is compared to first character "b" of "bacba". so initially first row 
   and first column are compelted.
   Then every new entry is calculated based on the its diagonal entry.

*/

