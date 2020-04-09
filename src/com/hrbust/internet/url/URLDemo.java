package com.hrbust.internet.url;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @program: reviewJava
 * @description: url编程
 * @author: Abner
 * @create: 2020-03-01 19:07
 */
public class URLDemo {
    public static void main(String[] args)  {
        InputStream is = null;
        BufferedOutputStream bos = null;
        try {
            URL url = new URL("http://data.vod.itc.cn/?rb=1&key=jbZhEJhlqlUN-Wj_HEI8BjaVqKNFvDrn&prod=flash&pt=1&new=/51/116/UdKGIuSjQIO8dynrybyS1E.mp4");
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();
            is = urlConnection.getInputStream();
            FileOutputStream fos = new FileOutputStream("E:\\WorkSpace\\Inteljidea\\reviewJava\\src\\file\\UdKGIuSjQIO8dynrybyS1E.mp4");
            bos = new BufferedOutputStream(fos);

            byte[] bucf = new byte[1024];
            int len;
            while ((len = is.read(bucf)) != -1) {
                bos.write(bucf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
