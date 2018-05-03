package me.frank.test.data;

import com.github.crab2died.ExcelUtils;
import com.google.common.collect.Lists;
import com.thinkgem.jeesite.common.utils.DBUtil;
import com.thinkgem.jeesite.common.utils.JSONUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImportData {
    private static final String type="车轮制动";
    public static void main(String[] args) {

        List<Map<String, Object>> maps = DBUtil.queryDatas();
        List<List<String>> resultList= new ArrayList<>();
        List<String> header=new ArrayList<>(21);
        header.add("id");


        for (int i = 0; i < maps.size(); i++) {
            String data1 = (String)maps.get(i).get("data1");
            data1=data1.substring(14,data1.length()-1);
            JSONObject retval = JSONUtils.toJSONObject(data1);
            JSONObject result = JSONUtils.toJSONObject(retval.getString("result"));
            JSONArray paramtypeitems = JSONUtils.toJSONArray(result.get("paramtypeitems"));
            for (int j = 0; j < paramtypeitems.size(); j++) {
                JSONObject params = JSONUtils.toJSONObject(paramtypeitems.get(j));
                String name1 = params.getString("name");
                if(!type.equals(name1)) continue;
                System.out.println(i+" "+name1);
                JSONArray paramitems = JSONUtils.toJSONArray(params.get("paramitems"));
                List<String> strList= Lists.newArrayList();
                strList.add(String.valueOf(maps.get(i).get("id")));
                for (int k = 0; k < paramitems.size(); k++) {
                    JSONObject paramItem = JSONUtils.toJSONObject(paramitems.get(k));
                    String name = paramItem.getString("name");
                    if(header.size()<paramitems.size()+1)
                        header.add(name);
                    String value=JSONUtils.toJSONObject(JSONUtils.toJSONArray(paramItem.get("valueitems")).get(0)).getString("value");
                    if(null==value||"".equals(value))value="-";
                    strList.add(value);

                    //System.out.println(name+":"+value);
                }


                resultList.add(strList);


            }


        }

        try {
            ExcelUtils.getInstance().exportObjects2Excel(resultList,header,"D:\\"+type+".xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
