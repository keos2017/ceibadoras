package co.com.ceiba.mobile.pruebadeingreso.base;

import android.content.Context;
import androidx.multidex.MultiDexApplication;

/**
 * <p>
 *     Application base para la administracion de propiedades a nivel global,
 *     hereda de Multidex con el fin de evitar el desbordamiento de tama_o de la app.
 * </p>
 *
 * Create By Zorayda 11/3/2020
 * @author Mona15 2020
 * @version 1.0
 */
public class BaseApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    private static BaseApplication mInstance;

    public static BaseApplication getInstance() {
        return mInstance;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }
}
