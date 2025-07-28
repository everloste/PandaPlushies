package dev.bebebea_loste.panda_plushies;

import dev.bebebea_loste.panda_plushies.types.PlushBlock;
import dev.bebebea_loste.panda_plushies.types.PlushItem;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import static dev.bebebea_loste.panda_plushies.PandaPlushies.MOD_ID;

public class Blocks {

    public static Block PANDA_PLUSH;
    public static Block BEE_PLUSH;
    public static Block RUDOLPH_PLUSH;

    public static void register() {
        Identifier PANDA_ID = Identifier.of(MOD_ID, "panda_plushie");
        PANDA_PLUSH = Registry.register(Registries.BLOCK, PANDA_ID, new PlushBlock(AbstractBlock.Settings.copy(net.minecraft.block.Blocks.ORANGE_WOOL).registryKey(RegistryKey.of(RegistryKeys.BLOCK, PANDA_ID))));
        Registry.register(Registries.ITEM, PANDA_ID, new PlushItem(PANDA_PLUSH, new Item.Settings().maxCount(1).registryKey(RegistryKey.of(RegistryKeys.ITEM, PANDA_ID))));

        Identifier BEE_ID = Identifier.of(MOD_ID, "bee_plushie");
        BEE_PLUSH = Registry.register(Registries.BLOCK, BEE_ID, new PlushBlock(AbstractBlock.Settings.copy(net.minecraft.block.Blocks.ORANGE_WOOL).registryKey(RegistryKey.of(RegistryKeys.BLOCK, BEE_ID))));
        Registry.register(Registries.ITEM, BEE_ID, new PlushItem(BEE_PLUSH, new Item.Settings().maxCount(1).registryKey(RegistryKey.of(RegistryKeys.ITEM, BEE_ID))));

        Identifier RUDOLPH_ID = Identifier.of(MOD_ID, "reindeer_plushie");
        RUDOLPH_PLUSH = Registry.register(Registries.BLOCK, RUDOLPH_ID, new PlushBlock(AbstractBlock.Settings.copy(net.minecraft.block.Blocks.ORANGE_WOOL).registryKey(RegistryKey.of(RegistryKeys.BLOCK, RUDOLPH_ID))));
        Registry.register(Registries.ITEM, RUDOLPH_ID, new PlushItem(RUDOLPH_PLUSH, new Item.Settings().maxCount(1).registryKey(RegistryKey.of(RegistryKeys.ITEM, RUDOLPH_ID))));
    }

}
