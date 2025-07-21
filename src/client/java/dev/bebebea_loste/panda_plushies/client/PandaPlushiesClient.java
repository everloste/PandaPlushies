package dev.bebebea_loste.panda_plushies.client;

import net.fabricmc.api.ClientModInitializer;
import dev.bebebea_loste.panda_plushies.*;
import net.fabricmc.fabric.api.blockrenderlayer.v1.*;
import net.minecraft.client.render.*;

public class PandaPlushiesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), Blocks.PANDA_PLUSH, Blocks.BEE_PLUSH, Blocks.RUDOLPH_PLUSH);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), Blocks.BEE_PLUSH);
    }
}
