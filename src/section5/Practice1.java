package section5;

import common.BeforeAfterPractice;
import common.TargetPractice;

public class Practice1 implements BeforeAfterPractice {

    @Override
    public void before() {
        //case 1 try-with(ARM)なし
        try {
            final FileWriterExample writerExample = new FileWriterExample("test.txt");
            try {
                writerExample.writeStuff("test");
            } finally {
                writerExample.close();
            }
        } catch (Exception e) {
            //とりあえず何もしない
        }

        //case 2 try-with(ARM)あり
        try {
            try (final FileWriterARM writerARM = new FileWriterARM("test.txt")) {
                writerARM.writeStuff("test");
            }
        } catch (Exception e) {
            //とりあえず何もしない
        }
    }

    @Override
    public void after() {
        try {
            FileWriterEAM.use("test.txt", writerEAM -> {
                writerEAM.writeStuff("test1");
                writerEAM.writeStuff("test2");
            });
        } catch (Exception e) {
            //とりあえず何もしない
        }
    }

    @Override
    public void run() {

    }
}
