package com.algorithm.base.hash.uniqueflag;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author dongfengfeng on 2020-01-31
 */
public class FileUnique {

    private static final int SPLIT_SIZE = 1024;

    private static final int READ_LENGTH = 128;

    private static MessageDigest MD;

    static {
        try {
            MD = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String fileUnique(String path) {
        FileInputStream input = null;
        FileChannel channel = null;
        try {
            input = new FileInputStream(path);
            if (input.available() > SPLIT_SIZE) {

                channel = input.getChannel();
                long size = channel.size();
                ByteBuffer buffer = ByteBuffer.allocate(READ_LENGTH * 3 + 8);
                buffer.limit(READ_LENGTH);
                channel.read(buffer);

                long mid = size / 2;
                channel.position(mid);
                buffer.limit(READ_LENGTH * 2);
                channel.read(buffer);

                long last = size - (buffer.capacity() * 2);
                channel.position(last);
                buffer.limit(READ_LENGTH * 3);
                channel.read(buffer);

                buffer.limit(READ_LENGTH * 3 + 8);
                buffer.putLong(size);

                return getMD5(buffer.array());
            } else {
                byte[] countbyte = new byte[READ_LENGTH];
                input.read(countbyte);
                return getMD5(countbyte);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static String getMD5(byte[] countsrc) {
        try {
            // 计算md5函数
            MD.update(countsrc);

            StringBuilder hexString = new StringBuilder();

            byte[] hash = MD.digest();
            for (int i = 0; i < hash.length; i++) {
                if ((0xff & hash[i]) < 0x10) {
                    hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
                } else {
                    hexString.append(Integer.toHexString(0xFF & hash[i]));
                }
            }

            return hexString.toString();

            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            //      return new BigInteger(1, md.digest()).toString(16);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
