package org.dev.domain.exception;

import org.dev.domain.validation.handlers.Notification;

public class NotificationException extends DomainException {

    public NotificationException(final String aMessage, final Notification notification) {
        super(aMessage, notification.getProblems());
    }
}
