package L100.L101.hash;

import org.apache.commons.codec.digest.DigestUtils;

public class ToSHA2 {
    public String getDigest(String before) {
        // SHA256でハッシュ
        return DigestUtils.sha256Hex(before);
    }
}