package cn.qiuye.gtl_extend.mixin.gtl;

import org.gtlcore.gtlcore.GTLGTAddon;

import net.minecraft.data.recipes.FinishedRecipe;

//import cn.qiuye.gtl_extend.common.data.recipe.MiscRecipes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(GTLGTAddon.class)
public abstract class GTL_EX_AddionMixin {

    @Inject(
            method = "addRecipes",
            at = @At("HEAD"),
            remap = false,
            require = 1)
    private void injectCustomRecipes(Consumer<FinishedRecipe> provider, CallbackInfo ci) {
        // 仅注册本mod的配方
    }
}
