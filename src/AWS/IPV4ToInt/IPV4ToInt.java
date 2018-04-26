package AWS.IPV4ToInt;

/**
 * Created by mgao on 2017/3/22.
 */
public class IPV4ToInt {

    public static long IPV4ToInt(String ipAddress){
        String[] parse = ipAddress.split("\\.");
        long ipIntValue = 0;
        long ipValue = 0;
        if (parse.length != 4) throw new IllegalArgumentException("ip address is not valid");

        try{
            for (int i = 0; i < parse.length; i++){
                ipValue = Long.parseLong(parse[i]);

                if (ipValue > 255 || ipValue < 0) throw new IllegalArgumentException("The value should is out of scope of IPV4 value.");
                ipIntValue +=  ipValue << (8 * (3 - i));
            }
            return ipIntValue;
        } catch (NumberFormatException numEx){
            throw numEx;
        }

    }
    public static String IntToIPV4(long ipValue){
        StringBuffer strBuf = new StringBuffer();
//        for (int i = 0; i < 3; i ++){
//            strBuf.append((ipValue & (0xFFFFFF >> 8 * i)) >> 8 * (3 - i));
//            strBuf.append(".");
//        }
        strBuf.append(ipValue >> 24);
        strBuf.append(".");
        strBuf.append((ipValue & (0x00FFFFFF)) >> 16);
        strBuf.append(".");
        strBuf.append((ipValue & (0x00FFFFFF >> 8)) >> 8);
        strBuf.append(".");
        strBuf.append((ipValue & (0x00FFFFFF >> 16)));

        return strBuf.toString();
    }

    public static void main(String[] args){
        String ip = "255.255.255.255";
        String ip2 = "127.0.0.1";
        String ip3 = "0.0.0.0";

        long intValue = IPV4ToInt(ip3);
        String ipAdd = IntToIPV4(intValue);
        System.out.println(intValue);
        System.out.println(ipAdd);

    }
}
