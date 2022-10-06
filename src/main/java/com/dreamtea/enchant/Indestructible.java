package com.dreamtea.enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.UnbreakingEnchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.dreamtea.IndestructibleEnchant.INDESTRUCTIBLE_ENCHANT;
import static com.dreamtea.IndestructibleEnchant.NAMESPACE;

public class Indestructible extends Enchantment {
  protected Indestructible(Rarity weight) {
    super(weight, EnchantmentTarget.BREAKABLE, EquipmentSlot.values());
  }

  public int getMinPower(int level) {
    return level * 25;
  }

  public int getMaxPower(int level) {
    return this.getMinPower(level) + 50;
  }

  public boolean isTreasure() {
    return true;
  }

  public int getMaxLevel() {
    return 1;
  }

  @Override
  public boolean canAccept(Enchantment other) {
    if (other instanceof UnbreakingEnchantment) {
      return false;
    }
    return super.canAccept(other);
  }

  public static boolean isIndestructible(ItemStack item){
    return EnchantmentHelper.get(item).containsKey(INDESTRUCTIBLE_ENCHANT);
  }

  public static Enchantment register() {
    return Registry.register(Registry.ENCHANTMENT, new Identifier(NAMESPACE, "indestructible"), new Indestructible(Enchantment.Rarity.RARE));
  }
}
