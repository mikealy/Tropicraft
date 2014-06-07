package net.tropicraft.util;

import java.util.ArrayList;

import net.minecraft.item.ItemDye;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;

/**
 * Class to assist chairs, umbrellas, beach floats, and whatever else uses our dynamic coloring system.
 */
public class ColorHelper {
	/** List of metadata of wool (or just a unique identifier for colors) to an integer color */
	private static BiMap<Integer, Integer> woolValues = HashBiMap.create();
	
	/** List of integer color values, each index is the color associated with that metadata value */
	private static ArrayList<Integer> colorValues = Lists.newArrayList();
	
	/** Value used in entityInit methods as a 'default' value */
	public static int DEFAULT_VALUE;

	public static void init() {
		// Get all the existing wool colors into the color array
		for (int color : ItemDye.field_150922_c) {
			colorValues.add(Integer.valueOf(color));
		}
		
		DEFAULT_VALUE = colorValues.get(0);
		
		// Map the color values to metadata values in the bidirectional map
		for (int i = 0; i < colorValues.size(); i++) {
			woolValues.put(Integer.valueOf(ItemDye.field_150922_c[i]), i);
		}
	}
	
	/**
	 * @return Return the number of colors registered
	 */
	public static int getNumColors() {
		return woolValues.keySet().size();
	}
	
	/**
	 * @param damage Damage/metadata value
	 * @return Return an integer rgba color that is associated with the given damage value
	 */
	public static int getColorFromDamage(int damage) {
		return colorValues.get(Integer.valueOf(damage));
	}
	
	/**
	 * @param color rgba int color value
	 * @return Return the damage value associated with the given rgba color
	 */
	public static int getDamageFromColor(int color) {
		return woolValues.get(Integer.valueOf(color));
	}
}