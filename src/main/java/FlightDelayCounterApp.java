import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;

public class FlightDelayCounterApp {

    private static int NUM_REDUCE_TASKS = 2;

    public static void main(String[] args) throws Exception {
        if (args.length !=3) {
            System.err.println("Usage:");
            System.exit(-1);
        }
        Job job = Job.getInstance();
        job.setJarByClass(FlightDelayCounterApp.class);
        job.setJobName("Flight delay count");
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, FlightsMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, AirportsMapper.class);

        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        job.setPartitionerClass(FlightsPartitioner.class);
        job.setGroupingComparatorClass(FlightsGroupingComparator.class);
        job.setReducerClass(FlightsReducer.class);
        job.setMapOutputKeyClass(FlightsWritableComparable.class);
        job.setMapOutputValueClass(Text.class);
        job.setNumReduceTasks(NUM_REDUCE_TASKS);
        System.exit(job.waitForCompletion(true) ? 0 : 1);

    }
}
