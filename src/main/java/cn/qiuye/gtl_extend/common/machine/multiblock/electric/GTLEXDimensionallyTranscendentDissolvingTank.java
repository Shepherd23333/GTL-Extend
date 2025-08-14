package cn.qiuye.gtl_extend.common.machine.multiblock.electric;

import cn.qiuye.gtl_extend.common.machine.trait.GTLEXMultipleRecipes;

import org.gtlcore.gtlcore.api.machine.multiblock.ParallelMachine;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;

import static org.gtlcore.gtlcore.common.data.GTLRecipeModifiers.getHatchParallel;

import org.jetbrains.annotations.NotNull;

public class GTLEXDimensionallyTranscendentDissolvingTank extends WorkableElectricMultiblockMachine implements ParallelMachine {

    public GTLEXDimensionallyTranscendentDissolvingTank(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    public @NotNull RecipeLogic createRecipeLogic(@NotNull Object @NotNull... args) {
        return new GTLEXMultipleRecipes(this);
    }

    public @NotNull GTLEXMultipleRecipes getRecipeLogic() {
        return (GTLEXMultipleRecipes) super.getRecipeLogic();
    }

    /**
     * @return .
     */
    @Override
    public int getMaxParallel() {
        return getHatchParallel(this);
    }
}
