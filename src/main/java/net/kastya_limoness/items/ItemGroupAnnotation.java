package net.kastya_limoness.items;

import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ItemGroupAnnotation {
	 String[] value();
}
