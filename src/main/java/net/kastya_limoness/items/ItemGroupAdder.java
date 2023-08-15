package net.kastya_limoness.items;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.RegistryKey;

import java.lang.reflect.Field;
import java.util.Map;

public class ItemGroupAdder {
	public static void addItemsToGroups()
	{
		Class<MTItems> clazz = MTItems.class;
		for (Field field: clazz.getFields()) {
			if (!field.isAnnotationPresent(ItemGroupAnnotation.class))
				continue;
			try {
				Item item = (Item) field.get(null);
				String[] groupNames = field.getAnnotation(ItemGroupAnnotation.class).value();
				for (String groupName: groupNames) {
					try {
						RegistryKey<ItemGroup> group = (RegistryKey<ItemGroup>) ItemGroups.class.getField(groupName).get(null);
						ItemGroupEvents.modifyEntriesEvent(group).register(x -> x.add(item));
					} catch (NoSuchFieldException e) {
						continue;
					}
				}
			} catch (IllegalAccessException e) {
				continue;
			}
		}
	}
}
