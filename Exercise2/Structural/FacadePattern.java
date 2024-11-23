package Structural;

// Subsystem 1
class CPU {
    void start() {
        System.out.println("CPU is starting...");
    }

    void execute() {
        System.out.println("CPU is executing...");
    }

    void shutDown() {
        System.out.println("CPU is shutting down...");
    }
}

// Subsystem 2
class Memory {
    void load() {
        System.out.println("Memory is loading...");
    }
}

// Subsystem 3
class HardDrive {
    void read() {
        System.out.println("Hard Drive is reading data...");
    }
}

// Facade Class
class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    void start() {
        System.out.println("Starting computer...");
        cpu.start();
        memory.load();
        hardDrive.read();
        cpu.execute();
    }

    void shutDown() {
        System.out.println("Shutting down computer...");
        cpu.shutDown();
    }
}

// Client Class
public class FacadePattern {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.start();
        computer.shutDown();
    }
}
