package com.learn.lld;

import java.util.ArrayList;
import java.util.List;

/**
 * Elevator system controller for a building.
 *
 * <p>This class is a Singleton because a building should have one centralized elevator
 * controller that coordinates all elevators. It also applies the Strategy design pattern
 * through {@link ElevatorScheduler} to allow different elevator dispatching strategies.</p>
 *
 * <p><strong>Low-level class diagram:</strong></p>
 * <pre>
 * +-----------------+         +-------------------------+
 * |  ElevatorSystem |<>------>|  ElevatorScheduler      |
 * |-----------------|         |-------------------------|
 * | - elevators     |         | + chooseElevator(...)   |
 * | - scheduler     |         +-----------^-------------+
 * |-----------------|                     |
 * | + requestPickup |                     |
 * | + selectFloor   |                     |
 * | + step         |                     |
 * +-----------------+         +-------------------------+
 *                                   ^
 *                                   |
 *                     +------------------------------+
 *                     | NearestElevatorScheduler     |
 *                     +------------------------------+
 *
 * +-----------------+
 * |    Elevator      |
 * |-----------------|
 * | - id            |
 * | - currentFloor  |
 * | - direction     |
 * | - doorState     |
 * | - destinations  |
 * |-----------------|
 * | + addDestination|
 * | + moveOneFloor  |
 * +-----------------+
 *
 * +-----------------+
 * | ElevatorRequest |
 * |-----------------|
 * | - floor         |
 * | - direction     |
 * +-----------------+
 * </pre>
 *
 * <p>In this design, the system is separated into:
 * <ul>
 *   <li><b>ElevatorSystem</b> - the facade and coordinator</li>
 *   <li><b>Elevator</b> - the domain entity representing a single elevator</li>
 *   <li><b>ElevatorRequest</b> - the external pickup request</li>
 *   <li><b>ElevatorScheduler</b> - the dispatch strategy interface</li>
 * </ul>
 * </p>
 */
public class ElevatorSystem {

    private static ElevatorSystem instance;
    private final List<Elevator> elevators;
    private ElevatorScheduler scheduler;

    private ElevatorSystem(int numberOfElevators, int initialFloor) {
        this.elevators = new ArrayList<>();
        for (int i = 1; i <= numberOfElevators; i++) {
            this.elevators.add(new Elevator(i, initialFloor));
        }
        this.scheduler = new NearestElevatorScheduler();
    }

    /**
     * Returns the singleton elevator system instance.
     *
     * @param numberOfElevators number of elevators to manage
     * @param initialFloor      starting floor for all elevators
     * @return the global ElevatorSystem instance
     */
    public static ElevatorSystem getInstance(int numberOfElevators, int initialFloor) {
        if (instance == null) {
            instance = new ElevatorSystem(numberOfElevators, initialFloor);
        }
        return instance;
    }

    /**
     * Returns the singleton instance after initialization.
     *
     * @return the ElevatorSystem instance
     * @throws IllegalStateException if the system was not initialized first
     */
    public static ElevatorSystem getInstance() {
        if (instance == null) {
            throw new IllegalStateException("ElevatorSystem must be initialized before use.");
        }
        return instance;
    }

    /**
     * Assigns an external pickup request to the best elevator.
     *
     * @param floor     the floor where the user is waiting
     * @param direction desired direction of travel
     */
    public void requestPickup(int floor, Direction direction) {
        ElevatorRequest request = new ElevatorRequest(floor, direction);
        Elevator chosenElevator = scheduler.chooseElevator(elevators, request);
        chosenElevator.addDestination(floor);
    }

    /**
     * Adds an internal destination request for a specific elevator.
     *
     * @param elevatorId destination elevator id
     * @param floor      requested floor
     */
    public void selectFloor(int elevatorId, int floor) {
        Elevator elevator = findElevatorById(elevatorId);
        elevator.addDestination(floor);
    }

    /**
     * Advances the simulation by one time unit, moving each elevator toward its next stop.
     */
    public void step() {
        for (Elevator elevator : elevators) {
            elevator.moveOneFloor();
        }
    }

    /**
     * Returns a textual status of all elevators for debugging or monitoring.
     *
     * @return current status of each elevator
     */
    public String status() {
        StringBuilder builder = new StringBuilder();
        for (Elevator elevator : elevators) {
            builder.append(elevator.getStatus()).append(System.lineSeparator());
        }
        return builder.toString();
    }

    /**
     * Switches scheduling strategy at runtime.
     *
     * @param scheduler strategy implementation for dispatching elevators
     */
    public void setScheduler(ElevatorScheduler scheduler) {
        this.scheduler = scheduler;
    }

    private Elevator findElevatorById(int elevatorId) {
        return elevators.stream()
                .filter(e -> e.getId() == elevatorId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Elevator not found: " + elevatorId));
    }
}
