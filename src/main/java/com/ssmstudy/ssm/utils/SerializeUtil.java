package com.ssmstudy.ssm.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeUtil {


    /**
     * 序列化
     * @param object
     * @return
     */
    public static byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 反序列化
     * @param bytes
     * @return
     */
    public static Object unserialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 序列化存储list
     * @param list
     * @return
     * @throws IOException
     */
    public static byte[] serializeList(List<Object> list) throws IOException {
        if (list == null) {
            throw new NullPointerException("Can't serialize null");
        }
        byte[] rv = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;
        try {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            for (Object o : list) {
                os.writeObject(o);
            }
            os.writeObject(null);
            rv = bos.toByteArray();
        } catch (IOException e) {
            throw new IllegalArgumentException("Non-serializable object", e);
        } finally {
            if (os != null) {
                os.close();
            }
            if (bos != null) {
                bos.close();
            }
        }
        return rv;
    }

    /**
     * 反序列化
     * @param in
     * @return
     * @throws IOException
     */
    public static List<Object> deserialize(byte[] in) throws IOException {
        List<Object> list = new ArrayList<Object>();
        ByteArrayInputStream bis = null;
        ObjectInputStream is = null;
        try {
            if (in != null) {
                bis = new ByteArrayInputStream(in);
                is = new ObjectInputStream(bis);
                while (true) {
                    Object object = is.readObject();
                    if (object == null) {
                        break;
                    } else {
                        list.add(object);
                    }
                }
            }
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        } finally {
            if (is != null) {
                is.close();
            }
            if (bis != null) {
                bis.close();
            }
        }
        return list;
    }
}