package com.learn.lld;

/**
 * Represents an external pickup request from a floor.
 *
 * <p>An elevator request is created when a user presses the up or down button on a floor.
 * The request includes the requested direction so the scheduler can choose the best elevator.
 * </p>
 */
public class ElevatorRequest {

    private final int floor;
    private final Direction direction;

    public ElevatorRequest(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public int getFloor() {
        return floor;
    }

    public Direction getDirection() {
        return direction;
    }
}
