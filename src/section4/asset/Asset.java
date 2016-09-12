package section4.asset;

public class Asset {
    public enum AssetType {BONO, STOCK};
    private final AssetType type;
    private final int value;
    public Asset(final AssetType assetType, final int assetValue) {
        type = assetType;
        value = assetValue;
    }
    public AssetType getType() {return type;}
    public int getValue() {return value;}
}
