package dev.mateusamaral720.techessentials.api;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.bukkit.entity.Player;

public class TitleAPI
{
    private static Method a;
    private static Object enumTIMES;
    private static Object enumTITLE;
    private static Object enumSUBTITLE;
    private static Constructor<?> timeTitleConstructor;
    private static Constructor<?> textTitleConstructor;
    
    public static void sendTitle(final Player player, final Integer fadeIn, final Integer stay, final Integer fadeOut, final String title, final String subtitle) {
        try {
            final Object chatTitle = TitleAPI.a.invoke(null, "{\"text\":\"" + title + "\"}");
            final Object chatSubtitle = TitleAPI.a.invoke(null, "{\"text\":\"" + subtitle + "\"}");
            final Object timeTitlePacket = TitleAPI.timeTitleConstructor.newInstance(TitleAPI.enumTIMES, null, fadeIn, stay, fadeOut);
            ReflectionUtils.sendPacket(player, timeTitlePacket);
            final Object titlePacket = TitleAPI.textTitleConstructor.newInstance(TitleAPI.enumTITLE, chatTitle);
            ReflectionUtils.sendPacket(player, titlePacket);
            final Object subtitlePacket = TitleAPI.textTitleConstructor.newInstance(TitleAPI.enumSUBTITLE, chatSubtitle);
            ReflectionUtils.sendPacket(player, subtitlePacket);
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }
    
    static void load() {
        try {
            final Class<?> icbc = ReflectionUtils.getNMSClass("IChatBaseComponent");
            final Class<?> ppot = ReflectionUtils.getNMSClass("PacketPlayOutTitle");
            Class<?> enumClass;
            if (ppot.getDeclaredClasses().length > 0) {
                enumClass = ppot.getDeclaredClasses()[0];
            }
            else {
                enumClass = ReflectionUtils.getNMSClass("EnumTitleAction");
            }
            if (icbc.getDeclaredClasses().length > 0) {
                TitleAPI.a = icbc.getDeclaredClasses()[0].getMethod("a", String.class);
            }
            else {
                TitleAPI.a = ReflectionUtils.getNMSClass("ChatSerializer").getMethod("a", String.class);
            }
            TitleAPI.enumTIMES = enumClass.getField("TIMES").get(null);
            TitleAPI.enumTITLE = enumClass.getField("TITLE").get(null);
            TitleAPI.enumSUBTITLE = enumClass.getField("SUBTITLE").get(null);
            TitleAPI.timeTitleConstructor = ppot.getConstructor(enumClass, icbc, Integer.TYPE, Integer.TYPE, Integer.TYPE);
            TitleAPI.textTitleConstructor = ppot.getConstructor(enumClass, icbc);
        }
        catch (Throwable t) {}
    }
}
