package pl.wsz.users;

import java.math.BigInteger;
import java.security.SecureRandom;

public final class HashClass {
    private SecureRandom random = new SecureRandom();

    public String getHash(){
        return new BigInteger(130, random).toString(32);
    }
}