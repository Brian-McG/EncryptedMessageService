package storage;

import encryption.RSA;
import org.junit.Test;

import java.io.File;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

import static org.junit.Assert.assertNotNull;

/**
 * <h1>STORE Test</h1>
 * A class that tests the functionality of the STORE class
 * @author Michael Kyeyune
 * @since 2016-03-31
 */
public class STORETest
{
    private static final String PUBLIC_KEY_FILE_PATH = "public.store";
    private static final String PRIVATE_KEY_FILE_PATH = "private.store";

    private static void deleteFile(String fileName)
    {
        File file = new File(fileName);
        file.delete();
    }

    @Test
    public void storageTest()
    {
        KeyPair keyPair = RSA.generateKeyPair(1024);

        STORE.savePublicKeyToFile(PUBLIC_KEY_FILE_PATH, keyPair.getPublic());
        STORE.savePrivateKeyToFile(PRIVATE_KEY_FILE_PATH, keyPair.getPrivate());

        PublicKey publicKey = STORE.readPublicKeyFromFile(PUBLIC_KEY_FILE_PATH);
        assertNotNull(publicKey);

        PrivateKey privateKey = STORE.readPrivateKeyFromFile(PRIVATE_KEY_FILE_PATH);
        assertNotNull(privateKey);

        //delete the created files
        deleteFile(PUBLIC_KEY_FILE_PATH);
        deleteFile(PRIVATE_KEY_FILE_PATH);
    }
}
