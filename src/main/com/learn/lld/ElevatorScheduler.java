package com.learn.lld;

import java.util.List;

/**
 * Strategy interface for selecting which elevator should answer a pickup request.
 *
 * <p>This interface enables different dispatch algorithms to be plugged into the system
 * without changing the core {@link ElevatorSystem} logic.</p>
 */
public interface ElevatorScheduler {

    Elevator chooseElevator(List<Elevator> elevators, ElevatorRequest request);
}
