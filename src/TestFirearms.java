import javax.swing.*;
public class TestFirearms {
    public static void main(String[] args) {
        Firearms gun = new Firearms("AK-47", "Brown", "Automatic" , (short) 30);
        String[] menu = {"Add Rounds", "Remove Rounds", "Clear Mag", "Setup Firearm", "Set Mode", "Shoot", "End"};
        short amount = 0, capacity = 0;
        String choice = "", model = "", color = "", hold = "";
        while (!choice.equals("End")) {
            hold = gun.viewGunInfo() + "\nSelect:";
            choice = JOptionPane.showInputDialog(null, new JTextArea(hold), "Jaen Rafael M. Toyoda",
                    JOptionPane.QUESTION_MESSAGE,null, menu, menu[0]).toString();
            switch(choice) {
                case "Add Rounds":
                    if (gun.isFull()) {
                        JOptionPane.showMessageDialog(null, "Magazine is at max Capacity",
                                "Jaen Rafael M. Toyoda",JOptionPane.ERROR_MESSAGE);
                    } else {
                        amount = Short.parseShort(JOptionPane.showInputDialog(null, "Amount in Rounds:",
                                "Jaen Rafael M. Toyoda", JOptionPane.QUESTION_MESSAGE));
                        gun.addRound(amount);
                    }
                    break;
                case "Remove Rounds":
                    if (gun.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Magazine is Empty",
                                "Jaen Rafael M. Toyoda",JOptionPane.ERROR_MESSAGE);
                    } else {
                        amount = Short.parseShort(JOptionPane.showInputDialog(null, "Amount in Rounds:",
                                "Jaen Rafael M. Toyoda", JOptionPane.QUESTION_MESSAGE));
                        gun.removeRound(amount);
                    }
                    break;
                case "Clear Mag":
                    gun.clear();
                    JOptionPane.showMessageDialog(null, "Magazine has been cleared",
                            "Jaen Rafael M. Toyoda", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Setup Firearm":
                    model = JOptionPane.showInputDialog(null, "Model: ",
                            "Jaen Rafael M. Toyoda", JOptionPane.QUESTION_MESSAGE);
                    color = JOptionPane.showInputDialog(null, "Color: ",
                            "Jaen Rafael M. Toyoda", JOptionPane.QUESTION_MESSAGE);
                    capacity = Short.parseShort(JOptionPane.showInputDialog(null, "Capacity: ",
                            "Jaen Rafael M. Toyoda", JOptionPane.QUESTION_MESSAGE));
                    gun.setModel(model);
                    gun.setColor(color);
                    gun.setCapacity(capacity);
                    gun.clear();
                    break;
                case "Set Mode":
                    gun.gunMode();
                    break;
                case "Shoot":
                    gun.shoot();
                    break;
                case "End":
            }
        }
    }
}
