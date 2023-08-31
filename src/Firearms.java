import javax.swing.*;
import java.util.Random;
// Jaen Rafael M. Toyoda
public class Firearms {
    private String model, color, mode;
    private short capacity, rounds;
    private boolean jammed;
    public Firearms(String model, String color, String mode, short capacity) {
        this.model = model;
        this.color = color;
        this.mode = mode;
        this.capacity = capacity;
        jammed = false;
    }
    public void addRound(short amount) {
        if (amount < 0) {
            JOptionPane.showMessageDialog(null, "ERROR: Negative Input Detected!",
                    "Jaen Rafael M. Toyoda",JOptionPane.ERROR_MESSAGE);
        } else if (rounds + amount > capacity) {
            JOptionPane.showMessageDialog(null, "ERROR: Adding " + amount + " Round will Exceed Capacity!",
                    "Jaen Rafael M. Toyoda",JOptionPane.ERROR_MESSAGE);
        } else {
            rounds += amount;
            JOptionPane.showMessageDialog(null, amount + " Rounds have been added to the mag.",
                    "Jaen Rafael M. Toyoda", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void removeRound(short amount) {
        if (amount < 0) {
            JOptionPane.showMessageDialog(null, "ERROR: Negative Input Detected!",
                    "Jaen Rafael M. Toyoda",JOptionPane.ERROR_MESSAGE);
        } else if (rounds - amount < 0) {
            JOptionPane.showMessageDialog(null, "ERROR: There are not enough rounds in the firearm to remove "
                            + amount + " bullets!", "Jaen Rafael M. Toyoda",JOptionPane.ERROR_MESSAGE);
        } else {
            rounds -= amount;
            JOptionPane.showMessageDialog(null, amount + " Rounds have been removed from the mag.",
                    "Jaen Rafael M. Toyoda", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void clear() {
        rounds = 0;
        jammed = false;
    }
    public void gunMode() {
        String[] gunModes = {"Automatic", "Semi-Automatic"};
        mode = JOptionPane.showInputDialog(null, "Mode: ",
                "Jaen Rafael M. Toyoda", JOptionPane.QUESTION_MESSAGE,null, gunModes, gunModes[0]).toString();
        setMode(mode);
    }
    public void shoot() {
        Random randomizer = new Random();
        int rng; rng = randomizer.nextInt(100) + 1;
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERROR: I need more boolets!",
                    "Jaen Rafael M. Toyoda", JOptionPane.ERROR_MESSAGE);
        } else if (rng < 20 || jammed) {
            jammed = true;
            JOptionPane.showMessageDialog(null, "ERROR: The Gun is Jammed. Please Clear the Magazine",
                    "Jaen Rafael M. Toyoda", JOptionPane.ERROR_MESSAGE);
        } else {
            short amount = 0;
            switch(mode) {
                case "Semi-Automatic":
                    amount = 1;
                    break;
                case "Automatic":
                    amount = Short.parseShort(JOptionPane.showInputDialog(null, "Amount in Rounds:",
                            "Jaen Rafael M. Toyoda", JOptionPane.QUESTION_MESSAGE));
                    break;
                }
            if (rounds - amount < 0) {
                JOptionPane.showMessageDialog(null, "ERROR: I need more boolets!",
                        "Jaen Rafael M. Toyoda", JOptionPane.ERROR_MESSAGE);
            } else {
                if (amount < 4) {
                    String hold = "";
                    for (int i = 0; i < amount; i++) {
                        hold += "BANG!\n";
                    }
                    JOptionPane.showMessageDialog(null, hold,
                            "Jaen Rafael M. Toyoda", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Drrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr",
                            "Jaen Rafael M. Toyoda", JOptionPane.INFORMATION_MESSAGE);
                }
                rounds -= amount;
            }
        }
    }
    public boolean isEmpty() {
        return (rounds == 0);
    }
    public boolean isFull() {
        return (rounds >= capacity);
    }
    public short remainingCapacity() {
        return (short) (capacity - rounds);
    }
    public String viewGunInfo() {
        String hold = "Model\t\t: " + model + "\nColor\t\t: " + color + "\nType\t\t:" + mode
                + "\nCapacity\t\t: "  + capacity + " Rounds" + "\nAmmunition\t\t: " + rounds + " Rounds"
                + "\nRemaining Capacity\t: " + remainingCapacity() + " Rounds";
        return hold;
    }

    public short getCapacity() {
        return capacity;
    }

    public void setCapacity(short capacity) {
        this.capacity = capacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
