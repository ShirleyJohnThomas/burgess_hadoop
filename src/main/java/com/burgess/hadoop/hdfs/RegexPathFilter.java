package com.burgess.hadoop.hdfs;

import org.apache.hadoop.fs.Path;

/**
 * @author burgess.zhang
 * @project burgess-hadoop
 * @package com.burgess.hadoop.hdfs
 * @file RegexPathFilter.java
 * @time 2018-06-20 下午4:20
 * @desc
 */
public class RegexPathFilter {

    private String regex;
    private boolean include;

    public RegexPathFilter(String regex){
        this.regex =regex;
    }
    public RegexPathFilter(String regex,boolean include){
        this.regex =regex;
        this.include = include;
    }

    public boolean accept(Path path) {
        return (path.toString().matches(regex)) ? include : !include;
    }
}
