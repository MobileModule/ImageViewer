package indi.liyi.viewer.otherui;

import android.content.Context;
import android.view.View;

public abstract class BaseUI {
    private View indexView;

    public abstract View createView(Context context);
}
