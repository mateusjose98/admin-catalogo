package org.dev.domain.events;

@FunctionalInterface
public interface DomainEventPublisher {
    void publishEvent(DomainEvent event);
}
