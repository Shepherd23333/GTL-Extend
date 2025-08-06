package cn.qiuye.gtl_extend.data.recipe;

import cn.qiuye.gtl_extend.common.data.GTL_Extend_Materials;
import cn.qiuye.gtl_extend.config.GTLExtendConfigHolder;
import net.minecraft.data.recipes.FinishedRecipe;
import org.gtlcore.gtlcore.common.data.GTLMaterials;
import org.gtlcore.gtlcore.utils.Registries;

import java.util.function.Consumer;

import static cn.qiuye.gtl_extend.common.data.GTL_Extend_Materials.ETERNALBLUEDREAM;
import static cn.qiuye.gtl_extend.common.data.GTL_Extend_RecipeTypes.VOID_PUMP_RECIPES;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.EXTRACTOR_RECIPES;

public class VoidPumpRecipe {
    public static void init(Consumer<FinishedRecipe> provider) {
        ordinary(provider);
        if (GTLExtendConfigHolder.INSTANCE.enableGeneralAEManufacturingMachine) {
            VOID_PUMP_RECIPES.recipeBuilder("gtl_extend_fluid_fluix1")
                    .circuitMeta(32)
                    .outputFluids(GTL_Extend_Materials.FLUIXCRYSTAL.getFluid(1000))
                    .duration(500)
                    .EUt(VA[LuV])
                    .addData("CRTier", 2)
                    .save(provider);

            EXTRACTOR_RECIPES.recipeBuilder("gtl_extend_fluid_fluix")
                    .inputItems(Registries.getItem("ae2:fluix_dust"))
                    .outputFluids(GTL_Extend_Materials.FLUIXCRYSTAL.getFluid(144))
                    .duration(200)
                    .EUt(V[LV])
                    .save(provider);
        }
        if (GTLExtendConfigHolder.INSTANCE.enableInfinityDreamAndDreamHostCrafting) {
            VOID_PUMP_RECIPES.recipeBuilder("eternal_blue_dream_vein_fluid")
                    .circuitMeta(31)
                    .outputFluids(ETERNALBLUEDREAM.getFluid(1000))
                    .duration(500)
                    .EUt(VA[LuV])
                    .addData("CRTier", 2)
                    .save(provider);
        }
    }

    private static void ordinary(Consumer<FinishedRecipe> provider) {
        VOID_PUMP_RECIPES.recipeBuilder("gtl_extend_oil")
                .circuitMeta(1)
                .outputFluids(Oil.getFluid(100000))
                .duration(500)
                .EUt(V[EV])
                .addData("CRTier", 1)
                .save(provider);
        VOID_PUMP_RECIPES.recipeBuilder("gtl_extend_fluid_hafnium")
                .circuitMeta(2)
                .outputFluids(Hafnium.getFluid(100000))
                .duration(500)
                .EUt(V[EV])
                .addData("CRTier", 1)
                .save(provider);
        VOID_PUMP_RECIPES.recipeBuilder("gtl_extend_fluid_radon")
                .circuitMeta(3)
                .outputFluids(Radon.getFluid(100000))
                .duration(500)
                .EUt(V[EV])
                .addData("CRTier", 1)
                .save(provider);
        VOID_PUMP_RECIPES.recipeBuilder("gtl_extend_fluid_deuterium")
                .circuitMeta(4)
                .outputFluids(Deuterium.getFluid(100000))
                .duration(500)
                .EUt(V[EV])
                .addData("CRTier", 1)
                .save(provider);
        VOID_PUMP_RECIPES.recipeBuilder("gtl_extend_fluid_sulfuric_acid")
                .circuitMeta(5)
                .outputFluids(SulfuricAcid.getFluid(100000))
                .duration(500)
                .EUt(V[EV])
                .addData("CRTier", 1)
                .save(provider);
        VOID_PUMP_RECIPES.recipeBuilder("gtl_extend_fluid_neon")
                .circuitMeta(6)
                .outputFluids(Neon.getFluid(100000))
                .duration(500)
                .EUt(V[EV])
                .addData("CRTier", 1)
                .save(provider);
        VOID_PUMP_RECIPES.recipeBuilder("gtl_extend_fluid_krypton")
                .circuitMeta(7)
                .outputFluids(Krypton.getFluid(100000))
                .duration(500)
                .EUt(V[EV])
                .addData("CRTier", 1)
                .save(provider);
        VOID_PUMP_RECIPES.recipeBuilder("gtl_extend_fluid_xenon")
                .circuitMeta(8)
                .outputFluids(Xenon.getFluid(100000))
                .duration(500)
                .EUt(V[EV])
                .addData("CRTier", 1)
                .save(provider);
        VOID_PUMP_RECIPES.recipeBuilder("gtl_extend_fluid_coal_gas")
                .circuitMeta(9)
                .outputFluids(CoalGas.getFluid(100000))
                .duration(500)
                .EUt(V[EV])
                .addData("CRTier", 1)
                .save(provider);
        VOID_PUMP_RECIPES.recipeBuilder("gtl_extend_fluid_hydrochloric_acid")
                .circuitMeta(10)
                .outputFluids(HydrochloricAcid.getFluid(100000))
                .duration(500)
                .EUt(V[EV])
                .addData("CRTier", 1)
                .save(provider);
        VOID_PUMP_RECIPES.recipeBuilder("gtl_extend_fluid_chlorine")
                .circuitMeta(11)
                .outputFluids(Chlorine.getFluid(100000))
                .duration(500)
                .EUt(V[EV])
                .addData("CRTier", 1)
                .save(provider);
        VOID_PUMP_RECIPES.recipeBuilder("gtl_extend_fluid_fluorine")
                .circuitMeta(12)
                .outputFluids(Fluorine.getFluid(100000))
                .duration(500)
                .EUt(V[EV])
                .addData("CRTier", 1)
                .save(provider);
        VOID_PUMP_RECIPES.recipeBuilder("gtl_extend_fluid_unknowwater")
                .circuitMeta(13)
                .outputFluids(GTLMaterials.UnknowWater.getFluid(100000))
                .duration(500)
                .EUt(V[EV])
                .addData("CRTier", 1)
                .save(provider);
        VOID_PUMP_RECIPES.recipeBuilder("gtl_extend_fluid_nitric_acid")
                .circuitMeta(14)
                .outputFluids(NitricAcid.getFluid(100000))
                .duration(500)
                .EUt(V[EV])
                .addData("CRTier", 1)
                .save(provider);

    }
}
