package cakeFactory;

public class Cake {
private String id;
private String name;
private int netPrice;
private int slices;
private boolean onSale;
private boolean glutenFree;
private boolean lactoseFree;

public Cake(String id, String name, int netPrice, int slices, boolean onSale, boolean glutenFree, boolean lactoseFree) {
	super();
	this.id = id;
	this.name = name;
	this.netPrice = netPrice;
	this.slices = slices;
	this.onSale = onSale;
	this.glutenFree = glutenFree;
	this.lactoseFree = lactoseFree;
}

public String getId() {
	return id;
}

public String getName() {
	return name;
}

public int getNetPrice() {
	return netPrice;
}

public int getSlices() {
	return slices;
}

public boolean isOnSale() {
	return onSale;
}

public boolean isGlutenFree() {
	return glutenFree;
}

public boolean isLactoseFree() {
	return lactoseFree;
}

@Override
public String toString() {
	return "Cake [id=" + id + ", name=" + name + ", netPrice=" + netPrice + ", slices=" + slices + ", onSale=" + onSale
			+ ", glutenFree=" + glutenFree + ", lactoseFree=" + lactoseFree + "]";
}
	

}

