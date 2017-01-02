package com.beanvalidation.bl.service;

import com.beanvalidation.constraints.generic.URL;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class ServerConnection {
    @URL
    private String resourceURL;
    @NotNull
    @URL(protocol = "https", host = "www.cdbookstore.com")
    private String itemURL;
    @URL(protocol = "ftp", port = 21)
    private String ftpURL;
    private Date lastConnectionDate;

    public ServerConnection() {
    }

    public ServerConnection(String resourceURL, String itemURL) {
        this.resourceURL = resourceURL;
        this.itemURL = itemURL;
    }

    public ServerConnection(String resourceURL, String itemURL, String ftpURL) {
        this.resourceURL = resourceURL;
        this.itemURL = itemURL;
        this.ftpURL = ftpURL;
    }

    public String getResourceURL() {
        return resourceURL;
    }

    public void setResourceURL(String resourceURL) {
        this.resourceURL = resourceURL;
    }

    public String getItemURL() {
        return itemURL;
    }

    public void setItemURL(String itemURL) {
        this.itemURL = itemURL;
    }

    public String getFtpURL() {
        return ftpURL;
    }

    public void setFtpURL(String ftpURL) {
        this.ftpURL = ftpURL;
    }

    public Date getLastConnectionDate() {
        return lastConnectionDate;
    }

    public void setLastConnectionDate(Date lastConnectionDate) {
        this.lastConnectionDate = lastConnectionDate;
    }
}
