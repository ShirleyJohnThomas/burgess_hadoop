package com.burgess.hadoop.hdfs;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.PathFilter;

/**
 * @author burgess.zhang
 * @project burgess-hadoop
 * @package com.burgess.hadoop.hdfs
 * @file RegexExcludePathFilter.java
 * @time 2018-06-20 下午4:28
 * @desc
 */
public class RegexExcludePathFilter implements PathFilter {

    private String regex;

    public RegexExcludePathFilter(String regex){
        this.regex =regex;
    }

    @Override
    public boolean accept(Path path) {
        return !path.toString().matches(regex);
    }
}
