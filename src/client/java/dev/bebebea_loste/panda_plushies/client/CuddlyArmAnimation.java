//package dev.bebebea_loste.panda_plushies.client;
//
//import dev.tr7zw.notenoughanimations.access.PlayerData;
//import dev.tr7zw.notenoughanimations.api.BasicAnimation;
//import dev.tr7zw.notenoughanimations.versionless.animations.BodyPart;
//import net.minecraft.client.network.AbstractClientPlayerEntity;
//import net.minecraft.client.render.entity.model.PlayerEntityModel;
//
//public class CuddlyArmAnimation extends BasicAnimation {
//
//	// Animation is always enabled
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
//
//	@Override
//	public boolean isValid(AbstractClientPlayerEntity abstractClientPlayerEntity, PlayerData playerData) {
//		return false;
//	}
//
//	@Override
//	public BodyPart[] getBodyParts(AbstractClientPlayerEntity abstractClientPlayerEntity, PlayerData playerData) {
//		return new BodyPart[0];
//	}
//
//	@Override
//	public int getPriority(AbstractClientPlayerEntity abstractClientPlayerEntity, PlayerData playerData) {
//		return 523;
//	}
//
//	@Override
//	public void apply(AbstractClientPlayerEntity abstractClientPlayerEntity, PlayerData playerData, PlayerEntityModel playerEntityModel, BodyPart bodyPart, float v, float v1) {
//
//	}
//}
