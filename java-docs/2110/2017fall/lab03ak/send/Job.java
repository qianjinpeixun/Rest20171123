
/**
 * This simple Job class hold two entries in order to simulate the UNIX command
 * printQueue
 *
 */
public class Job {
    private String owner;
    private int jobId;

    public Job(String o, int j) {
        owner = o;
        jobId = j;
    }

    public String getOwner() {
        return owner;
    }

    public int getJobId() {
        return jobId;
    }

    @Override
    public String toString() {
        return "Job [owner=" + owner + ", jobId=" + jobId + "]";
    }

}