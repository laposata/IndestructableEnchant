package com.dreamtea.mixins;

import com.dreamtea.enchant.Indestructible;
import com.dreamtea.imixin.IDisableItemStacks;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin implements IDisableItemStacks {
  @Override
  public boolean isIndestructible() {
    return Indestructible.isIndestructible((ItemStack) (Object) this);
  }
}
