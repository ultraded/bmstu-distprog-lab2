import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapreduce.Job;

public class FlightCounterApp {
    public static void main(String[] args) throws Exception {
        if (args.length !=3) {
            System.err.println("Usage:");
            System.exit(-1);
        }
        Job job = Job.getInstance();
        job.setJarByClass(FlightCounterApp.class);
        job.setJobName("Flight count");
        FileInputFormat.addInputPath(job, new Path(args[0]));
        
    }
}
