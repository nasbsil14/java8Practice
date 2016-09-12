package section6;

public class HolderNaive {
    private Heavy heavy;
    public HolderNaive() {
        System.out.println("Holder created");
    }

    //並列実行するとスレッド別にインスタンスを作成してしまう処理（スレッドセーフではない）
    public Heavy getHeavy() {
        if (heavy == null) {
            heavy = new Heavy();
        }
        return heavy;
    }
    //排他制御でスレッドセーフ化 → オーバーヘッド増、メモリバリア問題を有してしまう・・・
    public synchronized Heavy getHeavySync() {
        if (heavy == null) {
            heavy = new Heavy();
        }
        return heavy;
    }
}
