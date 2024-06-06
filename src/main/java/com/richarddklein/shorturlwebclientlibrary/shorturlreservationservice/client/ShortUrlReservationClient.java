/**
 * The Short URL WebClient Library
 * (Copyright 2024 by Richard Klein)
 */

package com.richarddklein.shorturlwebclientlibrary.shorturlreservationservice.client;

import com.richarddklein.shorturlwebclientlibrary.shorturlreservationservice.dto.ShortUrlReservationResult;
import com.richarddklein.shorturlwebclientlibrary.shorturlreservationservice.dto.ShortUrlReservationStatus;

/**
 * The Short URL Reservation WebClient interface.
 *
 * <p>Specifies the methods that must be implemented by any class that plays
 * the role of a web client of the Short URL Reservation Service.</p>
 */
public interface ShortUrlReservationClient {
    /**
     * Reserve any short URL.
     *
     * Request the Short URL Reservation Service to reserve any available
     * short URL.
     *
     * @param isRunningLocally 'true' if the Short URL Reservation Service
     *                         is running on your local machine, 'false'
     *                         otherwise.
     * @return The success/failure status of the reservation operation.
     */
    ShortUrlReservationResult reserveAnyShortUrl(boolean isRunningLocally);

    /**
     * Reserve specific short URL.
     *
     * Request the Short URL Reservation Service to reserve a specific
     * short URL.
     *
     * @param isRunningLocally 'true' if the Short URL Reservation Service
     *                         is running on your local machine, 'false'
     *                         otherwise.
     * @param shortUrl The specific short URL to be reserved.
     * @return The success/failure status of the reservation operation.
     */
    ShortUrlReservationStatus reserveSpecificShortUrl(boolean isRunningLocally,
                                                      String shortUrl);

    /**
     * Cancel reservation of specific short URL.
     *
     * Request the Short URL Reservation Service to cancel the reservation
     * of a specific short URL.
     *
     * @param isRunningLocally 'true' if the Short URL Reservation Service
     *                         is running on your local machine, 'false'
     *                         otherwise.
     * @param shortUrl The specific short URL whose reservation is to be
     *                 canceled.
     * @return The success/failure status of the cancellation operation.
     */
    ShortUrlReservationStatus cancelSpecificShortUrl(boolean isRunningLocally,
                                                     String shortUrl);
}
