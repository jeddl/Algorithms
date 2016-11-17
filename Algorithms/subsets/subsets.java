 import java.util.Collections;
 import java.util.ArrayList;

 class Solution {

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
