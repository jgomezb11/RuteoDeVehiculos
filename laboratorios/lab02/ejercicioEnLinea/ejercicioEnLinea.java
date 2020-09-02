package Lab02;

public class ejercicioEnLinea {
    public int countEvens(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                count++;
            }
        }
        return count;
    }
    public int bigDiff(int[] nums){
        int maxAux = 0;
        int minAux = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length ;j++){
                maxAux = Math.max(nums[i],nums[j]);
                if(maxAux > max){
                    max = maxAux;
                }
                minAux = Math.min(nums[i],nums[j]);
                if(minAux < min){
                    min = minAux;
                }
            }
        }
        return max - min;
    }
    public boolean lucky13(int[] nums) {
        boolean has1 = false;
        boolean has3 = false;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                has1 = true;
            }
            if(nums[i] == 3){
                has3 = true;
            }
        }
        return !has1 && !has3;
    }
    public boolean has77(int[] nums) {
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == 7){
                if((nums[i+1] == 7) || (i != nums.length-2 && nums[i+2] == 7)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean has12(int[] nums) {
        boolean has1 = false;
        boolean has2 = false;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                has1 = true;
            }
            if(nums[i] == 2 && has1){
                has2 = true;
            }
        }
        return (has1&&has2)?true:false;
    }
    public int maxSpan(int[] nums) {
        int count = 0;
        int aux = 0;
        for(int i = 0; i < nums.length; i++){
            int firstDig = nums[i];
            for(int j = nums.length-1; j >= 0; j--){
                if(nums[j] == firstDig){
                    aux = j-i+1;
                    if(aux > count){
                        count = aux;
                    }
                }
            }
        }
        return count;
    }
    public int[] fix34(int[] nums) {
        int [] res = new int[nums.length];
        int [] pos3 = new int[nums.length];
        int [] pos4 = new int[nums.length];
        int iterator3 = 0;
        int iterator4 = 0;
        int aux = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 3){
                pos3[iterator3] = i;
                iterator3 += 1;
            }
            if(nums[i] == 4){
                pos4[iterator4] = i;
                iterator4 += 1;
            }
        }
        res = nums;
        int [] pos31= new int[iterator3];
        for(int i = 0; i < pos31.length; i++){
            pos31[i] = pos3[i];
        }
        for(int i = 0; i < pos31.length; i++){
            aux = res[pos31[i]+1];
            res[pos31[i]+1] = res[pos4[i]];
            res[pos4[i]] = aux;
        }
        return res;
    }
    public boolean canBalance(int[] nums) {
        int lSum = 0;
        for (int i = 0; i < nums.length; i++) {
            lSum += nums[i];
            int rSum = 0;
            for (int j = nums.length-1; j > i; j--) {
                rSum += nums[j];
            }
            if (rSum == lSum)
                return true;
        }
        return false;
    }

}
