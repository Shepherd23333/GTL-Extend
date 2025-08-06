package cn.qiuye.gtl_extend;

import cn.qiuye.gtl_extend.client.ClientProxy;
import cn.qiuye.gtl_extend.common.CommonProxy;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import org.gtlcore.gtlcore.GTLCore;
import org.gtlcore.gtlcore.utils.StorageManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(GTL_Extend.MODID)
public class GTL_Extend {

    public static final String MODID = "gtl_extend",
            NAME = "GTL Extend";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    public static StorageManager STORAGE_INSTANCE = new StorageManager();

    public static ResourceLocation id(String name) {
        return new ResourceLocation(MODID, name);
    }

    public GTL_Extend() {
        DistExecutor.unsafeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.addListener(GTLCore::worldTick);
    }
}
