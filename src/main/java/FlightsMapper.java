import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightsMapper extends Mapper<LongWritable, Text, FlightsWritableComparable, Text> {
    private static final String DELIMITER = ",";
    private static final int AIPORT_ID_INDEX = 14, DELAY_INDEX = 17;
    private static final boolean FLIGHT_WC_IDENTIFICATION = false;

    private static float parseFloatWithNull(String s) {
        if (s.equals("")) return 0f;
        else return Float.parseFloat(s);
    }

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException  {
        if (key.get() > 0) {
            String[] flights = value.toString().split(DELIMITER);
            int airportID = Integer.parseInt(flights[AIPORT_ID_INDEX]);
            float delay = parseFloatWithNull(flights[DELAY_INDEX]);
            if (delay > 0.0f) {
                FlightsWritableComparable currKey = new FlightsWritableComparable(airportID, FLIGHT_WC_IDENTIFICATION);
                context.write(currKey, new Text(flights[DELAY_INDEX]));
            }
        }
    }
}
