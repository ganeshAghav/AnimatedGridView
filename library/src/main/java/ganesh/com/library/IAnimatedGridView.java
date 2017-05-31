package ganesh.com.library;

import android.view.View;
import android.widget.Adapter;
import android.widget.BaseAdapter;

import java.util.LinkedList;
import java.util.Set;

import ganesh.com.library.adapter.AnimatedAdapter;
import ganesh.com.library.listener.AnimationListener;

/**
 * Created by mikepenz on 31.05.14.
 */
public interface IAnimatedGridView {
    /***
     * ANIMATION METHODS ;D
     */

    /**
     * @param cells
     * @param duration
     */
    public void animateAddCells(LinkedList<?> cells, int duration);

    /**
     * @param rows
     * @param duration
     */
    public void animateDeleteRow(Set<Integer> rows, int duration);

    /**
     * @param cells
     * @param duration
     */
    public void animateDeleteCells(final Set<Integer> cells, int duration);


    /***
     * ADAPTER HELPER :D
     */


    /**
     * @return
     */
    public BaseAdapter getBaseAdapter();

    /**
     * @return
     */
    public AnimatedAdapter getAnimatedAdapter();


    /**
     * AWESOME HELPER METHODS ;D
     */

    public void setAnimationListener(AnimationListener animationListener);

    /**
     *
     */
    public void onAnimationFinish();

    /**
     * @param position
     */
    public void smoothScrollToCenterPosition(int position);

    /**
     * @param position
     * @return
     */
    public View getViewByPosition(int position);

    /**
     * @param position
     * @return
     */
    public boolean isVisible(int position);

    /**
     * @return
     */
    public int getCenterPosition();


    /**
     * Some Default Methods to be able to use the interface in the helper class
     */
    public Adapter getAdapter();

    public int getNumColumns();
}
