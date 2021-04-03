package pl.wsz.users;

import java.math.BigInteger;
import java.security.SecureRandom;

public final class HashClass {
    private static SecureRandom random = new SecureRandom();

    public static String getHash(){
        return new BigInteger(130, random).toString(32);
    }

    public static void main(String[] args) {
        System.out.println(getHash());
    }
}