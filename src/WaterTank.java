import javax.swing.*;

public class WaterTank {
    private String brand, color;
    private float capacity, level;
    private boolean text;
    public WaterTank() {
        capacity = 10000.0f;
        level = 0.0f;
        text = true;
    }
    public WaterTank(float capacity) {
        this.capacity = capacity;
        level = 0.0f;
        text = true;
    }
    public WaterTank(String brand, float capacity) {
        this.brand = brand; // Jaen Rafael M. Toyoda
        this.capacity = capacity;
        if (capacity < 0) {
            System.out.println("ERROR: Capacity is Negative");
            System.exit(0);
        }
        level = 0.0f;
        text = true;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }
    public String getBrand() {
        return brand;
    }
    public String getColor() {
        return color;
    }
    public float getCapacity() {
        return capacity;
    }
    public void addWater(float amount) { // Jaen Rafael Toyoda
        if (amount < 0) {
            JOptionPane.showMessageDialog(null, "Input is Negative", "Jaen Rafael M. Toyoda",JOptionPane.ERROR_MESSAGE);
        } else if (level + amount > capacity) {
            float wastage = (level + amount) - capacity;
            if (JOptionPane.showConfirmDialog(null, "               The tank is about to reach full capacity.              \n" +
                                                                          "           Please confirm if you want to add 400L of water            \n" +
                                                                          "(it will exceed the tank capacity, and the excess water will be wasted).",
                                                                    "Jaen Rafael M. Toyoda", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Potential Wastage\t :" + wastage + "L\n" +
                                                                          "User Response\t :Yes\n" +
                                                                          "currentWater\t ->" + capacity +"L", "Jaen Rafael M. Toyoda",
                                                                          JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Potential Wastage\t :" + wastage + "L\n" +
                                                                          "User Response\t :Yes\n" +
                                                                          "currentWater\t ->" + level +"L", "Jaen Rafael M. Toyoda",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            level += amount;
            JOptionPane.showMessageDialog(null, amount+"L	is	added	to	tank.");
        }
//        text = true;
//        if (amount < 0) {
//            System.out.println("** ERROR: Negative Input Detected! **");
//            text = false;
//        } else if (amount + level > capacity) {
//            System.out.println("** ERROR: Level Exceeds Capacity! **");
//            text = false;
//        } else {
//            level += amount;
//            text = true;
//        }
    }
    public void removeWater(float amount) {
        if (level <= 0){
            JOptionPane.showMessageDialog(null, "Tank	is Empty","Jaen Rafael M. Toyoda",JOptionPane.ERROR_MESSAGE);
        } else if (amount < 0) {
            JOptionPane.showMessageDialog(null, "Input is Negative", "Jaen Rafael M. Toyoda",JOptionPane.ERROR_MESSAGE);
        } else if (level - amount < 0) {
            JOptionPane.showMessageDialog(null, "There is not enough water to remove " + amount + "L in the Tanks",
                    "Jaen Rafael M. Toyoda",JOptionPane.ERROR_MESSAGE);
        }else {
            level -= amount;
            JOptionPane.showMessageDialog(null, amount+"L	is	removed	from	the	tank.");
        }
//        if (amount < 0) {
//            System.out.println("** ERROR: Negative Input Detected! **");
//            text = false;
//        } else if (level - amount < 0) {
//            System.out.println("** ERROR: Level is below 0L! **");
//            text = false;
//        } else {
//            level -= amount;
//            text = true;
//        }
    }

    public float currentWater() {
        return level;
    }
    public boolean isEmpty() {
        return (level == 0);
    }
    public boolean isFull() {
        return (level >= capacity);
    }

    public float drain() {
        float wastage = level;
        level = 0.0f;
        return wastage;
    }

    public void showWTInfo() {
        if (text) { // Jaen Rafael M. Toyoda
            System.out.println("Brand\t\t: " + brand);
            System.out.println("Color\t\t: " + color);
            System.out.println("Capacity\t\t: " + capacity + "L");
            System.out.println("Water Level\t\t: " + level + "L");
            System.out.println("isEmpty\t\t: " + isEmpty());
            System.out.println("isFull\t\t: " + isFull());
        }
    }
    public String displayWTInfo() {
        String hold = "Brand\t\t: " + brand
                    + "\nColor\t\t: " + color
                    + "\nCapacity\t\t: " + capacity + "L"
                    + "\nWater Level\t\t: " + level + "L"
                    + "\nisEmpty\t\t: " + isEmpty()
                    + "\nisFull\t\t: " + isFull();
        return hold;
    }
    public String viewWTInfo() {
        String hold = "Brand\t: " + brand + "\tColor\t: " + color
                    + "\nCapacity\t: "  + capacity + "L" + "\tWater Level\t\t: " + level + "L"
                    + "\nisEmpty\t\t: " + isEmpty() + "\tisFull\t\t: " + isFull()
                    + "\nRemaining Capacity : " + remainingCapacity();
        return hold;
    }
    public float remainingCapacity() {
        return capacity - level;
    }
    /**Creates simple water tank graphic simulation that takes a character (ch)
     * as input and returns a string representing the visual representation of
     * the water tank. The tank is represented using vertical bars and symbols ~
     * to indicate the water level.
     * @param ch
     * @return drawn String */
    public String drawTank(String ch) {
        String display = "";
        int tankHeight = 0, liter = 0;
        //adjust the tank height based on capacity as needed
        if (capacity <= 100) {
            liter = 10;
            tankHeight = (int) capacity / liter;
        } else if (capacity <= 1000) {
            liter = 100;
            tankHeight = (int) capacity / liter;
        } else if (capacity <= 10000) {
            liter = 1000;
            tankHeight = (int) capacity / 1000;
        } else {
            liter = 10000;
            tankHeight = (int) capacity / 10000;
        } //end of if
        //(indicator) points to the water level in the tank
        String get = "<-" + (level + "L");
        //Draw the graphic
        for (int i = tankHeight; i > 0; i--) {
            //display in liter evenly as per desired height
            display += liter * i + "L|";
            //Draw the specified character as water
            if (i <= level / liter) { //explanation is at document
                //filled the tank with the character and repeats it 20 times, plus the indicator
                display += ch.repeat(20) + "|" + get;
                get = ""; //resets the get variable so it won't repeat the indicator
            } else {
                display += "\t\t |"; //draw blank space
            } //end of if
            display += "\n"; //separate the character in each line to draw a tank-like object.
        } //end of the loop
        //creates a 0L indicator and a bottom part of the tank
        display += " 0L(_______________________)";
        //draw a cover(top) portion of the tank, then concatenates the drawn graphics from a loop
        return " ^^^^^^^^^^^^^^^^^^^^^\n" + display;
    }
    public static void main(String[] args) {
        String menu[]={"Add	Water", "Remove	Water", "Clear	tank", "Setup	Tank", "End"};
        String choice="",color="Dirty	Black",brand="";
        float amount=0.00f, capacity=0.00f;
        JOptionPane j=new JOptionPane();
        WaterTank tank=new WaterTank("Sadie	Sink",1000);
        String display="", hold="";
        tank.setColor(color);
        do{
            display = tank.drawTank("~");
            hold=tank.viewWTInfo()+"\nSelect:";
            choice=j.showInputDialog(null,new JTextArea(display+"\n\n"+hold), "Menu",1,null,menu,menu[0]).toString();
            switch(choice){
                case "Add	Water":
                    if (tank.isFull()) {
                        JOptionPane.showMessageDialog(null, "Tank	is	full","Jaen Rafael M. Toyoda",JOptionPane.ERROR_MESSAGE);
                    } else {
                        amount = Float.parseFloat(JOptionPane.showInputDialog("Amount	(L:"));
                        tank.addWater(amount);
                    }
                    break;
                case "Remove	Water":
                    if(tank.isEmpty()){
                        j.showMessageDialog(null, "Tank	is	empty","Jaen Rafael M. Toyoda",JOptionPane.ERROR_MESSAGE);
                    }else{
                        amount=Float.parseFloat(j.showInputDialog(null, "Amount	(L):", "Jaen Rafael M. Toyoda"));
                        tank.removeWater(amount);
                    }
                    break;
                case "Clear	tank":
                    j.showMessageDialog(null, "Tank	is	empty.	Wastage\t:	"+ tank.drain());
                    break;
                case "Setup	Tank":
                    brand=j.showInputDialog("Brand:	");
                    color=j.showInputDialog("Color:	");
                    if (tank.isEmpty()) {
                        capacity=Float.parseFloat(j.showInputDialog("Change	Capacity:"));
                    } else {
                        j.showMessageDialog(null, "Capacity cannot be changed if tank is not Empty");
                    }
                    tank.setBrand(brand);
                    tank.setColor(color);
                    tank.setCapacity(capacity);
                    j.showMessageDialog(null, "Tank	has	been	updated.");
                    break;
                case "End":
            } //end	of	switch
        }while(!choice.equals("End"));
//        WaterTank tank = new WaterTank("Septic Tank",500);
//        System.out.println("Tester\t: Jaen Rafael Toyoda");
//        tank.displayWTInfo();
//        System.out.println("*** Before adding water ***");
        tank.showWTInfo();
//        System.out.println("*** After adding water ***");
//        tank.addWater(300);
//        tank.addWater(300);
//        tank.showWTInfo();
//        System.out.println("*** After removing water ***");
//        tank.removeWater(700);
//        tank.showWTInfo();
//        tank.removeWater(150.50f);
//        tank.removeWater(350.50f);
//        System.out.println(tank.displayWTInfo());
//        System.out.println(tank.viewWTInfo());

//        System.out.println("Water Level\t: " + tank.currentWater() + "L");
//        System.out.println("Capacity\t: " + tank.getCapacity() + "L");
//        System.out.println("isEmpty\t\t: " + tank.isEmpty());
//        System.out.println("isFull\t\t: " + tank.isFull());
    }
}
