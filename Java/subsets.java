/**
 *
 * Given an array with no duplicates, return all of its subsets
 * e.g. Given [1, 2, 3]
 * Return [[1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3], []]
 *
 */


 import java.util.Collections;
 import java.util.ArrayList;

 class Solution {
     /**
      * @param S: A set of numbers.
      * @return: A list of lists. All valid subsets.
      */

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.sort(S);
        subHelper(result, list, S, 0);
        return result;
    }

    public void subHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, ArrayList<Integer> S, int pos){
        result.add(new ArrayList<Integer>(list));
        for (int i = pos; i < S.size(); i++){
            list.add(S.get(i));
            subHelper(result, list, S, i + 1);
            list.remove(list.size() - 1);
        }
    }
 }
