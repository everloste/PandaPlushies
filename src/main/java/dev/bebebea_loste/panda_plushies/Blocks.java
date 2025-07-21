package dev.bebebea_loste.panda_plushies;

import dev.bebebea_loste.panda_plushies.types.PlushBlock;
import dev.bebebea_loste.panda_plushies.types.PlushItem;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static dev.bebebea_loste.panda_plushies.PandaPlushies.MOD_ID;

public class Blocks {

    public static Block PANDA_PLUSH;
    public static Block BEE_PLUSH;
    public static Block RUDOLPH_PLUSH;

    public static void register() {
        PANDA_PLUSH = Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, "panda_plush"), new PlushBlock(AbstractBlock.Settings.copy(net.minecraft.block.Blocks.ORANGE_WOOL)));
        Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "panda_plush"), new PlushItem(PANDA_PLUSH, new Item.Settings().maxCount(1)));

        BEE_PLUSH = Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, "bee_plush"), new PlushBlock(AbstractBlock.Settings.copy(net.minecraft.block.Blocks.ORANGE_WOOL)));
        Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "bee_plush"), new PlushItem(BEE_PLUSH, new Item.Settings().maxCount(1)));

        RUDOLPH_PLUSH = Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, "reindeer_plush"), new PlushBlock(AbstractBlock.Settings.copy(net.minecraft.block.Blocks.ORANGE_WOOL)));
        Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "reindeer_plush"), new PlushItem(RUDOLPH_PLUSH, new Item.Settings().maxCount(1)));
    }

}
