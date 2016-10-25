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
import vv.common.demo.ui.base.BaseFragment;

/**
 * Created by vivien on 16/10/25.
 */

public class LeftFragment extends BaseFragment {

    private ListView listView;

    public LeftFragment() {
    }


    public static LeftFragment newInstance() {
        LeftFragment fragment = new LeftFragment();
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
        return R.layout.fragment_left;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        listView = (ListView) getView().findViewById(R.id.left_lv);

        listView.setAdapter(new CommonAdapter<Book>(getContext(), getBook(), R.layout.item_left) {
            @Override
            protected void convertView(View item, Book book) {
                ImageView temp_iv = CommonViewHolder.get(item, R.id.left_iv);
                TextView temp_tv = CommonViewHolder.get(item, R.id.left_tv);
                temp_iv.setBackgroundResource(R.mipmap.ic_launcher);
                temp_tv.setText(book.title);
            }
        });
    }

    private List<Book> getBook() {
        List<Book> datas = new ArrayList<>();
        datas.add(new Book("", "花千骨"));
        datas.add(new Book("", "青云志"));
        datas.add(new Book("", "微微一笑很倾城"));
        datas.add(new Book("", "盗墓笔记"));
        datas.add(new Book("", "老九门"));
        datas.add(new Book("", "麻雀"));
        datas.add(new Book("", "中国式关系"));
        datas.add(new Book("", "小别离"));
        datas.add(new Book("", "炮神"));
        datas.add(new Book("", "亲爱的公主病"));
        datas.add(new Book("", "幻城"));
        datas.add(new Book("", "大嫁风尚"));
        datas.add(new Book("", "秦时明月"));
        datas.add(new Book("", "灰姑娘"));
        return datas;
    }
}
