package indi.liyi.viewer.otherui;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import indi.liyi.viewer.R;
import indi.liyi.viewer.Utils;

public class DeleteIndexUI {
    private boolean overlayStatusBar;

    public DeleteIndexUI(boolean overlayStatusBar) {
        this.overlayStatusBar = overlayStatusBar;
    }

    private boolean deleteMenuVisible = true;

    public DeleteIndexUI setDeleteMenuVisible(boolean visible) {
        this.deleteMenuVisible = visible;
        return this;
    }

    private TextView deleteView = null;

    public void setup(@NonNull ViewGroup parent, Context context) {
        deleteView = new TextView(context);
        FrameLayout.LayoutParams textParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        int margin = overlayStatusBar ? Utils.getStatusBarHeight(context) + 5 : 5;
        textParams.setMargins(0, margin, 20, 0);
        textParams.gravity = Gravity.TOP | Gravity.RIGHT;
        deleteView.setLayoutParams(textParams);
        deleteView.setIncludeFontPadding(false);
        deleteView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        deleteView.setTextColor(Color.WHITE);
        deleteView.setText(context.getString(R.string.delete));
        deleteView.setOnClickListener(onClickListener);
        parent.addView(deleteView);
        show();
    }

    public interface DeleteClickListener {
        void clickDeletePhoto();
    }

    private DeleteClickListener listener = null;

    public void setDeleteListener(DeleteClickListener listener) {
        this.listener = listener;
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.clickDeletePhoto();
            }
        }
    };

    /**
     * 显示索引
     */
    public void show() {
        if (deleteView != null) {
            if(deleteMenuVisible) {
                deleteView.setVisibility(View.VISIBLE);
            }else {
                deleteView.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 隐藏索引
     */
    public void hide() {
        if (deleteView != null) {
            deleteView.setVisibility(View.GONE);
        }
    }

}

