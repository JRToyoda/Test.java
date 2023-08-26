
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
            choice=j.showInputDialog(null,new JTextArea(display+"\n\n"+hold), "Menu",1,null,menu,menu[0]).toString();
            switch(choice){
                case "Add	Water":
                    if(tank.isFull()){
                        j.showMessageDialog(null, "Tank	is	full","Error",JOptionPane.ERROR_MESSAGE);
                    }else{
                        amount=Float.parseFloat(j.showInputDialog("Amount	(L:"));
                        tank.addWater(amount);
                        j.showMessageDialog(null, amount+"L	is	added	to	tank.");
                    }
                    break;
                case "Remove	Water":
                    if(tank.isEmpty()){
                        j.showMessageDialog(null, "Tank	is	empty","Error",JOptionPane.ERROR_MESSAGE);
                    }else{
                        amount=Float.parseFloat(j.showInputDialog("Amount	(L):"));
                        tank.removeWater(amount);
                        j.showMessageDialog(null, amount+"L	is	removed	from	the	tank.");
                    }
                    break;
                case "Clear	tank":
                    j.showMessageDialog(null, "Tank	is	empty.	Wastage\t:	"+ tank.drain());
                    break;
                case "Setup	Tank":
                    brand=j.showInputDialog("Brand:	");
                    color=j.showInputDialog("Color:	");
                    capacity=Float.parseFloat(j.showInputDialog("Change	Capacity:"));
                    tank.setBrand(brand);
                    tank.setColor(color);
                    tank.setCapacity(capacity);
                    j.showMessageDialog(null, "Tank	has	been	updated.");
                    break;
                case "End":
            } //end	of	switch
        }while(!choice.equals("End"));
    }//end	of	main

} //end	of	class
