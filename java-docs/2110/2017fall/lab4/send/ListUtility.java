
/**
 * This class is designed as a class for CSCI 2110- Data Structures and
 * Algorithms Laboratory No. 4 Exercise 2
 * 
 * This class contains a list of static methods that manipulate unordered lists
 * 
 */
public class ListUtility {

    /**
     * Create and return a third list that contains the items that are either in
     * list1 or in list2 or both. Do not add duplicates.
     * 
     * @param list1
     *            first list
     * @param list2
     *            second list
     * @return the result
     */
    public static <T> List<T> findUnion(List<T> list1, List<T> list2) {
        List<T> other = new List<T>();
        // in a while loop to handle the data in list1
        T first = list1.first();
        while (first != null) {
            if (!other.contains(first)) {
                other.add(first);
            }
            first = list1.next();
        }
        // in a while loop to handle the data in list2
        first = list2.first();
        while (first != null) {
            if (!other.contains(first)) {
                other.add(first);
            }
            first = list2.next();
        }
        return other;
    }// end of findUnion

    /**
     * Create and return a third list that contains the items that are common to
     * both list1 and list2. Do not add duplicates.
     * 
     * @param list1
     *            first list
     * @param list2
     *            second list
     * @return result list
     */
    public static <T> List<T> findIntersection(List<T> list1, List<T> list2) {
        List<T> other = new List<T>();
        // firstly, check all item in list1
        T first = list1.first();
        while (first != null) {
            // if the current item is in list2 as well
            if (list2.contains(first)) {
                // if the current item is not in new list
                if (!other.contains(first))
                    other.add(first);
            }
            first = list1.next();
        }

        // then, start to check the all items in list2
        first = list2.first();
        while (first != null) {
            if (list1.contains(first)) {
                if (!other.contains(first))
                    other.add(first);
            }
            first = list2.next();
        }
        return other;
    }

    /**
     * Create and return a third list that contains the items in list1
     * interleaved with the items in list2. // For example, list1={A, C},
     * list2={B, P, M, N, Z} // list3 = {A, B, C, P, M, N, Z}
     * 
     * @param list1
     *            first list
     * @param list2
     *            second list
     * @return result list
     */
    public static <T> List<T> interleave(List<T> list1, List<T> list2) {
        List<T> other = new List<T>();
        T first1 = list1.first();
        T first2 = list2.first();
        // in a while loop to handle all itmes in list1 and list2
        while (true) {
            // reach the end both of list1 and list2, then quit the loop
            if (first1 == null && first2 == null)
                break;
            if (first1 != null)
                other.add(first1);
            // add the item interleave
            if (first2 != null)
                other.add(first2);
            first1 = list1.next();
            first2 = list2.next();
        }
        return other;
    }

    /**
     * Create and return a list that has the items in list1 with every second
     * item removed.
     * 
     * For example, if list1={A, B, C, D, E} // the list returned is {A, C, E}
     * 
     * @param list1
     *            input list
     * @return result list
     */
    public static <T> List<T> chopSkip(List<T> list1) {
        List<T> other = new List<T>();
        T first = list1.first();
        int count = 1;
        while (first != null) {
            if (count % 2 == 1) {
                other.add(first);
            }
            first = list1.next();
            count++;
        }
        return other;
    }

}
