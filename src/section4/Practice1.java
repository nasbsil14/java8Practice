package section4;

import common.TargetPractice;
import section4.asset.Asset;
import section4.asset.AssetUtil;
import section4.camera.Camera;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Practice1 implements TargetPractice {
    @Override
    public void run() {
        final List<Asset> assets = Arrays.asList(
                new Asset(Asset.AssetType.BONO, 1000),
                new Asset(Asset.AssetType.BONO, 2000),
                new Asset(Asset.AssetType.STOCK, 3000),
                new Asset(Asset.AssetType.STOCK, 4000)
        );
        /*
          要素をループしてSTOCKの金額を合計する処理を行っている以下の一文では、
          「どのようにイテレーションするか、何を合計するか、どのように合計するか」の３つの関心が生まれる
         */
        System.out.println(AssetUtil.totalAssetValue(assets));

        /*
          関心の分離に基づき、以下の記述で「何を合計するか」が指定可能となった
         */
        //無条件（全合計）
        System.out.println(AssetUtil.totalAssetValueConditionally(assets, asset -> true));
        //AssetType = Boldの合計算出
        System.out.println(AssetUtil.totalAssetValueConditionally(assets, asset -> asset.getType() == Asset.AssetType.BONO));

        /*
          ラムダを使用したDecoratorパターン
         */
        final Camera camera = new Camera();
        //関数チェーンによるデコレート
        camera.setFilters(Color::brighter, Color::darker);
        final Consumer<String> printCaputured = (filterInfo) ->
                System.out.println(String.format("with %s: %s", filterInfo, camera.capture(new Color(200, 100, 200))));
        printCaputured.accept("brigther & darker filter");
    }
}
