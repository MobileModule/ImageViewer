package indi.liyi.viewer.otherui;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import indi.liyi.viewer.R;
import indi.liyi.viewer.Utils;

public class DownloadIndexUI {
    private boolean overlayStatusBar;

    public DownloadIndexUI(boolean overlayStatusBar) {
        this.overlayStatusBar = overlayStatusBar;
    }

    private boolean downloadMenuVisible = true;

    public DownloadIndexUI setDownloadMenuVisible(boolean visible) {
        this.downloadMenuVisible = visible;
        return this;
    }

    private ImageView downloadView = null;

    public void setup(@NonNull ViewGroup parent, Context context) {
        downloadView = new ImageView(context);
        FrameLayout.LayoutParams textParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        int margin = overlayStatusBar ? Utils.getStatusBarHeight(context) + 5 : 5;
        textParams.setMargins(0, margin, 40, 40);
        textParams.gravity = Gravity.BOTTOM | Gravity.RIGHT;
        downloadView.setLayoutParams(textParams);
        downloadView.setImageResource(R.drawable.icon_image_download);
        downloadView.setOnClickListener(onClickListener);
        parent.addView(downloadView);
        show();
    }

    public interface DownloadClickListener {
        void clickDownloadPhoto();
    }

    private DownloadClickListener listener = null;

    public void setDownloadListener(DownloadClickListener listener) {
        this.listener = listener;
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.clickDownloadPhoto();
            }
        }
    };

    /**
     * 显示索引
     */
    public void show() {
        if (downloadView != null) {
            if(downloadMenuVisible) {
                downloadView.setVisibility(View.VISIBLE);
            }else {
                downloadView.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 隐藏索引
     */
    public void hide() {
        if (downloadView != null) {
            downloadView.setVisibility(View.GONE);
        }
    }

}

