package com.mowmaster.projectcookbook.Items.FirstDraftItems;

import com.mowmaster.projectcookbook.Items.FirstDraftItemRegistry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import org.jspecify.annotations.Nullable;

public class BasicMnP extends Item {
    public BasicMnP(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable ItemStackTemplate getCraftingRemainder(ItemInstance instance) {

        int currentDamage = instance.getOrDefault(DataComponents.DAMAGE,0);
        currentDamage+=1;

        int maxDamage = instance.getOrDefault(DataComponents.MAX_DAMAGE,0);
        if(currentDamage>=maxDamage)
        {
            return null;
        }
        else {
            ItemStack damagedStack = new ItemStack(FirstDraftItemRegistry.FIRSTDRAFT_MORTAR_AND_PESTLE.get());

            // 2. Set the desired damage value directly on the stack
            damagedStack.setDamageValue(currentDamage);

            // 3. Convert it into an immutable template container
            return ItemStackTemplate.fromNonEmptyStack(damagedStack);
        }
    }
}
