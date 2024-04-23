package net.mcreator.moreextrathingshere.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.BlockPos;

import net.mcreator.moreextrathingshere.init.MoreextrathingshereModEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SpeedIceProcedureProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (EnchantmentHelper.getItemEnchantmentLevel(MoreextrathingshereModEnchantments.SPEED_ICE.get(),
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.byTypeAndIndex(EquipmentSlot.Type.ARMOR, 4)) : ItemStack.EMPTY)) != 0) {
			if ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + -1, entity.getZ()))).getBlock() == Blocks.ICE
					|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + -1, entity.getZ()))).getBlock() == Blocks.PACKED_ICE
					|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + -1, entity.getZ()))).getBlock() == Blocks.FROSTED_ICE
					|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + -1, entity.getZ()))).getBlock() == Blocks.BLUE_ICE) {
				if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.byTypeAndIndex(EquipmentSlot.Type.ARMOR, 4)) : ItemStack.EMPTY)
						.getEnchantmentLevel(MoreextrathingshereModEnchantments.SPEED_ICE.get()) == 1) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1, 1));
				} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.byTypeAndIndex(EquipmentSlot.Type.ARMOR, 4)) : ItemStack.EMPTY)
						.getEnchantmentLevel(MoreextrathingshereModEnchantments.SPEED_ICE.get()) == 2) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1, 2));
				} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.byTypeAndIndex(EquipmentSlot.Type.ARMOR, 4)) : ItemStack.EMPTY)
						.getEnchantmentLevel(MoreextrathingshereModEnchantments.SPEED_ICE.get()) == 3) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1, 3));
				}
			}
		}
	}
}
