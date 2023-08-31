
import javax.swing.*;
public class TestWaterTank {
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
            choice=j.showInputDialog(null,new JTextArea(display+"\n\n"+hold), "Jaen Rafael M. Toyoda",1,null,menu,menu[0]).toString();
            switch(choice){
                case "Add	Water":
                    if (tank.isFull()) {
                        JOptionPane.showMessageDialog(null, "Tank	is	full","Jaen Rafael M. Toyoda",JOptionPane.ERROR_MESSAGE);
                    } else {
                        amount = Float.parseFloat(JOptionPane.showInputDialog(null, "Amount	(L):",
                                "Jaen Rafael M. Toyoda", JOptionPane.QUESTION_MESSAGE));
                        tank.addWater(amount);
                    }
                    break;
                case "Remove	Water":
                    if(tank.isEmpty()){
                        j.showMessageDialog(null, "Tank	is	empty","Jaen Rafael M. Toyoda",JOptionPane.ERROR_MESSAGE);
                    }else{
                        amount=Float.parseFloat(j.showInputDialog(null, "Amount	(L):", "Jaen Rafael M. Toyoda", JOptionPane.QUESTION_MESSAGE));
                        tank.removeWater(amount);
                    }
                    break;
                case "Clear	tank":
                    j.showMessageDialog(null, "Tank	is	empty.	Wastage\t:	"+ tank.drain());
                    break;
                case "Setup	Tank":
                    brand=j.showInputDialog(null, "Brand:	", "Jaen Rafael M. Toyoda", JOptionPane.QUESTION_MESSAGE);
                    color=j.showInputDialog(null, "Color:	","Jaen Rafael M. Toyoda", JOptionPane.QUESTION_MESSAGE);
                    if (tank.isEmpty()) {
                        capacity=Float.parseFloat(j.showInputDialog(null, "Change	Capacity:",
                                "Jaen Rafael M. Toyoda", JOptionPane.QUESTION_MESSAGE));
                        j.showMessageDialog(null, "Tank has been updated.", "Jaen Rafael M. Toyoda", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        j.showMessageDialog(null, "Cannot change capacity if tank is not Empty",
                                "Jaen Rafael M. Toyoda", JOptionPane.INFORMATION_MESSAGE);
                    }
                    tank.setBrand(brand);
                    tank.setColor(color);
                    tank.setCapacity(capacity);
                    break;
                case "End":
            } //end	of	switch
        }while(!choice.equals("End"));
//        WaterTank tank = new WaterTank("Septic Tank",500);
//        System.out.println("Tester\t: Jaen Rafael Toyoda");
//        tank.displayWTInfo();
//        System.out.println("*** Before adding water ***");
//        tank.showWTInfo();
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
} //end	of	class
