import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightsNameMapper extends Mapper<LongWritable, Text, FlightsWritableComparable, Text> {

    private static final String DELIMINTER = "\","

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (key.get() > 0) {
            String[] table = value.toString().split(DELIMINTER)
        }
    }

}
