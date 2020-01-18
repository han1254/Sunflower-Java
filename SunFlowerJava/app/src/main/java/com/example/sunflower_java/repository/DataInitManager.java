package com.example.sunflower_java.repository;

import android.util.Config;

import com.example.sunflower_java.App;
import com.example.sunflower_java.config.DataBaseConfig;
import com.example.sunflower_java.data.AppDataBase;
import com.example.sunflower_java.data.Plant;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import androidx.room.Database;

/**
 * Time:2020/1/17 8:21
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
public class DataInitManager {
    private static Type type;
    static {
        type = new TypeToken<List<Plant>>(){}.getType();
    }
    public static void initPlantData() {
       AppDataBase
               .databaseWriteExecutor.execute( () -> {

           try {
               List<Plant> plantList = new ArrayList<>();
               Gson gson = new Gson();
               InputStream inputStream = App.getAppContext().getAssets().open(DataBaseConfig.PLANT_DATA_FILE_NAME);
               Reader reader = new InputStreamReader(inputStream);
               plantList = gson.fromJson(reader, type);

               List<Plant> test = plantList;

//               JsonObject jsonObject = new JsonParser().parse(App.getAppContext().getAssets().open(DataBaseConfig.PLANT_DATA_FILE_NAME).toString()).getAsJsonObject();
//               JsonArray jsonArray = jsonObject.getAsJsonArray();
//               for (JsonElement jsonElement :
//                       jsonArray ){
//                   Plant plant = (Plant) gson.fromJson(jsonElement, new TypeToken<List<Plant>>(){}.getRawType());
//                   plantList.add(plant);
//               }
//               List<Plant> finalList = new ArrayList<>();
//               Iterator iterator = plantList.iterator();
//               while(iterator.hasNext()) {
//                   Plant item = (Plant) iterator.next();
//                   finalList.add(item);
//               }
               AppDataBase.getInstance(App.getAppContext()).getPlantDao().insertAll(plantList);
           } catch (IOException e) {
               e.printStackTrace();
           }

       });
    }

}
