import java.util.TreeSet;

class Solve{
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t){
        //Create a treeset variables to hold the values of the array and because it has a ceiling for max variable in treeset and floor for min variable in treeset
        TreeSet<Long> tset = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            //hold the current min variable in the set
            Long justSmaller = tset.floor((long)nums[i]);
            //hold the current max variable in the set
            Long justLarger = tset.ceiling((long)nums[i]);
            
            //check if theres something in the set and if the abs diff is valid
            if(justSmaller != null && nums[i] - justSmaller <= t){
                return true;
            }
            //check if theres something in the set and if the abs diff is valid
            if(justLarger != null && justLarger - nums[i] <= t){
                return true;
            }
            //if it doesnt return true then you add that variables to the set
            tset.add((long)nums[i]);
            //and also size is more than k then the set is no longer valid so remove the first element in 
            if(tset.size() > k){
                tset.remove((long)nums[i-k]);
            }
        }
        return false;
    }
}
