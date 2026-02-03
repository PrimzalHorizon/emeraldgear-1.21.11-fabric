package net.kaijo.emeraldarmorr.mixin;

import net.kaijo.emeraldarmorr.Config;
import net.kaijo.emeraldarmorr.items.Armor;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerData;
import net.minecraft.village.VillagerGossipType;
import net.minecraft.village.VillagerGossips;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.HashMap;
import java.util.Map;

@Mixin(VillagerEntity.class)
public abstract class VillagerTradesMixin {

    @Shadow public abstract VillagerGossips getGossip();

    @Shadow public abstract VillagerData getVillagerData();

    @Shadow @Final private VillagerGossips gossip;

    @Shadow protected abstract void sendOffersToCustomer();

    @Shadow public abstract int getReputation(PlayerEntity player);

    @Shadow public abstract void setVillagerData(VillagerData villagerData);

    @Shadow protected abstract void decayGossip();

    @Shadow private int restocksToday;

    @Inject(method = "interactMob", at = @At("HEAD"))
    private void onInteract(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        if (player.getEntityWorld().isClient()) return;
        VillagerEntity villager = (VillagerEntity)(Object)this;

        this.gossip.remove(player.getUuid(), VillagerGossipType.MAJOR_POSITIVE);
        this.gossip.remove(player.getUuid(), VillagerGossipType.MINOR_POSITIVE);

        if(!(boolean) Config.CONFIG.get("settings.enableVillagerDiscounts")) return;

        boolean hasHelmet = player.getEquippedStack(EquipmentSlot.HEAD).isOf(Armor.EMERALD_HELMET);
        boolean hasChest = player.getEquippedStack(EquipmentSlot.CHEST).isOf(Armor.EMERALD_CHESTPLATE);
        boolean hasLegs = player.getEquippedStack(EquipmentSlot.LEGS).isOf(Armor.EMERALD_LEGGINGS);
        boolean hasBoots = player.getEquippedStack(EquipmentSlot.FEET).isOf(Armor.EMERALD_BOOTS);
        boolean hasAEmeraldItem = player.getMainHandStack().getCreatorNamespace().equals("emeraldgear");

        if (hasHelmet) {
            this.gossip.startGossip(player.getUuid(), VillagerGossipType.MAJOR_POSITIVE, 1);
            this.gossip.startGossip(player.getUuid(), VillagerGossipType.MINOR_POSITIVE, 3);
        }
        if (hasChest) {
            this.gossip.startGossip(player.getUuid(), VillagerGossipType.MAJOR_POSITIVE, 3);
            this.gossip.startGossip(player.getUuid(), VillagerGossipType.MINOR_POSITIVE, 5);
        }
        if (hasLegs) {
            this.gossip.startGossip(player.getUuid(), VillagerGossipType.MAJOR_POSITIVE, 2);
            this.gossip.startGossip(player.getUuid(), VillagerGossipType.MINOR_POSITIVE, 4);
        }
        if (hasBoots) {
            this.gossip.startGossip(player.getUuid(), VillagerGossipType.MAJOR_POSITIVE, 1);
            this.gossip.startGossip(player.getUuid(), VillagerGossipType.MINOR_POSITIVE, 2);
        }
        if(hasAEmeraldItem){
            this.gossip.startGossip(player.getUuid(), VillagerGossipType.MINOR_POSITIVE, 1);
        }


        for (TradeOffer offer : villager.getOffers()) {
            offer.clearSpecialPrice();
        }

        villager.getOffers();
        this.sendOffersToCustomer();
    }
}

