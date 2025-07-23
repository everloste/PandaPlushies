package dev.bebebea_loste.panda_plushies.types;

import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class PlushItem extends BlockItem {

    public PlushItem(Block block, Settings settings) {
        super(block, settings.rarity(Rarity.EPIC).maxCount(1).maxDamage(0).fireproof());
    }

}