package project;

import java.nio.charset.Charset;

public class EmojiDecoder {
    byte[] LaughemojiBytes = new byte[]{(byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x82};
    String LaughemojiAsString = new String(LaughemojiBytes, Charset.forName("UTF-8"));
    byte[] SademojiBytes = new byte[]{(byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x82};
    String SademojiAsString = new String(SademojiBytes, Charset.forName("UTF-8"));

    String decodeEmojis(String msg) {
        msg = msg.replace(":)", LaughemojiAsString);
        msg = msg.replace(":(", SademojiAsString);
        return msg;
    }
}
