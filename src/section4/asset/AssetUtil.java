package section4.asset;

import java.util.List;
import java.util.function.Predicate;

public class AssetUtil {

    public static int totalAssetValue(final List<Asset> assets) {
        return assets.stream()
                .mapToInt(Asset::getValue)
                .sum();
    }

    /*
      ラムダ版Strategyパターンによる関心の分離
      「どのようにイテレーションするか、何を合計するか、どのように合計するか」のうち「何を」を分離
     */
    public static int totalAssetValueConditionally(final List<Asset> assets
            , final Predicate<Asset> assetSelector) {
        return assets.stream()
                .filter(assetSelector)
                .mapToInt(Asset::getValue)
                .sum();
    }
}
