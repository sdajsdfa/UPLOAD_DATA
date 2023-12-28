package com.yhgs.api.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yhgs.api.model.Authusers;
import com.yhgs.api.model.SbeDoc;
import com.yhgs.api.model.Tab130305;
import com.yhgs.api.service.ITab130305Service;
import com.yhgs.api.util.R;
import com.yhgs.api.util.ZarUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.ZipOutputStream;

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
public class Tab130305Controller {

    @Resource
    private ITab130305Service iTab130305Service;

    @Resource
    private RedisTemplate redisTemplate;

    @Value("${spring.profile}")
    private String fileAddress;


    /**
     *  新增声测试验基础数据
     * @param
     * @return
     */
    @PostMapping(value = "/ScData")
    public R scData(@RequestBody Tab130305 sbBasicInfo, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        QueryWrapper<Tab130305> query = new QueryWrapper<>();
        query.eq("MachineId",sbBasicInfo.getMachineId());
        query.eq("SerialNo",sbBasicInfo.getSerialNo());
        query.eq("PileNo",sbBasicInfo.getPileNo());
        query.eq("TestTime",sbBasicInfo.getTestTime());
        List<Tab130305> list =iTab130305Service.list(query);
        if(list.size()>0){
            for (Tab130305 tab130305:list){
                File dataUrl = new File(tab130305.getDataUrl());
                dataUrl.delete();
                QueryWrapper<Tab130305> queryTab = new QueryWrapper<>();
                queryTab.eq("BaseInfoId",tab130305.getBaseInfoId());
                iTab130305Service.remove(queryTab);
            }
        }
        Authusers authusers = (Authusers) redisTemplate.opsForValue().get(request.getHeader("Authorization"));
        if(authusers==null){
            return R.error(-1,"Ticket失效");
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String currentDate = dateFormat.format(new Date());
        String sourceZip = fileAddress+"/root/sb/"+currentDate+"/";
        String filePath = null;
        try {
            filePath = sourceZip + UUID.randomUUID()+ ".zip";
            File sourceZipFile = new File(filePath);
            if (!sourceZipFile.exists()) {   //文件不存在则创建文件，先创建目录
                File dir = new File(sourceZipFile.getParent());
                dir.mkdirs();
                sourceZipFile.createNewFile();
            }
            FileOutputStream outputStream = new FileOutputStream(filePath);
            outputStream.write(sbBasicInfo.getZipFileData());
            outputStream.close();
            outputStream.flush();
        } catch (Exception e) {
            e.getMessage();
        }
        sbBasicInfo.setDataUrl(filePath);
        sbBasicInfo.setIsValid(1L);
        sbBasicInfo.setComId(authusers.getDeptnamecode());
        sbBasicInfo.setDwmc(authusers.getDeptname());
        sbBasicInfo.setDwbm(authusers.getDeptnamecode());
        iTab130305Service.saveTab130305(sbBasicInfo);
        map.put("BaseInfoId",sbBasicInfo.getBaseInfoId());
        return R.ok(map);
    }

    /**
     *   声测数据下载
     */
    @GetMapping(value = "/ScData/SSData")
    public void SSData(String dataUrl, HttpServletResponse response) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String currentDate = dateFormat.format(new Date());
        String sourceZip = fileAddress+"/json/sc/"+ currentDate +"/";
        String filePath= ZarUtil.unzip(dataUrl,sourceZip);
        File files = new File(filePath);
        if (files.exists()) {
            String jsonStr = readerMethod(files);
            Gson gson = new Gson();
            SbeDoc sbeDoc = new SbeDoc(gson.fromJson(jsonStr,SbeDoc.class));
            byte[] dcBasic = sbeDoc.ToEditionSixBytes();
            // 清空response
            response.reset();
            response.addHeader("Content-Disposition", "attachment;filename=" + sbeDoc.getPileNo()+".sbe");
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(dcBasic);
            toClient.flush();
            toClient.close();
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
