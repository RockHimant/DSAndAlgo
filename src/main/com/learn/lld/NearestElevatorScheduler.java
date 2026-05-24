package com.learn.lld;

import java.util.List;

/**
 * Nearest elevator dispatch strategy.
 *
 * <p>This scheduler chooses the elevator with the smallest estimated distance to the pickup floor.
 * It gives preference to elevators that are already moving in the same direction as the request,
 * and penalizes elevators moving in the opposite direction.</p>
 */
public class NearestElevatorScheduler implements ElevatorScheduler {

    @Override
    public Elevator chooseElevator(List<Elevator> elevators, ElevatorRequest request) {
        Elevator bestElevator = null;
        int bestScore = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            int score = evaluateElevator(elevator, request);
            if (score < bestScore) {
                bestScore = score;
                bestElevator = elevator;
            }
        }

        if (bestElevator == null) {
            throw new IllegalStateException("No elevators available");
        }

        return bestElevator;
    }

    private int evaluateElevator(Elevator elevator, ElevatorRequest request) {
        int distance = Math.abs(elevator.getCurrentFloor() - request.getFloor());
        if (elevator.isIdle()) {
            return distance;
        }
        if (elevator.getDirection() == request.getDirection()) {
            return distance;
        }
        return distance + 5; // penalize opposite direction
    }
}
