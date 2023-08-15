package net.kastya_limoness.items.advancedItems;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.kastya_limoness.systems.ResonanceManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class ResonanceRod extends Item {
	public ResonanceRod() {
		super(new FabricItemSettings().maxCount(1).fireproof());
	}

	@Override
	public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
		if (user.getWorld().isClient)
			return ActionResult.PASS;
		ResonanceManager.addOrDeleteResonance(entity, stack.getNbt().getInt("wave"));
		return ActionResult.SUCCESS;
	}

	@Override
	public ItemStack getDefaultStack() {
		ItemStack stack = super.getDefaultStack();
		stack.getOrCreateNbt().putInt("wave", 0);
		return stack;
	}



	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		if (context.getPlayer() == null)
			return ActionResult.PASS;
		if (context.getPlayer().shouldCancelInteraction()) {
			changeWave(context);
			return  ActionResult.PASS;
		}
		return  ActionResult.SUCCESS;
	}



	private void changeWave(ItemUsageContext context) {
		if (!(context.getWorld() instanceof ServerWorld))
			return;
		NbtCompound nbt = context.getStack().getOrCreateNbt();
		int newWave = (nbt.getInt("wave") + 1) % 16;
		((ServerPlayerEntity)context.getPlayer()).sendMessageToClient(Text.translatable("mt.msg.wave_changed").append(((Integer)newWave).toString()), true);
		nbt.putInt("wave", newWave);
		context.getStack().setNbt(nbt);
	}
}
