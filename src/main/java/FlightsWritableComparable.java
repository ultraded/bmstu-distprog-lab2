import org.apache.hadoop.io.WritableComparable;

import java.io.DataOutput;

public class FlightsWritableComparable implements WritableComparable {
    private int aeroID, identity;

    public FlightsWritableComparable(int aeroportID) {

    }

    @Override
    public void write(DataOutput dataOutput) throw IOException {
        dataOutput.writeInt(aeroportID);
        data
    }
}
