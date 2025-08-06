package cn.qiuye.gtl_extend.common.machine.multiblock.electric;

import cn.qiuye.gtl_extend.common.machine.trait.GTLEXMultipleRecipes;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import org.gtlcore.gtlcore.api.machine.multiblock.ParallelMachine;
import org.jetbrains.annotations.NotNull;

public class GTLEXSuperfluidGeneralEnergyFurnaceMachine extends WorkableElectricMultiblockMachine implements ParallelMachine {

    public GTLEXSuperfluidGeneralEnergyFurnaceMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    public @NotNull RecipeLogic createRecipeLogic(@NotNull Object @NotNull ... args) {
        return new GTLEXMultipleRecipes(this);
    }

    public @NotNull GTLEXMultipleRecipes getRecipeLogic() {
        return (GTLEXMultipleRecipes) super.getRecipeLogic();
    }

    @Override
    public int getMaxParallel() {
        return Integer.MAX_VALUE;
    }
}
