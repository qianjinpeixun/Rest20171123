
import java.util.ArrayList;

/**
 * 
 * * This class is designed for CSCI 2110- Data Structures and Algorithms
 * Laboratory No. 3 Exercise 5
 * 
 * This simple PrintQueue class use the Queue class. It is modeled similar to
 * the Unix print command.
 *
 */
public class PrintQueue {

    GenericQueue<Job> pq;

    // Creates an empty print queue
    public PrintQueue() {
        pq = new GenericQueue<>();
    }

    // Enqueues a job with the specified owner name and job id
    public void lpr(String owner, int jobId) {
        pq.enqueue(new Job(owner, jobId));
    }

    // Prints all the entries in this queue
    public void lpq() {
        Job job = pq.first();
        while (job != null) {
            System.out.println(job);
            job = pq.next();
        }

    }

    // Removes the active job at the front of the queue if jobId matches, error
    // message otherwise
    public void lprm(int jobId) {
        Job first = pq.first();
        if (first.getJobId() == jobId) {
            pq.dequeue();
        } else {
            System.out.println("error during lprm");
        }
    }

    // Removes all jobs from the queue that have been submitted by the owner
    public void lprmAll(String owner) {
        ArrayList<Job> list = new ArrayList<>();
        Job job = pq.first();
        while (job != null) {
            if (job.getOwner().equals(owner)) {
                list.add(job);
            }
            job=pq.next();
        }

        for (Job j : list) {
            pq.remove(j);
        }

    }

    @Override
    public String toString() {
        return "PrintQueue [pq=" + pq + "]";
    }

}
