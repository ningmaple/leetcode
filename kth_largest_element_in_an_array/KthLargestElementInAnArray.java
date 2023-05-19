public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int kthLargestHeap = findKthLargestHeap(nums, k);
        int kthLargestQuickSelect = findKthLargestQuickSelect(nums, k);
        return kthLargestQuickSelect;
    }

    private int findKthLargestHeap(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0;
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
                continue;
            }
            if (minHeap.peek() < num) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        
        return minHeap.peek();
    }

    private int findKthLargestQuickSelect(int[] nums, int start, int end, int k) {
        if (nums == null || nums.length < k) {
            return 0;
        }
        return quickSelect(nums, 0, nums.length -1 , k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start > end) {
            return -1;
        }
        
        int pivot = start + generateRandomIdx(end - start + 1);
        swap(nums, pivot, end);
        int left = start;
        int right = end - 1;
        while (left <= right) {
            if (nums[left] > nums[end]) {
                left++;
                continue;
            }
            swap(nums, left, right--);
        }
        swap(nums, left, end);
        if (left + 1 == k) {
            return nums[left];
        }
        
        return left + 1 < k ? quickSelect(nums, left + 1, end, k) : quickSelect(nums, start, left - 1, k);
    }

    private int generateRandomIdx(int size) {
        return new Random().nextInt(size);
    }
    
    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}