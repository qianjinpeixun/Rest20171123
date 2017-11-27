
/**
 * 
 * This class is design as an implements the banker’s algorithm discussed in
 * Section 7.5.3
 * 
 * Several customers’ request and release resources from the bank. The banker
 * will grant a request only if it leaves the system in a safe state. A request
 * is denied if it leaves the system in an unsafe state.
 * 
 */
public class BankImpl implements Bank {

    private int n; // the number of threads in the system
    private int m; // the number of resources
    private int[] available; // the amount available of each resource
    private int[][] maximum; // the maximum demand of each thread
    private int[][] allocation;// the amount currently allocated to each thread
    private int[][] need; // the remaining needs of each thread

    /**
     * A constructor that is passed the number of resources initially available
     * 
     * @param initialResources
     *            the initially available vector
     */
    public BankImpl(int[] initialResources) {
        // fix the maximum number of customers to 5
        n = Bank.UNMBER_OF_CUSTOMERS;
        // get the default resource numbers
        m = initialResources.length;
        available = new int[m];
        // initially, set the default available resource numbers
        for (int i = 0; i < m; i++) {
            available[i] = initialResources[i];
        }
        // the default maximum of each thread is zero
        maximum = new int[Bank.UNMBER_OF_CUSTOMERS][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                maximum[i][j] = 0;
        // the default allocation of each thread is zero
        allocation = new int[Bank.UNMBER_OF_CUSTOMERS][m];
        need = new int[Bank.UNMBER_OF_CUSTOMERS][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                allocation[i][j] = 0;
    }

    /**
     * Add a customer to the bank.
     * 
     * @param customerNumber
     *            The number of the customer being added.
     * @param maxDemand
     *            The maximum demand for this customer.
     */
    public void addCustomer(int customerNumber, int[] maximumDemand) {
        for (int i = 0; i < m; i++) {
            maximum[customerNumber][i] = maximumDemand[i];
            need[customerNumber][i] = maximumDemand[i];
        }
    }

    /**
     * Outputs the available, allocation, max, and need matrices.
     */
    public void getState() {

        System.out.println("maximun:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(maximum[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("need:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(need[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("available:");
        for (int j = 0; j < m; j++) {
            System.out.print(available[j] + "\t");
        }
        System.out.println();

        System.out.println("maximum:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(maximum[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

    }

    /**
     * Make a request for resources.
     * 
     * @param customerNumber
     *            The number of the customer being added.
     * @param request
     *            The request from this customer.
     * @return true The request is granted.
     * @return false The request is not granted.
     */
    public boolean requestResources(int customerNumber, int[] request) {
        System.out.print("Customer # " + customerNumber + " requesting ");
        for (int i = 0; i < request.length; i++) {
            System.out.print(request[i] + " ");
        }
        System.out.print("Available = ");
        for (int i = 0; i < available.length; i++) {
            System.out.print(available[i] + " ");
        }
        customerNumber--;

        if (customerNumber < 0 || customerNumber >= n)
            return false;
        // first step, check need
        for (int i = 0; i < m; i++) {
            if (request[i] > need[customerNumber][i]) {

                return false;
            }
        }
        // second step, check available
        for (int i = 0; i < m; i++) {
            if (request[i] > available[i]) {

                return false;
            }
        }
        // third step, try to allocation
        for (int i = 0; i < m; i++) {
            available[i] = available[i] - request[i];
            allocation[customerNumber][i] = allocation[customerNumber][i] + request[i];
            need[customerNumber][i] = need[customerNumber][i] - request[i];
        }
        // frouth step,check if in safe mode
        boolean safe = isSafe(customerNumber);
        if (safe) {
            return true;
        } else {
            for (int i = 0; i < m; i++) {
                available[i] = available[i] + request[i];
                allocation[customerNumber][i] = allocation[customerNumber][i] - request[i];
                need[customerNumber][i] = need[customerNumber][i] + request[i];
            }
            return false;
        }
    }

    /**
     * The bank will grant a request if the request satisfies the safely
     * algorithm outline in Section 7.5.3.1.
     * 
     * @param s
     *            the number of process
     * @return if in safe mode, return true, otherwise return false
     */
    private boolean isSafe(int s) {
        int work;
        boolean finish[] = new boolean[n];
        int temp[] = new int[n];
        int i, j, k = 0;
        // by default, all process not finished
        for (i = 0; i < n; i++)
            finish[i] = false;
        // start to check available
        for (j = 0; j < m; j++) {
            work = available[j];
            i = s;
            // if the ith process can finish
            while (i < n) {
                if (finish[i] == false && need[i][j] <= work) {
                    work = work + allocation[i][j];
                    finish[i] = true;
                    temp[k] = i;
                    k++;
                    i = 0;
                } else {
                    i++;
                }
            }
            // finally, check if is in a safe mode
            for (i = 0; i < n; i++)
                if (finish[i] == false) {
                    return false;
                }
        }
        return true;
    }

    /**
     * Release resources.
     * 
     * @param customerNumber
     *            The number of the customer being added.
     * @param release
     *            The resources to be released.
     */
    public void releaseResources(int customerNumber, int[] release) {

        customerNumber--;
        for (int j = 0; j < m; j++) {
            available[j] = available[j] + release[j];
            allocation[customerNumber ][j]=allocation[customerNumber ][j]-release[j];
        }
        
        System.out.print("Customer # " + (customerNumber+1) + " releasing ");
        for (int i = 0; i < release.length; i++) {
            System.out.print(release[i] + " ");
        }
        System.out.print("Available = ");
        for (int i = 0; i < available.length; i++) {
            System.out.print(available[i] + " ");
        }
        System.out.print("Allocated = ");
        for (int i = 0; i < m; i++) {
            System.out.print(allocation[customerNumber ][i] + " ");
        }
        System.out.println();
    }
}
