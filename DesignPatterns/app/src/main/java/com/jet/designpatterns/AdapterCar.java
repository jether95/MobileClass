package com.jet.designpatterns;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jet.designpatterns.Models.Car;

import java.util.ArrayList;

public class AdapterCar extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<Car> cars;

    public AdapterCar(Activity activity, ArrayList<Car> cars) {
        this.activity = activity;
        this.cars = cars;
    }

    public void addCar (Car car){
        cars.add(car);
    }

    public void addCar(ArrayList<Car> carsElement){
        cars.addAll(carsElement);
    }

    @Override
    public int getCount() {
        return cars.size();
    }

    @Override
    public Object getItem(int position) {
        return cars.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(convertView == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.car_item, null);
        }
        Car carElement = cars.get(position);
        TextView nameCar = v.findViewById(R.id.carName);
        nameCar.setText(carElement.getName());

        TextView cylinderCapacity = v.findViewById(R.id.carCylinderCapacity);
        cylinderCapacity.setText(carElement.getCylinderCapacity());

        TextView carModel = v.findViewById(R.id.carModel);
        carModel.setText(carElement.getModel());

        TextView carValue = v.findViewById(R.id.carValue);
        carValue.setText(carElement.getValue());

        return v;
    }
}
