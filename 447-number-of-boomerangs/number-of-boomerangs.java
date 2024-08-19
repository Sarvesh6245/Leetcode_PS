class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int ans=0;
      for(int i=0;i<points.length;i++){
        for(int j=i+1;j<points.length;j++){
            for(int k=j+1;k<points.length;k++){
            int d1=f(points[i],points[j]);
            int d2= f(points[i],points[k]);
            int d3=f(points[j],points[k]);
           
           if(d1==d2&&d2==d3){
             System.out.println(d1+" "+d2+" "+d3);
            ans=ans+2;
            continue;
           }
            if(d1==d2){
                 System.out.println(d1+" "+d2+" "+d3);
                ans=ans+2;
                continue;
            }
            if(d2==d3){
                 System.out.println(d1+" "+d2+" "+d3);
                ans=ans+2;
                continue;
            }
            if(d3==d1){
                 System.out.println(d1+" "+d2+" "+d3);
            ans=ans+2;
            continue;
            }
            }
        }
      }  
      return ans;
    }
    public int f(int[]a,int[]b){
        return (a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]);
    }
}