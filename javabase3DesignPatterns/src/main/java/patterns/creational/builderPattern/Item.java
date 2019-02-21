package patterns.creational.builderPattern;

/**
 * 商品类
 */
public interface Item {
    public String name();//商品名称

    public Packing packing();//包装

    public float price();//价格
}
