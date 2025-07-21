package dev.bebebea_loste.panda_plushies.client;

import dev.bebebea_loste.panda_plushies.Blocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class LootTableGen extends FabricBlockLootTableProvider {
    protected LootTableGen(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(Blocks.PANDA_PLUSH);
        addDrop(Blocks.BEE_PLUSH);
    }
}
