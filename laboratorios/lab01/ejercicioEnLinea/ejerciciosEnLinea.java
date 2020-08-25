package Lab01;

public class ejerciciosEnLinea {

    //Recursión 1
    //Ejercicio 1
    public int factorial(int n) {
        if(n == 0){
            return 1;
        }
        return n * factorial(n-1);
    }
    //T(n) = c_2 + T(n-1)

    //Ejercicio 2

    public int bunnyEars(int bunnies) {
        if(bunnies == 0){
            return 0;
        }
        return 2 + bunnyEars(bunnies-1);
    }
    // T(n) = c_3 + 2 + T(n-1)

    //Ejercicio 3

    public int fibonacci(int n) {
        if(n == 0){
            return 0;
        }if(n == 1){
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
    // T(n) = T(n-1) + T(n-2)
    //Ejercicio 4


    public int bunnyEars2(int bunnies) {
        if(bunnies == 0){
            return 0;
        }
        return (bunnies % 2 == 0)? 3 + bunnyEars2(bunnies - 1): 2 + bunnyEars2(bunnies - 1);
    }
    // T(n) = T(n-1) + c_1
    //Ejercicio 5

    public int triangle(int rows) {
        if(rows == 0){
            return 0;
        }
        return rows + triangle(rows - 1);
    }
    //T(n) = c_2 + T(n-1)

    //Recursión 2
    //Ejercicio 1
    public boolean groupSum6(int start, int[] nums, int target) {
        if(start == nums.length){
            return target == 0;
        }
        if(groupSum6(start+1, nums, target - nums[start]) || (nums[start] != 6 && groupSum6(start+1, nums, target))){ return true;}
        return false;
    }
    //T(n) = 2 T(n-1) + c_2

    //Ejercicio 2
    public boolean groupNoAdj(int start, int[] nums, int target) {
        if(start >= nums.length){
            return target == 0;
        }
        if (groupNoAdj(start+1, nums, target) || (groupNoAdj(start+2, nums, target-nums[start]))){return true;}
        return false;
    }
    // T(n) = 2 T(n-1) + c_2

    //Ejercicio 3

    public static boolean split53(int[] nums) {
        int index = 0;
        int sum1 = 0;
        int sum2 = 0;
        return recArray(nums, index, sum1, sum2);
    }

    private static boolean recArray ( int[] nums, int index, int sum1, int sum2 ) {
        if ( index >= nums.length ) {
            return sum1 == sum2;
        }
        int value = nums[index];
        if (value%5 == 0) {
            return recArray(nums, index + 1, sum1 + value, sum2);
        } else if (value%3 == 0) {
            return recArray(nums, index + 1, sum1, sum2 + value);
        } else {
            return (recArray(nums, index + 1, sum1 + value, sum2) ||
                    recArray(nums, index + 1, sum1, sum2 + value));
        }
    }
    //T(n) = 2 T(n-1) + c_2

    //Ejercicio 4
    public boolean groupSumClump(int start, int[] nums, int target) {
        altArray(nums);
        if (start >= nums.length) return target == 0;
        if (groupSumClump(start+1, nums, target-nums[start])) return true;
        if (groupSumClump(start+1, nums, target)) return true;
        else return false;
    }
    private void altArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                nums[i-1] += nums[i];
                if (i+1 < nums.length && nums[i] != nums[i+1])
                    nums[i] = 0;
                else if (i == nums.length-1)
                    nums[i] = 0;
            }
        }
    }
    // T(n) = 2 T(n-1) + c_2

    //Ejercicio 5
    public static boolean splitArray(int[] nums) {
        return splitArrayHelper(0, nums, 0, 0);
    }

    public static boolean splitArrayHelper(int start, int[] nums, int group1, int group2) {
        if (start >= nums.length) {
            return group1 == group2;
        }
        if (splitArrayHelper(start+1, nums, group1 + nums[start], group2)) {
            return true;
        }
        if (splitArrayHelper(start+1, nums, group1, group2 + nums[start])) {
            return true;
        }
        return false;
    }
    //T(n) = 2 T(n-1) + c_2

}
