package Controller;

import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * PasswordUtil — Secure password hashing using PBKDF2WithHmacSHA256.
 *
 * Implements a cryptographically strong, one-way salted hash using the
 * PBKDF2-HMAC-SHA256 key derivation function from Java's standard library.
 *
 * Hash format stored in the database:
 *   PBKDF2:<Base64-salt>:<Base64-hash>
 *
 * Security properties:
 *   - 16-byte cryptographically random salt (unique per password)
 *   - 65,536 PBKDF2 iterations (NIST SP 800-132 recommended minimum)
 *   - 256-bit output key length
 *   - Constant-time comparison to prevent timing attacks
 */
public class PasswordUtil {

    private static final String ALGORITHM  = "PBKDF2WithHmacSHA256";
    private static final int    ITERATIONS  = 65536;
    private static final int    KEY_BITS    = 256;
    private static final int    SALT_BYTES  = 16;
    private static final String PREFIX      = "PBKDF2:";

    /**
     * Hash a plaintext password and return a storable string.
     */
    public static String hashPassword(String password) {
        try {
            byte[] salt = new byte[SALT_BYTES];
            new SecureRandom().nextBytes(salt);

            KeySpec spec = new PBEKeySpec(
                    password.toCharArray(), salt, ITERATIONS, KEY_BITS);
            SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
            byte[] hash = factory.generateSecret(spec).getEncoded();

            return PREFIX
                    + Base64.getEncoder().encodeToString(salt)
                    + ":"
                    + Base64.getEncoder().encodeToString(hash);
        } catch (Exception ex) {
            throw new RuntimeException("Password hashing failed");
        }
    }

    /**
     * Verify a plaintext password against a stored hash.
     * Uses constant-time comparison to prevent timing attacks.
     */
    public static boolean verifyPassword(String password, String stored) {
        try {
            if (!stored.startsWith(PREFIX)) return false;

            String[] parts = stored.substring(PREFIX.length()).split(":");
            if (parts.length != 2) return false;

            byte[] salt         = Base64.getDecoder().decode(parts[0]);
            byte[] expectedHash = Base64.getDecoder().decode(parts[1]);

            KeySpec spec = new PBEKeySpec(
                    password.toCharArray(), salt, ITERATIONS, KEY_BITS);
            SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
            byte[] actualHash = factory.generateSecret(spec).getEncoded();

            // Constant-time comparison — prevents timing side-channel attacks
            if (actualHash.length != expectedHash.length) return false;
            int diff = 0;
            for (int i = 0; i < actualHash.length; i++) {
                diff |= actualHash[i] ^ expectedHash[i];
            }
            return diff == 0;

        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Returns true if the string looks like a hash produced by this class.
     * Used by the migration to skip already-hashed passwords.
     */
    public static boolean isHashed(String password) {
        return password != null && password.startsWith(PREFIX);
    }
}
