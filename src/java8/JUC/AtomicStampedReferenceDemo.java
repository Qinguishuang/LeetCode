package java8.JUC;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceDemo {
    public static void main(String[] args) {
        final Integer initialRef = 0, initialStamp = 0;
        final AtomicStampedReference<Integer> asr = new AtomicStampedReference<>(initialRef, initialStamp);
        System.out.println("current value = " + asr.getReference() + " current stamp" + asr.getStamp());

        final Integer newReference = 123, newStamp = 456;
        final boolean casResult = asr.compareAndSet(initialRef, newReference, initialStamp, newStamp);

    }
}
