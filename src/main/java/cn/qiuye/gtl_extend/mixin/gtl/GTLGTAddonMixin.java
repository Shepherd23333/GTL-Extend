package cn.qiuye.gtl_extend.mixin.gtl;

import net.minecraft.data.recipes.FinishedRecipe;
import org.gtlcore.gtlcore.GTLGTAddon;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(GTLGTAddon.class)
public class GTLGTAddonMixin {

    @Inject(
            method = "addRecipes",
            at = @At("HEAD"),
            remap = false,
            require = 1)
    private void injectCustomRecipes(Consumer<FinishedRecipe> provider, CallbackInfo ci) {

    }

}
