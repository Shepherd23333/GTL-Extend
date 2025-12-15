package cn.qiuye.gtlextend.data.recipe;

import cn.qiuye.gtlextend.GTL_Extend;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

import static cn.qiuye.gtlextend.common.data.GTL_Extend_RecipeTypes.PLANETARY_ENGINE_RECIPES;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Oxygen;

public class PlanetaryEngineRecipe {

    public static void init(Consumer<FinishedRecipe> provider) {
        PLANETARY_ENGINE_RECIPES.recipeBuilder(GTL_Extend.id("planet_engine"))
                .inputItems(Blocks.COBBLESTONE.asItem(), Integer.MAX_VALUE - 1)
                .outputFluids(Oxygen.getFluid(FluidStorageKeys.PLASMA, 1111000))
                .inputEU(GTValues.V[GTValues.UEV] * 4)
                .duration(100)
                .save(provider);
    }
}
