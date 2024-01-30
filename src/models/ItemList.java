package models;

public class ItemList {
	
	public final int MAX_SIZE = 99;
	private String[] items;
	private int size;

	public ItemList() {
		items = new String[MAX_SIZE];
		size = 0;
	}

	public String[] getItems() {
		return items;
	}

	public int getSize() {
		return size;
	}
	
	public void add(String item) {
		if (size < MAX_SIZE) {
			items[size++] = item;
		}
	}
	
	public void remove(int index) {
		if (index < size && index >= 0) {
			for (int i = index; i< size-1; i++) {
				items[i] = items[i+1];
			}
			size--;
		}
	}

}
