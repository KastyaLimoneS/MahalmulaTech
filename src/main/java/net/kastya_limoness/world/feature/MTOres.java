package net.kastya_limoness.world.feature;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.kastya_limoness.MahalmulaTech;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class MTOres {
	public static final RegistryKey<PlacedFeature> END_MALACHITE_ORE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, MahalmulaTech.getIdentifier("end_malachite_ore"));
	public static void register() {
		BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_BARRENS, BiomeKeys.END_HIGHLANDS, BiomeKeys.END_BARRENS), GenerationStep.Feature.UNDERGROUND_ORES, END_MALACHITE_ORE);
	}
}
