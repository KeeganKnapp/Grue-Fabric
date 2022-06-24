package me.suplexgod.grue.entity.client;

import me.suplexgod.grue.Grue;
import me.suplexgod.grue.entity.custom.SpiritEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class GrueModel extends AnimatedGeoModel<SpiritEntity> {
    @Override
    public Identifier getModelLocation(SpiritEntity object) {
        return new Identifier(Grue.MOD_ID, "geo/spirit.geo.json");
    }

    @Override
    public Identifier getTextureLocation(SpiritEntity object) {
        return new Identifier(Grue.MOD_ID, "textures/entity/spirit/spirit.png");
    }

    @Override
    public Identifier getAnimationFileLocation(SpiritEntity animatable) {
        return new Identifier(Grue.MOD_ID, "animations/spirit.animation.json");
    }
    /*
    public void setLivingAnimations(SpiritEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI/ 180F));
        }
    }
     */
}
