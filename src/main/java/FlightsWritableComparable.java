import org.apache.hadoop.io.WritableComparable;

import java.io.DataOutput;
import java.io.IOException;

public class FlightsWritableComparable implements WritableComparable {
    private int aeroID;
    private boolean identity;

    public FlightsWritableComparable(int id, boolean identity) {

    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(aeroID);
        dataOutput.writeBoolean(identity);
    }

    @Override
    public void compareTo()
}
