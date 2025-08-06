package cn.qiuye.gtl_extend.common.data;

import cn.qiuye.gtl_extend.common.data.machines.GTL_Extend_MaterialsBuilder;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;

public class GTL_Extend_Materials {

    public static Material ETERNALBLUEDREAM;
    public static Material FLUIXCRYSTAL;

    public static void init() {
        GTL_Extend_MaterialsBuilder.init();
    }
}
