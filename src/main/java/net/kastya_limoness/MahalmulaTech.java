package net.kastya_limoness;

import net.fabricmc.api.ModInitializer;

import net.kastya_limoness.blocks.MTBlocks;
import net.kastya_limoness.events.ResonanceEventListener;
import net.kastya_limoness.items.MTItems;
import net.kastya_limoness.world.feature.MTOres;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MahalmulaTech implements ModInitializer {
	public static final String MOD_ID = "mahalmulatech";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing " + MOD_ID);
		MTItems.register();
		MTBlocks.register();
		MTOres.register();
		ResonanceEventListener.register();
	}

	public static Identifier getIdentifier(String name) {
		return new Identifier(MOD_ID, name);
	}
}