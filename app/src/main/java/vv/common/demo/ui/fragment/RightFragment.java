package vv.common.demo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vv.common.demo.R;
import vv.common.demo.adapter.CommonAdapter;
import vv.common.demo.adapter.CommonViewHolder;
import vv.common.demo.entity.Book;
import vv.common.demo.entity.Student;
import vv.common.demo.ui.base.BaseFragment;

/**
 * Created by vivien on 16/10/25.
 */

public class RightFragment extends BaseFragment {

    private ListView listView;

    public RightFragment() {
    }


    public static RightFragment newInstance() {
        RightFragment fragment = new RightFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    protected int onGetFragmentView() {
        return R.layout.fragment_right;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        listView = (ListView) getView().findViewById(R.id.right_lv);

        listView.setAdapter(new CommonAdapter<Student>(getContext(), getStudent(), R.layout.item_right) {
            @Override
            protected void convertView(View item, Student student) {
                ImageView temp_iv = CommonViewHolder.get(item, R.id.right_iv);
                TextView temp_tv = CommonViewHolder.get(item, R.id.right_tv);
                TextView temp_tv2 = CommonViewHolder.get(item, R.id.right_tv2);
                temp_iv.setBackgroundResource(R.mipmap.ic_launcher);
                temp_tv.setText(student.name);
                temp_tv2.setText(student.sex);
            }
        });
    }

    private List<Student> getStudent() {
        List<Student> datas = new ArrayList<>();
        datas.add(new Student("", "chris", "男"));
        datas.add(new Student("", "boyce", "男"));
        datas.add(new Student("", "vv", "女"));
        datas.add(new Student("", "anna", "女"));
        datas.add(new Student("", "joe", "男"));
        datas.add(new Student("", "hone", "女"));
        datas.add(new Student("", "伟人", "男"));
        datas.add(new Student("", "爱德华", "男"));
        datas.add(new Student("", "梅梅", "女"));
        datas.add(new Student("", "紫薇", "女"));
        datas.add(new Student("", "康康", "男"));
        datas.add(new Student("", "吧啦", "女"));
        datas.add(new Student("", "单汪", "男"));
        datas.add(new Student("", "张三", "男"));
        datas.add(new Student("", "小丽", "女"));
        return datas;
    }
}
