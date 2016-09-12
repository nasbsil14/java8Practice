package section6;

import common.TargetPractice;

public class Practice1 implements TargetPractice {

    @Override
    public void run() {
        Holder holder = new Holder();
        holder.getHeavy();
    }
}
