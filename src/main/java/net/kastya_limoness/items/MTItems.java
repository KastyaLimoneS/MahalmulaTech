package net.kastya_limoness.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.kastya_limoness.MahalmulaTech;
import net.kastya_limoness.blocks.MTBlocks;
import net.kastya_limoness.items.advancedItems.ResonanceRod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.Arrays;

public class MTItems {

    @ItemGroupAnnotation({"INGREDIENTS"})
    public static final Item MALACHITE = registerItem("malachite", new Item(new FabricItemSettings()));
    @ItemGroupAnnotation({"INGREDIENTS"})
    public static final Item RAW_MALACHITE = registerItem("raw_malachite", new Item(new FabricItemSettings()));
    @ItemGroupAnnotation({"INGREDIENTS"})
    public static final Item MALACHITE_ROD = registerItem("malachite_rod", new Item(new FabricItemSettings()));

    //block items
    @ItemGroupAnnotation({"NATURAL", "BUILDING_BLOCKS"})
    public static final Item MALACHITE_ORE = MTBlocks.registerBlockItem("malachite_ore", MTBlocks.MALACHITE_ORE);
    @ItemGroupAnnotation({"REDSTONE", "FUNCTIONAL"})
    public static final Item VILLAGER_SARCOPHAGUS = MTBlocks.registerBlockItem("villager_sarcophagus", MTBlocks.VILLAGER_SARCOPHAGUS);
    //eo block items

    //cool stuff
    @ItemGroupAnnotation({"TOOLS"})
    public static final Item RESONANCE_ROD = registerItem("resonance_rod", new ResonanceRod());
    //eo cool stuff

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, MahalmulaTech.getIdentifier(name), item);
    }
    public static void register() {
        MahalmulaTech.LOGGER.info("Registering Mod Items for " + MahalmulaTech.MOD_ID);
        ItemGroupAdder.addItemsToGroups();
    }
}
