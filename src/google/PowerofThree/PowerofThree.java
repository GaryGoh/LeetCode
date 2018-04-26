package google.PowerofThree;

/**
 * Created by mgao on 2018/3/29.
 */
public class PowerofThree {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {return false;}
        if (n == 1) {return true;}
        int res = 1;
        while ((res *= 3) <= n && res < Integer.MAX_VALUE) {
            if (res == n) { return true;}
        }
        return false;
    }

    public static void main(String[] args) {
        PowerofThree p = new PowerofThree();
        System.out.println(p.isPowerOfThree(9));
        System.out.println(p.isPowerOfThree(1));
        System.out.println(p.isPowerOfThree(0));
        System.out.println(p.isPowerOfThree(-1));
//        System.out.println(p.isPowerOfThree(Integer.MAX_VALUE));
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MAX_VALUE * 3);
//        System.out.println(Integer.MAX_VALUE * 9);

    }
}
