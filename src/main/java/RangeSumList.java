import java.util.ArrayList;
import java.util.List;

public class RangeSumList {
    List<Integer> blocks = new ArrayList<>();
    List<Integer> elements = new ArrayList<>();
    Integer N;
    Integer sqrtN;

    public RangeSumList(List<Integer> elements) {
        this.elements = elements;
        N = elements.size();
        sqrtN = (int) Math.sqrt(N);

        for (int i = 0; i < sqrtN; i++) {
            int sum = 0;
            int upper = i * sqrtN;
            for (int index = upper; index < upper + sqrtN; index++) {
                if (index < N) {
                    sum += elements.get(index);
                } else {
                    break;
                }
            }
            blocks.add(sum);
        }
    }

    public void update(Integer index, Integer value) {
        int i = Math.floorDiv(index, (sqrtN));
        blocks.set(i, blocks.get(i) + value - elements.get(index));
        elements.set(index, value);
    }

    public int sum(Integer left, Integer right) {
        int l_block = Math.floorDiv(left, (sqrtN));
        int r_block = Math.floorDiv(right, (sqrtN));

        if (l_block == r_block) return intervalSum(left, right, elements);

        int l_rest_sum = intervalSum(left, (l_block + 1) * sqrtN - 1, elements);
        int r_rest_sum = intervalSum(r_block*sqrtN, right, elements);

        int block_sum = intervalSum(l_block + 1, r_block - 1, blocks);

        return l_rest_sum + r_rest_sum + block_sum;
    }

    private int intervalSum(int left, int right, List<Integer> list) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += list.get(i);
        }
        return sum;
    }
}

