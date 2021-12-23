/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.POJOs;

import com.google.gson.Gson;
import com.mservice.shared.utils.Encoder;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 *
 * @author sie
 */
public class MomoRequest {
    @Autowired
    private Environment environment;
    public static final String langEN = "en";
    public static final String langVI = "vi";
    private String partnerCode = environment.getProperty("momo.partnerCode");
    private String partnerName = environment.getProperty("momo.partnerName");
    private String storeId = environment.getProperty("momo.storeId");
    private String requestId;
    private Long amount;
    private String orderId;
    private String orderInfo;
    private String redirectUrl = environment.getProperty("momo.redirectUrl");
    private String ipnUrl = environment.getProperty("momo.ipnUrl");
    private String requestType = "captureWallet";
    private String extraData;
    private boolean autoCapture = true;
    private String lang = "en";
    private String signature;

    public MomoRequest() {
    }

    /**
     * @return the partnerCode
     */
    public String getPartnerCode() {
        return partnerCode;
    }

    /**
     * @param partnerCode the partnerCode to set
     */
    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    /**
     * @return the partnerName
     */
    public String getPartnerName() {
        return partnerName;
    }

    /**
     * @param partnerName the partnerName to set
     */
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    /**
     * @return the storeId
     */
    public String getStoreId() {
        return storeId;
    }

    /**
     * @param storeId the storeId to set
     */
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    /**
     * @return the requestId
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * @param requestId the requestId to set
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    /**
     * @return the amount
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the orderInfo
     */
    public String getOrderInfo() {
        return orderInfo;
    }

    /**
     * @param orderInfo the orderInfo to set
     */
    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    /**
     * @return the redirectUrl
     */
    public String getRedirectUrl() {
        return redirectUrl;
    }

    /**
     * @param redirectUrl the redirectUrl to set
     */
    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    /**
     * @return the ipnUrl
     */
    public String getIpnUrl() {
        return ipnUrl;
    }

    /**
     * @param ipnUrl the ipnUrl to set
     */
    public void setIpnUrl(String ipnUrl) {
        this.ipnUrl = ipnUrl;
    }

    /**
     * @return the requestType
     */
    public String getRequestType() {
        return requestType;
    }

    /**
     * @param requestType the requestType to set
     */
    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    /**
     * @return the extraData
     */
    public String getExtraData() {
        return extraData;
    }

    /**
     * @param extraData the extraData to set
     */
    public void setExtraData(String extraData) {
        this.extraData = extraData;
    }

    /**
     * @return the autoCapture
     */
    public boolean isAutoCapture() {
        return autoCapture;
    }

    /**
     * @param autoCapture the autoCapture to set
     */
    public void setAutoCapture(boolean autoCapture) {
        this.autoCapture = autoCapture;
    }

    /**
     * @return the lang
     */
    public String getLang() {
        return lang;
    }

    /**
     * @param lang the lang to set
     */
    public void setLang(String lang) {
        this.lang = lang;
    }

    /**
     * @return the signature
     */
    public String getSignature() {
        return signature;
    }

    /**
     * @param signature the signature to set
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }
    
    public String generateExtraData(Map map){
        Gson gson = new Gson();
        String json = gson.toJson(map);
        return Encoder.encode64(json);
    }
    
    public String generateSignature() throws Exception{
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("accessKey=%s", environment.getProperty("momo.accessKey")));
        builder.append(String.format("&extraData=%s", this.extraData));
        builder.append(String.format("&ipnUrl=%s", this.ipnUrl));
        builder.append(String.format("&orderId=%s", this.orderId));
        builder.append(String.format("&orderInfo=%s", this.orderInfo));
        builder.append(String.format("&partnerCode=%s", this.partnerCode));
        builder.append(String.format("&partnerName=%s", this.partnerName));
        builder.append(String.format("&redirectUrl=%s", this.redirectUrl));
        builder.append(String.format("&requestId=%s", this.requestId));
        builder.append(String.format("&requestType=%s", this.requestType));
        builder.append(String.format("&storeId=%s",this.storeId));
        return Encoder.signHmacSHA256(builder.toString(), environment.getProperty("momo.secretKey"));
    }
}
