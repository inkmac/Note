package nonlock.atomic;

import utils.Log;

import java.util.concurrent.atomic.AtomicMarkableReference;

import static utils.Time.sleep;

public class AtomicMarkableReferenceTest {
    public static void main(String[] args) {
        GarbageBag bag = new GarbageBag("Full");
        AtomicMarkableReference<GarbageBag> ref = new AtomicMarkableReference<GarbageBag>(bag, true);

        Log.debug("start...");

        GarbageBag prev = ref.getReference();
        Log.debug(prev.toString());

        sleep(1000);

        Log.debug("get a new bag?");
        boolean success = ref.compareAndSet(prev, new GarbageBag("Empty"), true, false);
        Log.debug("get a new bag? : {}", success);
        Log.debug(ref.getReference().toString());

    }
}

class GarbageBag {
    String desc;

    public GarbageBag(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "GarbageBag{" +
                "desc='" + desc + '\'' +
                '}';
    }
}
