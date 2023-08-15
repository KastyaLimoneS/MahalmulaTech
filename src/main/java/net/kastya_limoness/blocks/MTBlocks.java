package net.kastya_limoness.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.kastya_limoness.MahalmulaTech;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class MTBlocks {
	public static final Block MALACHITE_ORE = registerBlock("malachite_ore",
			new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).requiresTool()));
	public static final Block VILLAGER_SARCOPHAGUS = registerBlock("villager_sarcophagus",
			new VillagerSarcophagus());
	private static Block registerBlock(String name, Block block) {
		return Registry.register(Registries.BLOCK, MahalmulaTech.getIdentifier(name), block);
	}
	public static Item registerBlockItem(String name, Block block) {
		return Registry.register(Registries.ITEM, MahalmulaTech.getIdentifier(name), new BlockItem(block, new FabricItemSettings()));
	}
	public static void register()
	{
		MahalmulaTech.LOGGER.info("Registering Mod Blocks for " + MahalmulaTech.MOD_ID);
	}
}
