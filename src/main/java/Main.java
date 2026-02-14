import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        RangeSumList l =  new RangeSumList(list);
        l.update(0, 1);

        System.out.println(l.elements);
        System.out.println(l.blocks);
        System.out.println(l.sum(0, 19));
    }
}
