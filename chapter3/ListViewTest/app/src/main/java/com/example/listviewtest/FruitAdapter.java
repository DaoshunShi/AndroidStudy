package com.example.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 99502 on 2017/7/28.
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;

    public  FruitAdapter(Context context, int textVIewResourceId, List<Fruit> objects) {
        super(context, textVIewResourceId, objects);
        resourceId = textVIewResourceId;
    }

    //3.5.2
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        Fruit fruit = getItem(position);    //获取当前项的Fruit实例
//        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
//        ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
//        TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
//        fruitImage.setImageResource(fruit.getImageId());
//        fruitName.setText(fruit.getName());
//        return view;
//    }

    //3.5.3
//    @Override
//    public View getView (int position, View convertView, ViewGroup parent) {
//        Fruit fruit = getItem(position);
//        View view;
//        if (convertView == null) {
//            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
//        } else {
//            view = convertView;
//        }
//        ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
//        TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
//        fruitImage.setImageResource(fruit.getImageId());
//        fruitName.setText(fruit.getName());
//        return view;
//    }

    //3.5.3(2)
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);    //将ViewHolder存储在View中
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();    //重新获取ViewHolder
        }
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;
    }
    class ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
    }

}
