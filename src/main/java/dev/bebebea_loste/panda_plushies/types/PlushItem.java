package dev.bebebea_loste.panda_plushies.types;

import dev.bebebea_loste.panda_plushies.PandaPlushies;
import net.minecraft.block.*;
import net.minecraft.component.type.*;
import net.minecraft.entity.attribute.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class PlushItem extends BlockItem {

    public PlushItem(Block block, Settings settings) {
        super(block, settings);
    }

    public static final Identifier MINING_SPEED_MODIFIER_ID = Identifier.of(PandaPlushies.MOD_ID, "base_attack_damage");

    public static AttributeModifiersComponent createAttributeModifiers() {
        return AttributeModifiersComponent.builder()
                .add(EntityAttributes.PLAYER_BLOCK_BREAK_SPEED, new EntityAttributeModifier(MINING_SPEED_MODIFIER_ID, -3.0, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL), AttributeModifierSlot.MAINHAND)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, -2.0, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL), AttributeModifierSlot.MAINHAND)
                .build();
    }
    
}