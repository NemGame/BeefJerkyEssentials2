package lol.ngakos.beefjerkyessentials2.event;

import lol.ngakos.beefjerkyessentials2.item.ModItems;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.world.ServerWorld;

public class ZombieBurnDropHandler {
    public static void register() {
        ServerLivingEntityEvents.AFTER_DEATH.register((entity, source) -> {
            if (entity.getType() != EntityType.ZOMBIE || !diedInFire(entity, source)) {
                return;
            }

            ServerWorld world = (ServerWorld) entity.getWorld();

            for (ItemEntity drop : world.getEntitiesByClass(
                    ItemEntity.class,
                    entity.getBoundingBox().expand(1.25),
                    itemEntity -> itemEntity.isAlive() && itemEntity.getStack().isOf(Items.ROTTEN_FLESH)
            )) {
                ItemStack oldStack = drop.getStack();
                drop.setStack(new ItemStack(ModItems.COOKED_JERKY, oldStack.getCount()));
            }
        });
    }
    private static boolean diedInFire(LivingEntity entity, DamageSource source) {
        boolean fireDamageSource = source != null && source.isIn(DamageTypeTags.IS_FIRE);

        boolean wasOnFire = entity.isOnFire() || entity.getFireTicks() > 0;
        return fireDamageSource || wasOnFire;
    }
}
