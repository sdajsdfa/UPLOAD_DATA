package com.yhgs.api.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yhgs.api.model.Authusers;
import com.yhgs.api.model.SssDoc;
import com.yhgs.api.model.Tab130300;
import com.yhgs.api.service.ITab130300Service;
import com.yhgs.api.util.BitConverter;
import com.yhgs.api.util.R;
import com.yhgs.api.util.ZarUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author MybatisPlusAutoBuilder
 * @since 2023-11-22
 */
@RestController
@RequestMapping("/api")
public class Tab130300Controller {

    @Resource
    RedisTemplate redisTemplate;

    @Resource
    private ITab130300Service iTab130300Service;

    @Value("${spring.profile}")
    private String fileAddress;

    /**
     *  新增高应变和低应变试验数据
     * @param
     * @return
     */
    @PostMapping(value = "/DcData")
    public R dcData(@RequestBody Tab130300 dcBasicInfo, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        QueryWrapper<Tab130300> query = new QueryWrapper<>();
        query.eq("MachineId",dcBasicInfo.getMachineId());
        query.eq("SerialNo",dcBasicInfo.getSerialNo());
        query.eq("PileNo",dcBasicInfo.getPileNo());
        query.eq("TestTime",dcBasicInfo.getTestTime());
        List<Tab130300> list =iTab130300Service.list(query);
        if(list.size()>0){
            for (Tab130300 tab130300:list){
                File dataUrl = new File(tab130300.getDataUrl());
                dataUrl.delete();
                QueryWrapper<Tab130300> queryTab = new QueryWrapper<>();
                queryTab.eq("BaseInfoId",tab130300.getBaseInfoId());
                iTab130300Service.remove(queryTab);
            }
        }
        Authusers authusers = (Authusers) redisTemplate.opsForValue().get(request.getHeader("Authorization"));
        if(authusers==null){
            return R.error(-1,"Ticket失效");
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String currentDate = dateFormat.format(new Date());
        String sourceZip = fileAddress+"/root/dc/"+ currentDate +"/";
        String filePath = null;
        try {
            try {
                filePath = sourceZip + UUID.randomUUID()+ ".zip";
                File sourceZipFile = new File(filePath);
                if (!sourceZipFile.exists()) {   //文件不存在则创建文件，先创建目录
                    File dir = new File(sourceZipFile.getParent());
                    dir.mkdirs();
                    sourceZipFile.createNewFile();
                }
                FileOutputStream outputStream = new FileOutputStream(filePath);
                outputStream.write(dcBasicInfo.getZipFileData());
                outputStream.close();
                outputStream.flush();
            } catch (Exception e) {
                e.getMessage();
            }
        } catch (Exception e) {
            e.getMessage();
        }
        dcBasicInfo.setDataUrl(filePath);
        dcBasicInfo.setIsValid(1L);
        dcBasicInfo.setComId(authusers.getDeptnamecode());
        dcBasicInfo.setDwmc(authusers.getDeptname());
        dcBasicInfo.setDwbm(authusers.getDeptnamecode());
        iTab130300Service.saveTab130300(dcBasicInfo);
        map.put("BaseInfoId",dcBasicInfo.getBaseInfoId());
        return R.ok(map);
    }

    /**
     *   高低变下载
     */
    @GetMapping(value = "/DcData/SSData")
    public void SSData(String dataUrl, HttpServletResponse response) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String currentDate = dateFormat.format(new Date());
        String sourceZip = "D:\\json\\dc\\"+ currentDate +"\\";
        String filePath= ZarUtil.unzip(dataUrl,sourceZip);
        File file = new File(filePath);
        if (file.exists()) {
            String jsonStr = readerMethod(file);
            SssDoc sssDoc = JSONObject.parseObject(jsonStr,SssDoc.class);
            System.out.println(sssDoc);
            byte[] dcBasic = makeSssFile(sssDoc);
            response.reset();
            response.setCharacterEncoding("UTF-8");
            response.addHeader("Content-Disposition", "attachment;filename=" + sssDoc.getPileNo()+".sss");
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream;charset=UTF-8");
            toClient.write(dcBasic);
            toClient.flush();
            toClient.close();
        }
    }

