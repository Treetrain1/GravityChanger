package gravity_changer.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import gravity_changer.api.GravityChangerAPI;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Boat.class)
public class BoatMixin {
    @ModifyExpressionValue(method = "floatBoat", at = @At(value = "CONSTANT", args = {"doubleValue=-0.03999999910593033"}))
    private double multiplyGravity(double constant) {
        return constant * GravityChangerAPI.getGravityStrength(((Entity) (Object) this));
    }
}
