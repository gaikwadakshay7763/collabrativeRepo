package com.example.pojo;


import com.fasterxml.jackson.annotation.JsonProperty;


public class AuthorizeRequestBase {
    @JsonProperty("header")
    private Header header;
    @JsonProperty("merchant")
    private MerchantInfo merchant;
    @JsonProperty("companyName")
    private String companyName;
    @JsonProperty("card")
    private Card card;
    @JsonProperty("cardHolder")
    private CardHolder cardHolder;
    @JsonProperty("transaction")
    private TransactionDetails transaction;
    @JsonProperty("order")
    private OrderDetails order;
    @JsonProperty("poi")
    private Poi poi;
    @JsonProperty("originalTransaction")
    private OriginalTransaction originalTransaction;
    @JsonProperty("authType")
    private String authType;
//    @JsonProperty("maxWaitTime")
//    private Integer maxWaitTime;

    public AuthorizeRequestBase() {
    }

    public AuthorizeRequestBase(Header header, MerchantInfo merchant, String companyName, Card card, CardHolder cardHolder, TransactionDetails transaction, OrderDetails order, Poi poi, OriginalTransaction originalTransaction, String authType, Integer maxWaitTime) {
        this.header = header;
        this.merchant = merchant;
        this.companyName = companyName;
        this.card = card;
        this.cardHolder = cardHolder;
        this.transaction = transaction;
        this.order = order;
        this.poi = poi;
        this.originalTransaction = originalTransaction;
        this.authType = authType;
       // this.maxWaitTime = maxWaitTime;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public MerchantInfo getMerchant() {
        return merchant;
    }

    public void setMerchant(MerchantInfo merchant) {
        this.merchant = merchant;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public CardHolder getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(CardHolder cardHolder) {
        this.cardHolder = cardHolder;
    }

    public TransactionDetails getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionDetails transaction) {
        this.transaction = transaction;
    }

    public OrderDetails getOrder() {
        return order;
    }

    public void setOrder(OrderDetails order) {
        this.order = order;
    }

    public Poi getPoi() {
        return poi;
    }

    public void setPoi(Poi poi) {
        this.poi = poi;
    }

    public OriginalTransaction getOriginalTransaction() {
        return originalTransaction;
    }

    public void setOriginalTransaction(OriginalTransaction originalTransaction) {
        this.originalTransaction = originalTransaction;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

//    public Integer getMaxWaitTime() {
//        return maxWaitTime;
//    }
//
//    public void setMaxWaitTime(Integer maxWaitTime) {
//        this.maxWaitTime = maxWaitTime;
//    }

    @Override
    public String toString() {
        return "AuthorizeRequestBase{" +
                "header=" + header +
                ", merchant=" + merchant +
                ", companyName='" + companyName + '\'' +
                ", card=" + card +
                ", cardHolder=" + cardHolder +
                ", transaction=" + transaction +
                ", order=" + order +
                ", poi=" + poi +
                ", originalTransaction=" + originalTransaction +
                ", authType='" + authType + '\'' +
                //", maxWaitTime=" + maxWaitTime +
                '}';
    }
}
