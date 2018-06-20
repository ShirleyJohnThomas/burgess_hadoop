package com.burgess.hadoop.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.InputStream;
import java.net.URI;

/**
 * @author burgess.zhang
 * @project burgess-hadoop
 * @package com.burgess.hadoop.hdfs
 * @file FileSystemCat.java
 * @time 2018-06-20 下午4:03
 * @desc
 */
public class FileSystemCat {

    public static void main(String[] args)throws Exception{
        String uri = args[0];
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri),conf);
        InputStream input = null;
        try {
            input = fs.open(new Path(uri));
            IOUtils.copyBytes(input,System.out,4096,false);
        }finally {
            IOUtils.closeStream(input);
        }
    }

}
