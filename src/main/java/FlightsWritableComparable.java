import org.apache.hadoop.io.WritableComparable;

import java.io.DataOutput;
import java.io.IOException;

public class FlightsWritableComparable implements WritableComparable {
    private int aeroID, identity;

    public FlightsWritableComparable(int aeroportID) {

    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(aeroID);
        dataOutput.writeInt(identity);
    }

    @Override
    public void compareTo()
}
