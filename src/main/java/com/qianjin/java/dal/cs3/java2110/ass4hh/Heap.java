package com.qianjin.java.dal.cs3.java2110.ass4hh;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {
    ArrayList<T> heapList;

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

    public T deleteMax() {
        if (isEmpty()) {
            System.out.println("Heap is empty");
            return null;
        }

        else {
            T ret = heapList.get(0); // get the item in the root. This is the
                                     // largest item.

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

    //return the smallest key
    public T findMin() {
        //find the first leaf node
        T t = heapList.get(heapList.size() / 2);
        for (int i = ((heapList.size() / 2) + 1); i < heapList.size(); i++) {
            if (heapList.get(i).compareTo(t) < 0) {
                t = heapList.get(i);//get the smallest key
            }
        }
        return t;
    }

    //delete the smallest key
    public T dequeueMin() {
        if (isEmpty()) {
            System.out.println("Heap is empty");
            return null;
        }

        else {
            T ret = findMin();
            T item = heapList.remove(heapList.size() - 1);
            if (heapList.size() == 0)
                return ret;
            T minChild;
            int minIndex;
            int index = heapList.indexOf(ret);
            heapList.set(index, item);

            boolean found = false;

            while (!found) {
                if (index < size()) {//case 1, have parent node
                    minIndex = (index - 1) / 2;
                    minChild = heapList.get(minIndex);
                    // sift up if necesssary
                    if (item.compareTo(minChild) > 0) {
                        heapList.set(minIndex, item);
                        heapList.set(index, minChild);
                        index = minIndex;
                    } else
                        found = true;
                }

                else // case 2: item to be sifted down has no children
                    found = true;

                index = (index - 1) / 2;
            }
            return ret;
        }

    }
    
    //get the curent arraylist in this heap
    public void copyTo( ArrayList<T> list){
        for(int i=0;i<size();i++){
            list.add(heapList.get(i));
        }
    }
    //create a new heap with default arraylist
    public void create( ArrayList<T> list){
        heapList=list;
    }

}