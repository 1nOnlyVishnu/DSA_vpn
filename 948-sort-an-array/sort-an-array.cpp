// class Solution {
// public:
//     vector<int> sortArray(vector<int>& nums) {
//         if (nums.size() <= 1) {
//             return nums;
//         }

//         int temp = nums[nums.size() - 1]; 
//         nums.pop_back();                  // remove last element

//         sortArray(nums);                  // sort remaining array
//         insert(nums, temp);                // insert last element at correct place
//         return nums;
//     }

//     void insert(vector<int>& nums, int temp) {
//         if (nums.empty() || nums[nums.size() - 1] <= temp) {
//             nums.push_back(temp);
//             return;
//         }

//         int lastVal = nums[nums.size() - 1];
//         nums.pop_back();

//         insert(nums, temp);
//         nums.push_back(lastVal);
//     }
// };

class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        mergeSort(nums, 0, nums.size() - 1);
        return nums;
    }

    void mergeSort(vector<int>& nums, int left, int right) {
        if (left >= right) return; // base case: 1 element

        int mid = left + (right - left) / 2;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        merge(nums, left, mid, right);
    }

    void merge(vector<int>& nums, int left, int mid, int right) {
        vector<int> temp;
        int i = left, j = mid + 1;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp.push_back(nums[i]);
                i++;
            } else {
                temp.push_back(nums[j]);
                j++;
            }
        }

        while (i <= mid) {
            temp.push_back(nums[i]);
            i++;
        }
        while (j <= right) {
            temp.push_back(nums[j]);
            j++;
        }

        for (int k = 0; k < temp.size(); k++) {
            nums[left + k] = temp[k];
        }
    }
};
