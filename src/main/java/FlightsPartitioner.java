import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class FlightsPartitioner extends Partitioner<FlightsWritableComparable, Text> {
    @Override
    public int getPartition(FlightsWritableComparable key, Text text, int i) {
        return key.getID() % i;
    }
}
