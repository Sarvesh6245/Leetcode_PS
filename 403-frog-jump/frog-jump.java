class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer,HashSet<Integer>>map=new HashMap<>();
        for(int stone:stones){
            map.put(stone,new HashSet<>());
        }

        map.get(stones[0]).add(1);
        for(int i=0;i<stones.length;i++){
            int stone=stones[i];
            for(int jumpsize:map.get(stone)){
                int reach=stone+jumpsize;

                if(reach==stones[stones.length-1]){
                    return true;
                }

                if(map.containsKey(reach)){
                    if(jumpsize-1>0){
                        map.get(reach).add(jumpsize-1);
                    }
                    map.get(reach).add(jumpsize);
                    map.get(reach).add(jumpsize+1);
                }
            }
        }
    
   return false;
        
    }
}