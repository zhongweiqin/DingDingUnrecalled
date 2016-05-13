package me.veryyoung.dingding.unrecallled;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;


public class Main implements IXposedHookLoadPackage {

    private static final String DINGDING_PACKAGE_NAME = "com.alibaba.android.rimet";

    private static final String MAP_CLASS_NAME = "com.alibaba.wukong.im.message.MessageImpl";
    private static final String MAP_FUNCTION_NAME = "recallStatus";

    @Override
    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {


        if (lpparam.packageName.equals(DINGDING_PACKAGE_NAME)) {

            //map
            findAndHookMethod(MAP_CLASS_NAME, lpparam.classLoader, MAP_FUNCTION_NAME, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(0);
                }
            });
        }
    }
}

