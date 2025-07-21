package dev.bebebea_loste.panda_plushies;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.*;
import net.minecraft.item.*;
import net.minecraft.loot.*;
import net.minecraft.loot.entry.*;

public class PandaPlushies implements ModInitializer {

    public static final String MOD_ID = "panda_plushies";

    public void onInitialize() {
        Blocks.register();
        registerLootTables();
    }

    // Add loot to relevant loot tables here
    private static void registerLootTables() {
        LootTableEvents.MODIFY.register((key,tableBuilder, source, wrapperLookup) -> {
            if (key.equals(LootTables.VILLAGE_PLAINS_CHEST)) {
                LootPool.Builder pb = LootPool.builder()
                        .with(ItemEntry.builder(Blocks.PANDA_PLUSH))
                        .with(ItemEntry.builder(Items.AIR).weight(25));
                tableBuilder.pool(pb);
            } else if (key.equals(LootTables.VILLAGE_TAIGA_HOUSE_CHEST) || key.equals(LootTables.VILLAGE_SNOWY_HOUSE_CHEST)) {
                LootPool.Builder pb = LootPool.builder()
                        .with(ItemEntry.builder(Blocks.PANDA_PLUSH).weight(3))
                        .with(ItemEntry.builder(Items.AIR).weight(50));
                tableBuilder.pool(pb);
            }
        });
    }

}
