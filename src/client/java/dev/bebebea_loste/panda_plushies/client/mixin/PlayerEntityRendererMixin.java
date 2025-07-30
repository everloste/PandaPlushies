//package dev.bebebea_loste.panda_plushies.client.mixin;
//
//import dev.bebebea_loste.panda_plushies.types.PlushItem;
//import net.minecraft.client.network.AbstractClientPlayerEntity;
//import net.minecraft.client.render.entity.PlayerEntityRenderer;
//import net.minecraft.util.Hand;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//
//import net.minecraft.client.render.entity.model.BipedEntityModel;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//
//@Mixin(PlayerEntityRenderer.class)
//public class PlayerEntityRendererMixin {
//
//	@Inject(
//			method = {"getArmPose"},
//			at = @At(
//					value = "HEAD",
//					target = "Lnet/minecraft/client/render/entity/PlayerEntityRenderer;getArmPose(Lnet/minecraft/client/network/AbstractClientPlayerEntity;Lnet/minecraft/util/Hand;)Lnet/minecraft/client/render/entity/model/BipedEntityModel$ArmPose;"
//			),
//			cancellable = true
//	)
//	private static void getArmPose(AbstractClientPlayerEntity player, Hand hand, CallbackInfoReturnable<BipedEntityModel.ArmPose> cir) {
//		if (player.getMainHandStack().getItem() instanceof PlushItem || player.getOffHandStack().getItem() instanceof PlushItem) {
//			cir.setReturnValue(BipedEntityModel.ArmPose.CROSSBOW_HOLD);
//		}
//	}
//
//}
