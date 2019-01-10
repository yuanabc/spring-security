package com.ybinsure.icar.user.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * 获取唯一线程号
 *
 * @author HANHT
 */
public final class MDCUtil {
    private static final long MASK = 63L;
    private static final int RAND_LIMIT = 16777216;
    private static final int COUNT_LIMIT = 262144;
    private static char[] datas = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B'};
    private final Object syn = new Object();
    private Random r;
    private char[] initId = {'0'};
    private int counter = 0;
    private int ipJump;

    private MDCUtil(HttpServletRequest req) {
        int ipInt = getIPv4HashCode(req);

        this.ipJump = (Math.abs(ipInt % 64) + 1);
        long seed = System.currentTimeMillis() + ipInt;

        this.r = new Random(seed);
        this.initId[0] = datas[(this.r.nextInt(22) + 10)];
    }

    public static String getRandomId(HttpServletRequest req) {

        return new MDCUtil(req).make();
    }

    private String make() {
        char[] str = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'};

        long time = System.currentTimeMillis();
        int charPos = 8;
        do {
            str[(charPos--)] = datas[((int) (time & MASK))];
            time >>>= 6;
        } while (time != 0L);

        int count = getCount();
        charPos = str.length - 5;
        do {
            str[(charPos--)] = datas[((int) (count & MASK))];
            count >>>= 6;
        } while (count != 0);

        str[0] = this.initId[0];
        int rand = this.r.nextInt(RAND_LIMIT);
        charPos = str.length - 1;
        do {
            str[(charPos--)] = datas[((int) (rand & MASK))];
            rand >>>= 6;
        } while (rand != 0);

        return new String(str);
    }

    private synchronized int getCount() {
        synchronized (this.syn) {
            this.counter += this.ipJump;
            if ((this.counter < 0) || (this.counter > COUNT_LIMIT)) {
                this.counter = this.ipJump;

                try {
                    this.syn.wait(16L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return this.counter;
        }
    }

    /**
     * 获取ip的hashcode
     */
    private int getIPv4HashCode(HttpServletRequest request) {
        byte[] addr = textToNumericFormatV4(getIp(request));
        int address = -1;
        if (addr != null && addr.length == 4) {
            address = addr[3] & 0xFF;
            address |= ((addr[2] << 8) & 0xFF00);
            address |= ((addr[1] << 16) & 0xFF0000);
            address |= ((addr[0] << 24) & 0xFF000000);
        }

        return address;
    }

    /**
     * 获取request请求客户端IP地址
     */
    private String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        // 第一个非unknown的有效IP字符串
        if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (String s : ips) {
                if (!("unknown".equalsIgnoreCase(s))) {
                    ip = s;
                    break;
                }
            }
        }

        return ip;
    }

    /**
     * sun.net.util.IPAddressUtil
     */
    @SuppressWarnings("fallthrough")
    private byte[] textToNumericFormatV4(String param) {
        if (param == null || param.isEmpty()) {
            return null;
        }

        byte[] res = new byte[4];

        long tmpValue = 0;
        int currByte = 0;
        boolean newOctet = true;

        int len = param.length();
        if (len > 15) {
            return null;
        }
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (c == '.') {
                if (newOctet || tmpValue < 0 || tmpValue > 0xff || currByte == 3) {
                    return null;
                }
                res[currByte++] = (byte) (tmpValue & 0xff);
                tmpValue = 0;
                newOctet = true;
            } else {
                int digit = Character.digit(c, 10);
                if (digit < 0) {
                    return null;
                }
                tmpValue *= 10;
                tmpValue += digit;
                newOctet = false;
            }
        }
        if (newOctet || tmpValue < 0 || tmpValue >= (1L << ((4 - currByte) * 8))) {
            return null;
        }

        switch (currByte) {
            case 0:
                res[0] = (byte) ((tmpValue >> 24) & 0xff);
            case 1:
                res[1] = (byte) ((tmpValue >> 16) & 0xff);
            case 2:
                res[2] = (byte) ((tmpValue >> 8) & 0xff);
            case 3:
                res[3] = (byte) ((tmpValue >> 0) & 0xff);
        }
        return res;
    }
}
