

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {
    ArrayList<T> heapList;

    //in order to use in part 3
    public  ArrayList<T> getList(){
        return heapList;
    }
    
    //in order touse in part3, init the heap using an arraylist
    public Heap(ArrayList<T> list){
        heapList=list;
    }
    
    // returns the key with the smallest priority.
    public T findMin() {
        // the smallest element is always a leaf node
        int pos = size() / 2;
        T t = heapList.get(pos);
        pos = pos + 1;
        while (pos < size()) {
            if (heapList.get(pos).compareTo(t) < 0) {
                t = heapList.get(pos);
            }
            pos++;
        }
        return t;
    }

    // returns the index position with the smallest priority.
    public int findMinPosition() {
        // the smallest element is always a leaf node
        int pos = size() / 2;
        int ret = pos;
        T t = heapList.get(pos);
        pos = pos + 1;
        while (pos < size()) {
            if (heapList.get(pos).compareTo(t) < 0) {
                t = heapList.get(pos);
                ret = pos;
            }
            pos++;
        }
        //        System.out.println("ret=" + ret + ",pos=" + pos);

        return ret;
    }

    public Heap() {
        heapList = new ArrayList<T>();
    }

    public int size() {
        return heapList.size();
    }

    public boolean isEmpty() {
        return heapList.isEmpty();
    }

    public void clear() {
        heapList.clear();
    }

    public void enumerate() {
        System.out.println(heapList);
    }

    public void add(T item) {
        heapList.add(item);

        int index = heapList.size() - 1;
        int pindex = (index - 1) / 2;
        T parent = heapList.get(pindex);

        while (index > 0 && item.compareTo(parent) > 0) {
            heapList.set(index, parent);
            heapList.set(pindex, item);
            index = pindex;
            pindex = (index - 1) / 2;
            parent = heapList.get(pindex);
        }
    }

    // returns the key with the smallest priority and also deletes it
    public T dequeueMin() {
        if (isEmpty()) {
            System.out.println("Heap is empty");
            return null;
        } else {
            int min = findMinPosition();
            //System.out.println("min=" + min);
            if (min == heapList.size() - 1) {
                return heapList.remove(heapList.size() - 1);
            }
            T ret = findMin(); // get the smallest one
            // remove the last item.
            T item = heapList.remove(heapList.size() - 1);

            if (heapList.size() == 0)
                return ret; // if there was only one item in the heap to begin
                            // with, we are done.

            heapList.set(min, item); // otherwise, proceed. Put the item in the
                                     // smallest position
            if (min == 1)
                return item;// if it is the root, return

            boolean found = false;
            while (min != -1 && !found) {
                if (heapList.get(min).compareTo(heapList.get(min / 2)) > 0) {
                    heapList.set(min / 2, item);
                } else
                    found = true;
                min = min / 2;
            }
            return ret;
        }
    }

    public T deleteMax() {
        if (isEmpty()) {
            System.out.println("Heap is empty");
            return null;
        } else {
            T ret = heapList.get(0); // get the item in the root. This is the
                                     // smallest item.

            T item = heapList.remove(heapList.size() - 1); // remove the last
                                                           // item.

            if (heapList.size() == 0)
                return ret; // if there was only one item in the heap to begin
                            // with, we are done.

            heapList.set(0, item); // otherwise, proceed. Put the item in the
                                   // root.
            int index, lIndex, rIndex, maxIndex;
            T maxChild;
            boolean found = false;
            index = 0;
            lIndex = index * 2 + 1;
            rIndex = index * 2 + 2;

            while (!found) {
                if (lIndex < size() && rIndex < size()) // case 1: item to be
                                                        // sifted down has two
                                                        // children
                {
                    // find the maxChild and maxIndex
                    if (heapList.get(lIndex).compareTo(heapList.get(rIndex)) > 0) {
                        maxChild = heapList.get(lIndex);
                        maxIndex = lIndex;
                    } else {
                        maxChild = heapList.get(rIndex);
                        maxIndex = rIndex;
                    }

                    // sift down if necesssary
                    if (item.compareTo(maxChild) < 0) {
                        heapList.set(maxIndex, item);
                        heapList.set(index, maxChild);
                        index = maxIndex;
                    } else
                        found = true;
                }

                else if (lIndex < size()) // case 2: item to be sifted down has
                                          // only left child
                // note: item to be sifted down cannot have only right child -
                // it will violate the complete binary tree property
                {
                    if (item.compareTo(heapList.get(lIndex)) < 0) {
                        heapList.set(index, heapList.get(lIndex));
                        heapList.set(lIndex, item);

                        index = lIndex;
                    }

                    else
                        found = true;
                } else // case 3: item to be sifted down has no children
                    found = true;

                lIndex = index * 2 + 1;
                rIndex = index * 2 + 2;
            }
            return ret;
        }

    }

}