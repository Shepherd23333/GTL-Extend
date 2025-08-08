package cn.qiuye.gtl_extend.common.machine.multiblock.electric;

import org.gtlcore.gtlcore.api.machine.multiblock.ParallelMachine;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;

import static org.gtlcore.gtlcore.common.data.GTLRecipeModifiers.getHatchParallel;

public class GTLEXDimensionallyTranscendentDissolvingTank extends WorkableElectricMultiblockMachine implements ParallelMachine {

    public GTLEXDimensionallyTranscendentDissolvingTank(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    /**
     * @return
     */
    @Override
    public int getMaxParallel() {
        return getHatchParallel(this);
    }
}
