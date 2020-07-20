package coen352.ch4.dictionary;
import coen352.ch4.dictionary.LLDictionary;

/** This class will store a record*/

public class Inventory {
	
	// Data members for the inventory
	private String SKU;
	private String Description;
	private String BinNum;
	private String Location;
	private int Qty;
	private int reorderedQty;
	private double cost;
	private double inventoryValue;
	private String reorder;
	private String Unit;
	private static int counter;
	//private double totalInventoryPrice;
	
	Inventory(){
		SKU = "";
		Description = "";
		BinNum = "";
		Qty=0;
		reorderedQty = 0;
		cost =0;
		inventoryValue = Qty*cost;
		reorder ="";
		Unit = "";
		Location="";
		
	}
	
	//  location. Remove the inventory value from the parameter list
	Inventory(String SKU, String Description, String BinNum,String Location,String Unit,int Qty,int reorderedQty,double cost, String reorder){
		this.SKU =SKU;
		this.Description = Description;
		this.BinNum= BinNum;
		this.Qty=Qty;
		this.reorderedQty=reorderedQty;
		this.cost = cost;
		this.inventoryValue = Qty*cost ;
		this.reorder = reorder;
		this.Location = Location;
		this.Unit=Unit;
		counter++;
	
	}
	// set the SKU code
	public void setSKU(String SKU) {
		this.SKU = SKU;
	}
	//return the SKu code
	public String getSKU() {
		return SKU;
	}
	
	// set and return SKU description: number of the item, eg: item1
	public void setDescription(String Description) {
		this.Description = Description;
	}
	
	//return the description of the SKU: number of the item
	public String getDescription() {
		return Description;
	}
	
	// set the quantity of the item
	public void setQuantity(int Qty) {
		this.Qty = Qty;
	}
	
	// return the quantity of the item 
	public int getQuantity() {
		return Qty;
	}
	
	// set the bin #
	public void setBinNum(String BinNum) {
		this.BinNum=BinNum;
	}
	
	//return the bin number
	public String getBinNum() {
		return BinNum;
	}
	
	// set the reordered quantity
	public void setReorderedQty(int reorderedQty) {
		this.reorderedQty=reorderedQty;
	}
	
	//return the reordered quantity
	public int getReorderedQty() {
		return reorderedQty;
	}
	
	// set the cost of the item
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	//return the cost of the item
	public double getCost() {
		return cost;
	}
	
	// return the inventory value
	public double getInventoryValue() {
		inventoryValue = cost*Qty;
		return inventoryValue;
	}
	
	// set the reordered
	public void setReordered(String reorder) {
		this.reorder = reorder;
	}

	//return reordered
	public String getReordered() {
		if (reorder == "reorder")
			return "reorder";
		else 
			return " ";
	}
	
	// set the unit
	public void setUnit(String Unit) {
		this.Unit = Unit;
	}
	
	
	//return the unit
	public String getUnit() {
		return Unit;
	}
	
	
	// set the location of the item
	public void setLocaton(String Location) {
		this.Location=Location;
	}
	
	// return the location of the item
	public String getLocation() {
		return Location;
	}
	
	
	
	public void printInventory() {
		System.out.print(getSKU()+ " "+ getDescription()+ " "+getBinNum()+ " "+
				getLocation()+" "+ getUnit()+ " "+ getQuantity()+ " "+
		getReorderedQty()+ " "+ getCost()+ " "+ getInventoryValue()+" "+getReordered());
		System.out.println(" ");
	}
					
}
