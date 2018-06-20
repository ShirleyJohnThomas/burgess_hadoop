package com.burgess.hadoop.hdfs;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.PathFilter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author burgess.zhang
 * @project burgess-hadoop
 * @package com.burgess.hadoop.hdfs
 * @file DateRangePathFilter.java
 * @time 2018-06-20 下午4:12
 * @desc
 */
public class DateRangePathFilter implements PathFilter {

    private final static Pattern PATTERN = Pattern.compile("^.*/(\\d\\d\\d\\d/\\d\\d/\\d\\d).*$");

    private  Date start;
    private Date end;

    public DateRangePathFilter(Date start,Date end){
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean accept(Path path) {
        Matcher matcher = PATTERN.matcher(path.toString());
        if (matcher.matches()){
            DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            try {
                return inInterval(format.parse(matcher.group(1)));
            }catch (ParseException e){
                return false;
            }
        }
        return false;
    }

    private boolean inInterval(Date date){
        return !date.before(start) && !date.after(end);
    }

}
