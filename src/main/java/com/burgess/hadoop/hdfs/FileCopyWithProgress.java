package com.burgess.hadoop.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

/**
 * @author burgess.zhang
 * @project burgess-hadoop
 * @package com.burgess.hadoop.hdfs
 * @file FileCopyWithProgress.java
 * @time 2018-06-20 下午4:07
 * @desc
 */
public class FileCopyWithProgress {

    public static void main(String[] args)throws Exception{
        String localSrc = args[0];
        String dst = args[1];

        InputStream input = new BufferedInputStream(new FileInputStream(localSrc));

        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(dst),conf);

        OutputStream output = fs.create(new Path(dst), new Progressable() {
            @Override
            public void progress() {
                System.out.println(".");
            }
        });
        IOUtils.copyBytes(input,output,4096,true);
    }

}
