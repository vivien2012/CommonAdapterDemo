package vv.common.demo.ui.base;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

/**
 * fragment的基类
 * Created by vv on 16/10/25.
 */
public class BaseFragment extends Fragment {

    private Handler mHandler = new Handler();

    public Context mContext;

    private View mContentView;

    private LinearLayout layout;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        int viewId = onGetFragmentView();
        if (viewId > 0) {
            mContentView = inflater.inflate(viewId, null, false);
            layout = new LinearLayout(mContext);
            mContentView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            layout.setOrientation(LinearLayout.VERTICAL);
            layout.addView(mContentView);

            return layout;
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Nullable
    @Override
    public View getView() {
        if (layout != null)
            return layout;
        return super.getView();
    }


    /**
     * 获取fragment的view布局  可以在子类重写
     *
     * @return
     */
    protected int onGetFragmentView() {
        return 0;
    }



    /**
     * 添加fragment
     *
     * @param containerId
     * @param fragment
     */
    protected void addFragment(int containerId, Fragment fragment) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(containerId, fragment);
        transaction.commit();
    }

    /**
     * 替换fragment
     *
     * @param containerId
     * @param fragment
     */
    protected void replaceFragment(int containerId, Fragment fragment) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(containerId, fragment);
        transaction.commitAllowingStateLoss();
    }

    public void post(Runnable task) {
        mHandler.post(task);
    }

    public void post(Runnable task, long delay) {
        mHandler.postDelayed(task, delay);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        if (fragments != null && fragments.size() > 0) {
            Fragment fragment = getChildFragmentManager().getFragments().get(0);
            if (fragment != null) {
                fragment.onActivityResult(requestCode, resultCode, data);
            }
        }
    }

}
