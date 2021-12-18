import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FlightsMapper extends Mapper<LongWritable, Text > {
    private static final String DELIMITER = ",";
    private static final int AIPORT_ID_INDEX = 14, DELAY_INDEX = 17;
    private static final bool AIRPORT_WC_IDENTIFICATION
}
