package com.avengers.musinsa.product;

public class ProductVariants {
    private Integer productVariantId;

    private Products productId;

    private String skuCode;

    private String variantName;

    private Integer price;

    private Integer stockQuantity;

    private String sizeValue;

    private String colorValue;

    private String materialValue;

    private Integer extraPrice;

    public Integer getProductVariantId() {
        return productVariantId;
    }

    public Products getProductId() {
        return productId;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public String getVariantName() {
        return variantName;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public String getSizeValue() {
        return sizeValue;
    }

    public String getColorValue() {
        return colorValue;
    }

    public String getMaterialValue() {
        return materialValue;
    }

    public Integer getExtraPrice() {
        return extraPrice;
    }
}