    public static byte[] makeSssFile(SssDoc sssDoc) {
        if (sssDoc == null) throw new IllegalArgumentException("传入的SssDoc对象为空");
        int num = 720;
        for (int i = 0; i < sssDoc.getChannels().length; i++)
        {
            num += sssDoc.getChannels()[i].getSampleLength() * 2 + 64;
        }
        byte[] array = new byte[num];
        byte[] array2 = new byte[0];
        array2 = StringToBytes("RS-V2.00(W1616)");
        System.arraycopy(array2, 0, array, 0, array2.length);
        array[16] = (byte)(sssDoc.getIsHighStrainTest()>0 ? 2 : 0);
        System.arraycopy(array2, 0, array, 0, array2.length);
        array2 = StringToBytes(sssDoc.getSerialNo());
        System.arraycopy(array2, 0, array, 52, array2.length);
        array2 = StringToBytes(sssDoc.getPileNo());
        System.arraycopy(array2, 0, array, 148, array2.length);
        array2 = StringToBytes(sssDoc.getShangGangZheng());
        System.arraycopy(array2, 0, array, 241, array2.length);
        array2 = StringToBytes(sssDoc.getMachineId());
        System.arraycopy(array2, 0, array, 209, array2.length);
        System.arraycopy(BitConverter.getBytes(sssDoc.getPileLength()), 0, array, 337, 4);
        System.arraycopy(BitConverter.getBytes(sssDoc.getPileVelocity()), 0, array, 341, 4);
        int result = 0;
        try {
            Integer.valueOf(sssDoc.getConcreteStrength());
            System.arraycopy(BitConverter.getBytes(result), 0, array, 164, 2);
        } catch (NumberFormatException e) {
            result = 0;
        }
        array[345] = (byte)(sssDoc.getChannels().length & 0xFF);
        if(sssDoc.getIsHighStrainTest()==1){
            System.arraycopy(BitConverter.getBytes(sssDoc.getHammerWeight()),0, array, 347, 4);
            System.arraycopy(BitConverter.getBytes(sssDoc.getSectionArea()), 0, array, 351, 4);
            System.arraycopy(BitConverter.getBytes(sssDoc.getDensity()), 0, array, 355, 4);
        }
        for (int j = 0; j < sssDoc.getChannels().length; j++)
        {
            if (sssDoc.getChannels()[j].getSignalType() == 2)
            {
                array[359] = 1;
                break;
            }
        }
        String[] array3 = sssDoc.getPileDiameter().split("Φ", '×');
        int result2 = 0;
        int result3 = 0;
        try {
            Integer.valueOf(array3[0]);
        } catch (NumberFormatException e) {
            result2 = 0;
        }
        if (array3.length >= 2)
        {
            try {
                Integer.valueOf(array3[1]);
            } catch (NumberFormatException e) {
                result3 = 0;
            }
        }
        if (result2 > 0 && result3 > 0)
        {
            array[166] = 1;
            System.arraycopy(BitConverter.getBytes(result2), 0, array, 168, 4);
            System.arraycopy(BitConverter.getBytes(result3), 0, array, 172, 4);
        }
        else
        {
            result2 = ((result2 > result3) ? result2 : result3);
            if (result2 > 0)
            {
                System.arraycopy(BitConverter.getBytes(result2), 0, array, 168, 4);
            }
        }
        array[176] = (byte)(sssDoc.getTestTime().getYear() & 0xFF);
        array[177] = (byte)(sssDoc.getTestTime().getYear() >> 8);
        array[178] = (byte)(sssDoc.getTestTime().getMonth() & 0xFF);
        array[180] = (byte)(sssDoc.getTestTime().getDay() & 255);
        array[182] = (byte)(sssDoc.getTestTime().getDay() & 0xFF);
        array[184] = (byte)(sssDoc.getTestTime().getHours() & 0xFF);
        array[186] = (byte)(sssDoc.getTestTime().getMinutes() & 0xFF);
        array[188] = (byte)(sssDoc.getTestTime().getSeconds() & 0xFF);
        if (sssDoc.getGpsIsValid()==1)
        {
            array[192] = 1;
            System.arraycopy(BitConverter.getBytes(sssDoc.getGpsLongitude()), 0, array, 193, 8);
            System.arraycopy(BitConverter.getBytes(sssDoc.getGpsLatitude()), 0, array, 201, 8);
        }
        if(sssDoc.getIsHighStrainTest()==1){
            System.arraycopy(BitConverter.getBytes(sssDoc.getPileLength()), 0, array, 401, 4);
            System.arraycopy(BitConverter.getBytes(sssDoc.getPileVelocity()), 0, array, 405, 4);
            System.arraycopy(BitConverter.getBytes(sssDoc.getLengthUnderSensor()), 0, array, 409, 4);
            System.arraycopy(BitConverter.getBytes(sssDoc.getHammerWeight() / 1000f), 0, array, 413, 4);
            System.arraycopy(BitConverter.getBytes(sssDoc.getHammerDropHeight()), 0, array, 417, 4);
            System.arraycopy(BitConverter.getBytes(sssDoc.getSectionArea()), 0, array, 421, 4);
            System.arraycopy(BitConverter.getBytes(sssDoc.getBottomArea()), 0, array, 425, 4);
            System.arraycopy(BitConverter.getBytes(sssDoc.getDensity()), 0, array, 429, 4);
            System.arraycopy(BitConverter.getBytes(sssDoc.getSectionCircum()), 0, array, 433, 4);
            System.arraycopy(BitConverter.getBytes(sssDoc.getJc()), 0, array, 437, 4);
            System.arraycopy(BitConverter.getBytes(sssDoc.getDepthIn()), 0, array, 441, 4);
            System.arraycopy(BitConverter.getBytes(sssDoc.getVs()), 0, array, 445, 4);
        }
        int num2 = 720;
        for (int k = 0; k < sssDoc.getChannels().length; k++)
        {
            System.arraycopy(BitConverter.getBytes(sssDoc.getChannels()[k].getSensorSensitive()), 0, array, num2, 4);
            System.arraycopy(BitConverter.getBytes(sssDoc.getChannels()[k].getSampleInterval()), 0, array, num2 + 4, 4);
            array[num2 + 8] = (byte)(sssDoc.getChannels()[k].getSampleLength() & 0xFF);
            array[num2 + 9] = (byte)(sssDoc.getChannels()[k].getSampleLength() >> 8);
            System.arraycopy(BitConverter.getBytes((float)sssDoc.getChannels()[k].getSampleGain()), 0, array, num2 + 10, 4);
            array[num2 + 16] = sssDoc.getChannels()[k].getSignalType();
            array[num2 + 18] = (byte)(sssDoc.getChannels()[k].getFilterFrequency() & 0xFF);
            array[num2 + 19] = (byte)(sssDoc.getChannels()[k].getFilterFrequency() >> 8);
            array[num2 + 20] = (byte)(sssDoc.getChannels()[k].getSampleTime().getYear() & 0xFF);
            array[num2 + 21] = (byte)(sssDoc.getChannels()[k].getSampleTime().getYear() >> 8);
            array[num2 + 22] = (byte)(sssDoc.getChannels()[k].getSampleTime().getMonth() & 0xFF);
            array[num2 + 24] = (byte)(sssDoc.getChannels()[k].getSampleTime().getDay() & 255);
            array[num2 + 26] = (byte)(sssDoc.getChannels()[k].getSampleTime().getDay() & 0xFF);
            array[num2 + 28] = (byte)(sssDoc.getChannels()[k].getSampleTime().getHours() & 0xFF);
            array[num2 + 30] = (byte)(sssDoc.getChannels()[k].getSampleTime().getMinutes() & 0xFF);
            array[num2 + 32] = (byte)(sssDoc.getChannels()[k].getSampleTime().getSeconds() & 0xFF);
            num2 += 64;
            short[] channelData =sssDoc.getChannels()[k].ChannelData;
            for (short num3:channelData) {
                array[num2] = (byte)(num3 & 0xFF);
                num2++;
                array[num2] = (byte)(num3 >> 8);
                num2++;
            }
        }
        return array;
    }

    private static byte[] StringToBytes(String str){
        if (str == null || str.length() == 0)
        {
            return new byte[0];
        }
        try
        {
            return str.getBytes("gb2312");
        }
        catch(Exception e)
        {
            return new byte[0];
        }
    }

    private static String readerMethod(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        Reader reader = new InputStreamReader(new FileInputStream(file), "Utf-8");
        int ch = 0;
        StringBuffer sb = new StringBuffer();
        while ((ch = reader.read()) != -1) {
            sb.append((char) ch);
        }
        fileReader.close();
        reader.close();
        return sb.toString();
    }




}
