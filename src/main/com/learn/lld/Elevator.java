package com.learn.lld;

import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Represents a single elevator cabin inside the elevator system.
 *
 * <p>This class stores the elevator's current floor, direction, door state, and
 * a sorted set of destination floors. It contains behavior to move one floor at a time
 * and open/close doors at stops.</p>
 */
public class Elevator {

    private final int id;
    private int currentFloor;
    private Direction direction;
    private DoorState doorState;
    private final NavigableSet<Integer> destinations;

    public Elevator(int id, int startingFloor) {
        this.id = id;
        this.currentFloor = startingFloor;
        this.direction = Direction.IDLE;
        this.doorState = DoorState.CLOSED;
        this.destinations = new TreeSet<>();
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isIdle() {
        return destinations.isEmpty() && doorState == DoorState.CLOSED;
    }

    public void addDestination(int floor) {
        if (floor == currentFloor) {
            openDoors();
            return;
        }
        destinations.add(floor);
        if (direction == Direction.IDLE) {
            direction = chooseInitialDirection();
        }
    }

    public void moveOneFloor() {
        if (doorState == DoorState.OPEN) {
            closeDoors();
            return;
        }

        if (destinations.isEmpty()) {
            direction = Direction.IDLE;
            return;
        }

        int nextStop = getNextStop();
        if (nextStop == currentFloor) {
            destinations.remove(currentFloor);
            openDoors();
            return;
        }

        if (nextStop > currentFloor) {
            currentFloor++;
            direction = Direction.UP;
        } else {
            currentFloor--;
            direction = Direction.DOWN;
        }

        if (currentFloor == nextStop) {
            destinations.remove(currentFloor);
            openDoors();
        }
    }

    private int getNextStop() {
        if (direction == Direction.UP) {
            Integer next = destinations.ceiling(currentFloor);
            if (next != null) {
                return next;
            }
            return destinations.last();
        }

        if (direction == Direction.DOWN) {
            Integer next = destinations.floor(currentFloor);
            if (next != null) {
                return next;
            }
            return destinations.first();
        }

        return chooseNearestDestination();
    }

    private Direction chooseInitialDirection() {
        int nearest = chooseNearestDestination();
        return nearest > currentFloor ? Direction.UP : Direction.DOWN;
    }

    private int chooseNearestDestination() {
        if (destinations.isEmpty()) {
            return currentFloor;
        }
        int nearest = currentFloor;
        int bestDistance = Integer.MAX_VALUE;
        for (int destination : destinations) {
            int distance = Math.abs(destination - currentFloor);
            if (distance < bestDistance) {
                bestDistance = distance;
                nearest = destination;
            }
        }
        return nearest;
    }

    private void openDoors() {
        doorState = DoorState.OPEN;
        direction = Direction.IDLE;
    }

    private void closeDoors() {
        doorState = DoorState.CLOSED;
    }

    public String getStatus() {
        return String.format("Elevator %d: floor=%d, dir=%s, doors=%s, destinations=%s",
                id, currentFloor, direction, doorState, destinations);
    }
}
