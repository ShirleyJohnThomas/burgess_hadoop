package com.burgess.hadoop.hdfs;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

import java.io.InputStream;
import java.net.URL;

/**
 * @author burgess.zhang
 * @project burgess-hadoop
 * @package com.burgess.hadoop.hdfs
 * @file URLCat.java
 * @time 2018-06-20 上午11:42
 * @desc urlcat 类
 */
public class URLCat {

    static {
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
    }

    public static void main(String[] args)throws Exception{
        InputStream input = null;
        try{
            input = new URL(args[0]).openStream();
            IOUtils.copyBytes(input,System.out,4096,false);
        }finally {
            IOUtils.closeStream(input);
        }
    }
}
