package com.dreamtea.enchant;

import com.dreamtea.tag.TagUtils;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.UnbreakingEnchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.dreamtea.IndestructibleEnchant.INDESTRUCTIBLE_ENCHANT;
import static com.dreamtea.IndestructibleEnchant.NAMESPACE;
import static com.dreamtea.tag.IndestructibleTag.INDESTRUCTIBLE_ITEMS;

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


  @Override
  public boolean isAcceptableItem(ItemStack stack) {
    if (TagUtils.itemIsIn(stack, INDESTRUCTIBLE_ITEMS)) {
      return false;
    }
    return super.isAcceptableItem(stack);
  }

  public static boolean isIndestructible(ItemStack item){
    return EnchantmentHelper.get(item).containsKey(INDESTRUCTIBLE_ENCHANT)
      || TagUtils.itemIsIn(item, INDESTRUCTIBLE_ITEMS);
  }

  public static Enchantment register() {
    return Registry.register(Registries.ENCHANTMENT, new Identifier(NAMESPACE, "indestructible"), new Indestructible(Enchantment.Rarity.RARE));
  }

}
