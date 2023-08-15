package net.kastya_limoness.events;

import jdk.jfr.EventSettings;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityWorldChangeEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.networking.v1.EntityTrackingEvents;
import net.kastya_limoness.systems.ResonanceManager;

public class ResonanceEventListener {
	public static void register() {
		ServerLivingEntityEvents.ALLOW_DAMAGE.register(((entity, source, amount) -> {
			ResonanceManager.applyToAll(entity, x -> x.damage(source, amount), false);
			return true;
		}));


	}
}
