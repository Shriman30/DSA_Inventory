package coen352.ch4.dictionary;

// The main function is located here.
public class WarehouseInventory {
	
	private LLDictionary<String, KVpair<String, Inventory>> data_base = new LLDictionary<String, KVpair<String, Inventory>>();
	//initializing database according to sample file:
	public void setUp() {
		
		//item 1
		KVpair<String,Inventory>record = new KVpair<String, Inventory>("SP7875",new Inventory("SP7875", "Item1", "T345","Row2,slot1","Each", 20, 10, 30.00, " "));
		this.insertRecord(record);
		//item 2
		record = new KVpair<String, Inventory>("TR87680", new Inventory("TR87680", "Item2", "T345","Row2,slot1", "Each",30, 15, 40.00," "));
		this.insertRecord(record);
		
		//item3
		record = new KVpair<String, Inventory>("MK676554", new Inventory("MK676554", "Item3", "T5789","Row1,slot1","Each", 10, 5, 5.00, " "));
		this.insertRecord(record);
		
		//item4
		record = new KVpair<String, Inventory>("YE98767",new Inventory("YE98767", "Item4", "T9876","Row3,Slot2","Box(10ct)", 40, 10, 15.00," "));
		this.insertRecord(record);
		
		//item5
		record = new KVpair<String, Inventory>("XR23423",new Inventory("XR23423", "Item5", "T098","Row3,slot1","Each", 12, 10, 26.00," "));
		this.insertRecord(record);
		
		//item6
		record = new KVpair<String, Inventory>("PW98762", new Inventory("PW98762", "Item6", "T345","Row2,slot1","Each", 7, 10, 50.00, "reorder"));
		this.insertRecord(record);
		
		//item7
		record = new KVpair<String, Inventory>("BM87684", new Inventory("BM87684", "Item7", "T349","Row1,Slot2","Each", 10, 5, 10.00," "));
		this.insertRecord(record);
		
		//item8
		record = new KVpair<String, Inventory>("BH67655",new Inventory("BH67655", "Item8", "T5789","Row1,Slot1","Each", 19, 10, 3.00, " "));
		this.insertRecord(record);
		
		//item9
		record = new KVpair<String, Inventory>("WT98768",new Inventory("WT98768", "Item9", "T9875","Row2,Slot2","Package(5ct)", 20, 30, 14.00, "reorder"));
		this.insertRecord(record);
		
		//item10
		record = new KVpair<String, Inventory>("TS3456", new Inventory("TS3456", "Item10", "T349","Row1,Slot2","Each", 15, 8, 60.00," "));
		this.insertRecord(record);
		
		//item11
		record = new KVpair<String, Inventory>("WDG123", new Inventory("WDG123", "Item11", "T349","Row1,Slot2","Each", 25, 15, 8.00," "));
		this.insertRecord(record);
	}
	
	
	
	// insert a record in the data_baase
	public void insertRecord(KVpair<String,Inventory> record) {
			if (data_base.find(record.key())==null)
					data_base.insert(record.key(), record);
			else
				System.out.println("There exists a record already");
	}
	
	
	
	

	
	/**remove a record given a key*/
	public Inventory removeRecord(String key) {
		
		KVpair<String, Inventory> result = data_base.remove(key);
		if(result != null) {
			Inventory record = result.value();
			return record;
		}
		else 
			return null;
	}
	

	
	/**Find a record given a key. 
	give key as a parameter*/
	public boolean findRecord(String key) { 
		KVpair<String,Inventory> record =data_base.find(key);
		if(record == null) {
			return false;
		}
		
		else if(record.key() == key) {
			return true;
		}
		else 
			return false;
	}
	
	
	//Retrieve (return) the whole record given a key
	public Inventory getRecord(String key) {
		KVpair<String,Inventory>record = data_base.find(key);
		if (record == null)
			return null;
		else
			record.value().printInventory();
			return record.value();
	}
	
	
	
	//retrieve records that have the value "Reordered". A search function was implemented in the LLDictionary.java file
	public void isReordered() {
		KVpair<String,Inventory>record = new KVpair<String,Inventory>();
		Inventory[] listOfRecords = new Inventory[11];
		for (int i =0;i<data_base.size();i++) {
			record=data_base.search(i);
			if (record!=null) {
				listOfRecords[i] = data_base.search(i).value();
			}

		}
		for(int i=0;i<data_base.size();i++) {
			if (listOfRecords[i].getReordered()=="reorder")
			listOfRecords[i].printInventory();
		}
	}
	 

	 
	//get the size of the inventory
	public int numberOfInventories() {
		return data_base.size();
	}
	
	
	
	//Return the total value of all the inventories
	
	public double getTotalInventoryValue() {
		KVpair<String,Inventory>record = new KVpair<String,Inventory>();
		double sum = 0.00;
		for (int i =0;i< data_base.size();i++) {
			record = data_base.search(i);
			if(record!=null) {
				sum+= record.value().getInventoryValue();
			}
			else
				return 0;
		}
		return sum;
	}
	
	
	
	
	/** main function to test the functions.*/
	
	public static void main(String[] args) {
		
		// creating warehouseInventory object
		WarehouseInventory sample = new WarehouseInventory();
		
		// creating a KVpair inventory object with key and inventory
		KVpair<String,Inventory> record1 = new KVpair<String, Inventory>("ABC123R",new Inventory("ABC123R", "Item12", "CBA32","Row3,Slot4","Each", 25, 32, 12.00, "reorder"));
		
		//Initializing the sample warehouse database 
		sample.setUp();
		System.out.println(sample.getTotalInventoryValue());
		// return the number of inventories or records in the database: Here we should have 11  (function number 6)
		System.out.println(sample.numberOfInventories());
		
		// inserting the record using insertRecord() method. ( function 1)
		sample.insertRecord(record1);
		System.out.println(" ");
		
		// return the updated number of inventories/ records in the data_base  (function 6)
		System.out.println(sample.numberOfInventories());
		System.out.println(" ");
		
		// Retrieve the entire record using a key  ( function 4 )
		sample.getRecord("ABC123R");
		System.out.println(" ");
		
		// find the record using its key: if return value is true then it is present in the data base, else it is not ( function 3)
		System.out.println(sample.findRecord("YE98767"));
		System.out.println(" ");
		//Removing a record given a key: we will remove the fourth item   ( function 2 )
		sample.removeRecord("YE98767");
		
		// updated number of inventories in the database
		System.out.println(sample.numberOfInventories());
		System.out.println(" ");
		
		// retrieve records that have the value "reordered"  ( function 5)
		sample.isReordered();
		System.out.println(" ");
		//Return the total value of all the inventories  (function 7)
		System.out.println(sample.getTotalInventoryValue());
	}


	
	
	
	
}
