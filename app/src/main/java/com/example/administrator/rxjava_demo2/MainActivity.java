package com.example.administrator.rxjava_demo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class MainActivity extends AppCompatActivity {
    private static final String flag="Rxjava:";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Observable.just() 快速创建
//        Integer array []={0,1,2,3,4,5};Observable.fromArray()
//        List<Integer> list=new ArrayList<>();// Observable.fromIterable(list)
//        list.add(0);
//        list.add(1);
//        list.add(2);
//        list.add(3);
                                       //起始    N个事件  延迟n秒
//             Observable.intervalRange(0,10,5,2,TimeUnit.SECONDS)
               //不同于interval ，可控制发送的事件个数

        Observable.range(3,11)
                     //range则于intervalRange作用相似，区别在于无延迟发送事件
                     //rangeLong()则支持Long数据类型
        .subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(flag, "开始采用subscribe连接");
            }



            @Override
            public void onNext(Integer v) {
                Log.d(flag, "接收事件"+v);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(flag, "调用error事件");
            }

            @Override
            public void onComplete() {
                Log.d(flag, "onComplete调用成功");
            }
        });


    }


    }

