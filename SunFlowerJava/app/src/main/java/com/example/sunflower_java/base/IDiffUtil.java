package com.example.sunflower_java.base;

/**
 * Time:2020/1/18 16:14
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function: 用来判断是否两个bean是否一致
 */
public interface IDiffUtil<T> {

    boolean areItemSame(T t);

    boolean areContentSame(T t);
}
