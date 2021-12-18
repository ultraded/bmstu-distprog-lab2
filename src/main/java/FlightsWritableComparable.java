import org.apache.hadoop.io.WritableComparable;

import java.io.DataOutput;
import java.io.IOException;

public class FlightsWritableComparable implements WritableComparable {
    private int aeroID;
    private boolean identity;

    public FlightsWritableComparable(int id, boolean identity) {
        this.aeroID=id;
        this.identity=identity;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(aeroID);
        dataOutput.writeBoolean(identity);
    }

    @Override
    public int compareTo(Object o) {
        FlightsWritableComparable comparedTo =(FlightsWritableComparable) o;
        if (aeroID > comparedTo.aeroID) return 0;
        else if (aeroID < comparedTo.aeroID) return -1;
        else if (identity  comparedTo.identity) return 1;
    }
}
