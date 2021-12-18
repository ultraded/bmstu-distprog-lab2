import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class FlightsGroupingComparator extends WritableComparator {

    @Override
    public int compare(WritableComparable a,WritableComparable b) {
        FlightsWritableComparable flightA = (FlightsWritableComparable) a, flightB = (FlightsWritableComparable) b;
        return FlightsWritableComparable.compare(flightA, flightB);
    }
}