package cn.qiuye.gtl_extend.data.recipe;

import cn.qiuye.gtl_extend.common.data.machines.MultiBlockMachineA;

import org.gtlcore.gtlcore.utils.Registries;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.IV;
import static com.gregtechceu.gtceu.api.GTValues.V;
import static org.gtlcore.gtlcore.common.data.GTLRecipeTypes.ELECTRIC_IMPLOSION_COMPRESSOR_RECIPES;

public class ElectricImplosionCompressorRecipe {

    public static void init(Consumer<FinishedRecipe> provider) {
        ELECTRIC_IMPLOSION_COMPRESSOR_RECIPES.recipeBuilder("large_world_void_pump")
                .inputItems(Registries.getItem("gtceu:ev_fluid_drilling_rig"), 64)
                .inputItems(Registries.getItem("gtceu:ev_fluid_drilling_rig"), 64)
                .outputItems(MultiBlockMachineA.LARGE_VOID_PUMP)
                .duration(2048)
                .EUt(V[IV])
                .save(provider);
    }
}
