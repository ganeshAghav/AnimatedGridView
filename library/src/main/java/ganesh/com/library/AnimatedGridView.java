package ganesh.com.library;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.WrapperListAdapter;

import java.util.LinkedList;
import java.util.Set;

import ganesh.com.library.listener.AnimationListener;
import ganesh.com.library.adapter.AnimatedAdapter;
import ganesh.com.library.helper.AnimationHelper;
import ganesh.com.library.helper.Helper;

/**
 * Created by mikepenz on 16.05.14.
 */
public class AnimatedGridView extends HeaderGridView implements IAnimatedGridView {
    public AnimatedGridView(Context context) {
        super(context);
        this.setLayoutAnimation(AnimationHelper.getLayoutAnimation());
    }

    public AnimatedGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setLayoutAnimation(AnimationHelper.getLayoutAnimation());
    }

    public AnimatedGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.setLayoutAnimation(AnimationHelper.getLayoutAnimation());
    }


    /**
     * ANIMATION LOGIC :D
     */
    public void animateAddCells(LinkedList<?> cells, int duration) {
        Helper.animateAddCells(this, cells, duration);
    }

    public void animateDeleteRow(Set<Integer> rows, int duration) {
        Helper.animateDeleteRow(this, rows, duration);
    }

    public void animateDeleteCells(final Set<Integer> cells, int duration) {
        Helper.animateDeleteCells(this, cells, duration);
    }

    public BaseAdapter getBaseAdapter() {
        Adapter adapter = getAdapter();
        if (adapter != null) {
            if (adapter instanceof WrapperListAdapter) {
                adapter = ((WrapperListAdapter) adapter).getWrappedAdapter();
            }

            if (adapter instanceof BaseAdapter) {
                return (BaseAdapter) adapter;
            }
        }
        return null;
    }

    public AnimatedAdapter getAnimatedAdapter() {
        Adapter adapter = getBaseAdapter();
        if (adapter != null && adapter instanceof AnimatedAdapter) {
            return (AnimatedAdapter) adapter;
        }
        return null;
    }

    /**
     * LISTENER!!
     */

    private AnimationListener animationListener;

    public void setAnimationListener(AnimationListener animationListener) {
        this.animationListener = animationListener;
    }

    public void onAnimationFinish() {
        if (animationListener != null) {
            animationListener.onAnimationFinish();
        }
    }


    /**
     * A SMALL EXTRA FOR THOSE WHO LOVE OPEN SOURCE ;D
     */

    /**
     * smoothScroll a specific item to the center of the list :D
     *
     * @param position
     */

    public void smoothScrollToCenterPosition(int position) {
        Helper.smoothScrollToCenterPosition(this, position);
    }

    /**
     * HELPER METHODS!!
     */

    public View getViewByPosition(int position) {
        return Helper.getViewByPosition(this, position);
    }

    /**
     * Helper to calculate if a specific position is visible
     *
     * @param position
     * @return
     */

    public boolean isVisible(int position) {
        return Helper.isVisible(this, position);
    }


    public int getCenterPosition() {
        return Helper.getCenterPosition(this);
    }
}
