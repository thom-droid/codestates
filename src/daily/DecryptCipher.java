package daily;

public class DecryptCipher {

    public static String decryptCaesarCipher(String str, int secret) {
        if (str.length() == 0) {
            return str;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);

            if (letter == 32) {
                sb.append(letter);
                continue;
            }

            if (letter - secret < 97) {
                letter += (26 - secret);
            } else {
                letter -= secret;
            }

            sb.append(letter);

        }

        return sb.toString();
    }


    public static void main(String[] args) {
//        System.out.println(decryptCaesarCipher("khoor zruog", 3));
//        System.out.println(decryptCaesarCipher("zruog", 3));
        System.out.println(decryptCaesarCipher( "mnv xnt zqd qdzcx sn lnud sn hlldqrhud bntqrd", 25));

    }
}
