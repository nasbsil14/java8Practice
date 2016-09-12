package section6;

/*
  仮想「依存するリソースにより、長い実行時間と大きなメモリ量を必要とする処理」を扱うクラス
 */
public class Heavy {
    public Heavy() {System.out.println("Heavy created");}
    public String toString() {return "quit heavy";}
}
