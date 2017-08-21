package com.example.yehia.todo_list;

import android.provider.BaseColumns;

/**
 * Created by yehia on 20/08/17.
 */

public class Contract {
    public static  final class tasks implements BaseColumns{
        public static final  String table = "task";
        public static final  String colume = "daily task";
        public static final  String row = "row";
    }
}
