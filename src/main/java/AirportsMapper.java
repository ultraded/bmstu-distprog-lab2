import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirportsMapper extends Mapper<LongWritable, Text, FlightsWritableComparable, Text> {

    private static final String DELIMINTER = ",";
    private static final int AIRPORT_ID_INDEX = 0, AIRPORT_NAME_INDEX = 1;
    private static final boolean AIRPORT_WC_IDENTIFICATION = true;

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (key.get() > 0) {
            String[] airports = value.toString().split(DELIMINTER);
            int destinationID = Integer.parseInt(airports[AIRPORT_ID_INDEX].replace("\"", ""));
            FlightsWritableComparable currKey = new FlightsWritableComparable(destinationID, AIRPORT_WC_IDENTIFICATION);
            context.write(currKey, new Text(airports[AIRPORT_NAME_INDEX]));
        }
    }

}
