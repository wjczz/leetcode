package com.java.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Item implements Comparable<Item>{

	public Item parent;
	public int itemId;
	
	public String itemName;
	
	Item(Item parent, int itemId)
	{
		this.parent = parent;
		this.itemId = itemId;
		this.itemName = this.ToString(parent, itemId);
	}
	
	public static String ToString(Item parent, int itemId)
	{
		if(parent == null)
		{
			return String.valueOf(itemId);
		}
		return parent.itemName + "." + itemId;
	}
	
	@Override
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
		return this.itemName.compareTo(o.itemName);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item item1 = new Item(null, 1);
		Item item2 = new Item(null, 2);
		Item item3 = new Item(null, 3);
		Item item4 = new Item(item1, 1);
		Item item5 = new Item(item1, 2);
		Item item6 = new Item(item4, 1);
		Item item7 = new Item(item4, 2);
		Item item8 = new Item(item6, 1);
		Item item9 = new Item(item6, 2);
		Item[] array = {item1,item2,item3,item4,item5,item6,item7,item8,item9};
		ArrayList<Item> list = new ArrayList<Item>();
		
		list.add(item1);
		list.add(item2);
		list.add(item3);
		list.add(item4);
		list.add(item5);
		list.add(item6);
		list.add(item7);
		list.add(item8);
		list.add(item9);
		
//		Collections.sort(list);

		Arrays.sort(array, new MyComparator());
		for(Item item: array)
		{
			System.out.println(item.itemName);
		}
	}

}

class MyComparator implements Comparator<Item>
{

	@Override
	public int compare(Item o1, Item o2) {
		// TODO Auto-generated method stub
//		if(o1 == null)
//		{
//			return 0;
//		}
//		if(o2 == null)
//		{
//			return 0;
//		}
		return o2.itemName.compareTo(o1.itemName);
	}

	
}
