import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class FlightsReducer extends Reducer<FlightsWritableComparable, Text, Text, Text> {

    @Override
    private void reduce(FlightsWritableComparable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Iterator<Text> iter = values.iterator();
        Text name = new Text(iter.next());
        int count = 0;
        float min = 0, max = 0, sum = 0;
        while (iter.hasNext()) {
            float currVal = Float.parseFloat((iter.next().toString()));
            if (count == 0) {
                min = currVal;
                max= currVal;
            } else {
                if (currVal < min) min = currVal;
                else if (currVal > max) max = currVal;
                sum +=currVal;
                count++;
            }
            if (count != 0) {
                float avg = sum / count;
                context.write(name, new Text("Min"));
            }
        }
    }
}
