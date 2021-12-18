import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class FlightsGroupingComparator extends WritableComparator {

    @Override
    public int compare(WritableComparable a,WritableComparable b) {
        FlightsWritableComparable firstFlight = (FlightsWritableComparable) a;
        FlightsWritableComparable secondFlight = (FlightsWritableComparable) b;
        return firstFlight.compareID(secondFlight);
    }
}