package cn.qiuye.gtl_extend.mixin.gtl;

import cn.qiuye.gtl_extend.data.recipe.*;

import org.gtlcore.gtlcore.GTLGTAddon;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GTLGTAddon.class)
public class GTLGTAddonMixin {

    @Inject(
            method = "addRecipes",
            at = @At("HEAD"),
            remap = false,
            require = 1)
    private void injectCustomRecipes(Consumer<FinishedRecipe> provider, CallbackInfo ci) {
        GTLEXMachineRecipe.init(provider);
        CircuitsRecipe.init(provider);
        GeneralAE_Recipe.init(provider);
        VoidPumpRecipe.init(provider);
        CattleCattleRecipe.init(provider);
        ElectricImplosionCompressorRecipe.init(provider);
        OneStopPlatinumTreatmentRecipe.init(provider);
        AdvFormulationLimitsRecipe.init(provider);
        HorizonMatterDecompression.init(provider);
        DimensionalPowerRecipe.init(provider);
    }
}
