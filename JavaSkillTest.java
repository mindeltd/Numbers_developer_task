public class JavaSkillTest{
    
    public static final int A_FACTOR = 16807;
    public static final int B_FACTOR = 48271;
    public static final int DIVISOR = 2147483647;
    public static final int NUM_OF_LAST_BITS = 8;
    public static final int NUM_OF_COMPARISONS = 1000000;
    
    public Long [] numbers;

    public static void main(String[] args) {
        JavaSkillTest obj = new JavaSkillTest();
        obj.numbers = new Long[]{Long.parseLong(args[0]) , Long.parseLong(args[1]) };
        int count = 0;
        for(int i = 0; i< NUM_OF_COMPARISONS; i++){
            obj.numbers = obj.iteration(obj.numbers);
            count += obj.compare(obj.numbers);
        }
        System.out.println(count);
    }

    public Long [] iteration(Long [] numbers){
        Long a_multiply = numbers[0] * A_FACTOR;
        Long b_muliply  = numbers[1] * B_FACTOR;
        numbers[0] = a_multiply % DIVISOR;
        numbers[1] = b_muliply  % DIVISOR;
        return numbers;
    }

    public int compare (Long [] numbers){
        String a_string = "0000000" + Long.toBinaryString(numbers[0]); 
        String b_string = "0000000" + Long.toBinaryString(numbers[1]);
        a_string = a_string.substring(a_string.length() - NUM_OF_LAST_BITS,a_string.length());
        b_string = b_string.substring(b_string.length() - NUM_OF_LAST_BITS,b_string.length());
        if (a_string.equals(b_string))
            return 1;
        else
            return 0;
    }
}