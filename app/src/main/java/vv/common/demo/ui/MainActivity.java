package vv.common.demo.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import vv.common.demo.R;
import vv.common.demo.ui.fragment.LeftFragment;
import vv.common.demo.ui.fragment.RightFragment;
import vv.common.demo.view.TabsView;

public class MainActivity extends AppCompatActivity implements TabsView.OnTabChangeListener {

    TabsView mTabsView;

    public final static int TAB_LEFT_INDEX = 0;
    public final static int TAB_RIGHT_INDEX = 1;

    private LeftFragment leftFragment;

    private RightFragment rightFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabsView = (TabsView) findViewById(R.id.home_tabview);
        mTabsView.setOnTabChangeListener(this);
        onTabSelect(TAB_LEFT_INDEX);
    }

    @Override
    public void onTabSelect(int index) {
        setSelect(index);
    }

    /**
     * 设置选择显示不同fragment
     *
     * @param index
     */
    private void setSelect(int index) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        switch (index) {
            case TAB_LEFT_INDEX:
                if (leftFragment == null) {
                    leftFragment = LeftFragment.newInstance();
                    transaction.add(R.id.fragment_content, leftFragment);
                } else {
                    transaction.show(leftFragment);
                }
                break;

            case TAB_RIGHT_INDEX:
                if (rightFragment == null) {
                    rightFragment = RightFragment.newInstance();
                    transaction.add(R.id.fragment_content, rightFragment);
                } else {
                    transaction.show(rightFragment);
                }
                break;

        }
        transaction.commitAllowingStateLoss();
    }

    /**
     * 隐藏所有的fragment
     *
     * @param transaction
     */
    private void hideFragment(FragmentTransaction transaction) {
        if (leftFragment != null) {
            transaction.hide(leftFragment);
        }
        if (rightFragment != null) {
            transaction.hide(rightFragment);
        }
    }


    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (leftFragment == null && fragment instanceof LeftFragment) {
            leftFragment = (LeftFragment) fragment;
        } else if (rightFragment == null && fragment instanceof RightFragment) {
            rightFragment = (RightFragment) fragment;
        }
    }

}
