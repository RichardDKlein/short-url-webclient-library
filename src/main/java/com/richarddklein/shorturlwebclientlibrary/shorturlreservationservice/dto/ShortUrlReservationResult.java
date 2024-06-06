/**
 * The Short URL WebClient Library
 * (Copyright 2024 by Richard Klein)
 */

package com.richarddklein.shorturlwebclientlibrary.shorturlreservationservice.dto;

/**
 * Class defining the result of requesting the Short URL Reservation service
 * to reserve a short URL.
 */
public class ShortUrlReservationResult {
    public ShortUrlReservationStatus status;
    public String shortUrl;

    public ShortUrlReservationResult(ShortUrlReservationStatus status, String shortUrl) {
        this.status = status;
        this.shortUrl = shortUrl;
    }
}
