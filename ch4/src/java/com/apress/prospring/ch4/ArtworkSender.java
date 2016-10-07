/*
 * Created on 28-Jul-2004
 */
package com.apress.prospring.ch4;

/**
 * @author robh
 */
public interface ArtworkSender {

    public void sendArtwork(String artworkPath, Recipient recipient);

    public String getFriendlyName();

    public String getShortName();
}