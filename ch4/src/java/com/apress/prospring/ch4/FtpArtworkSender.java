/*
 * Created on 28-Jul-2004
 */
package com.apress.prospring.ch4;

/**
 * @author robh
 */
public class FtpArtworkSender implements ArtworkSender {

    public void sendArtwork(String artworkPath, Recipient recipient) {
        // ftp logic here...
    }

    public String getFriendlyName() {
        return "File Transfer Protocol";
    }

    public String getShortName() {
        return "ftp";
    }

}