package com.example.examplenavigationmmm;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedInfoVM extends ViewModel {
        private final MutableLiveData<MyData> data = new MutableLiveData<MyData>();

        public void setdata(MyData newdata) {
            data.setValue(newdata);
        }

        public LiveData<MyData> getData() {
            return data;
        }
}

