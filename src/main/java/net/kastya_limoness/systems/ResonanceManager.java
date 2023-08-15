package net.kastya_limoness.systems;

import net.minecraft.entity.LivingEntity;

import java.util.*;
import java.util.function.Consumer;

public class ResonanceManager {
	private static final List<LivingEntity>[] WAVES = new List[] {
			new ArrayList<LivingEntity>(),
			new ArrayList<LivingEntity>(),
			new ArrayList<LivingEntity>(),
			new ArrayList<LivingEntity>(),
			new ArrayList<LivingEntity>(),
			new ArrayList<LivingEntity>(),
			new ArrayList<LivingEntity>(),
			new ArrayList<LivingEntity>(),
			new ArrayList<LivingEntity>(),
			new ArrayList<LivingEntity>(),
			new ArrayList<LivingEntity>(),
			new ArrayList<LivingEntity>(),
			new ArrayList<LivingEntity>(),
			new ArrayList<LivingEntity>(),
			new ArrayList<LivingEntity>(),
			new ArrayList<LivingEntity>()
	};

	private static Map<LivingEntity, List<Integer>> WAVED = new HashMap<>();

	private static List<LivingEntity> BLOCKED = new ArrayList<>();

	public static void addOrDeleteResonance(LivingEntity LivingEntity, int resonance) {
		if (WAVES[resonance].contains(LivingEntity)) {
			WAVES[resonance].remove(LivingEntity);
			if (WAVED.containsKey(LivingEntity))
				if (WAVED.get(LivingEntity).contains(resonance))
					WAVED.get(LivingEntity).removeIf(x -> x == resonance);
			return;
		}
		WAVES[resonance].add(LivingEntity);
		if (WAVED.containsKey(LivingEntity)) {
			if (!WAVED.get(LivingEntity).contains(resonance)) WAVED.get(LivingEntity).add(resonance);
		}
		else {
			WAVED.put(LivingEntity, new ArrayList<>(Arrays.asList(resonance)));
		}
	}

	public static void applyToAll(LivingEntity entity, Consumer<LivingEntity> func, boolean include) {
		if (isBlocked(entity)) {
			clear(entity);
			return;
		}
		if (include)
			func.accept(entity);
		if (WAVED.containsKey(entity))
			for (int res: WAVED.get(entity)) {
				for (LivingEntity subentity: WAVES[res]) {
					if (subentity != entity) {
						BLOCKED.add(subentity);
						func.accept(subentity);
					}
				}
			}
	}

	public static boolean isBlocked(LivingEntity entity) {
		return BLOCKED.contains(entity);
	}

	public static void clear(LivingEntity entity)
	{
		BLOCKED.remove(entity);
	}
}
