package com.yhgs.api.config;
 
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
 
 
import java.util.Scanner;
 
/*
* 自动生成代码实现
* */
public class GeneratorCodeConfig {
 
    /*输入控制方法*/
    public static String scanner(String tips){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append("请输入："+tips + ":");
        System.out.println(sb.toString());
        if(sc.hasNext()){
            String rs = sc.next();
            if(rs != null && !"".equals(rs)){
                return rs ;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tips);
    }
 
    public static void main(String args[]){
        //初始化代码生成器
        AutoGenerator mpg = new AutoGenerator();
        //获取全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        //设置输出目录
        gc.setOutputDir(projectPath + "/pg/src/main/java");
        gc.setAuthor("MybatisPlusAutoBuilder");
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);
 
        //配置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:postgresql://81.70.165.165:20110/rssj");
        dsc.setDriverName("org.postgresql.Driver");
        dsc.setPassword("Sj@2023");
        dsc.setUsername("global");
        mpg.setDataSource(dsc);
 
        //包配置，指定输出文件的目录
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.yhgs.api");
        pc.setEntity("model");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        mpg.setPackageInfo(pc);
 
        //模板配置
        TemplateConfig tc = new TemplateConfig();
        tc.setXml(null);
        mpg.setTemplate(tc);
 
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("com.baomidou.mybatisplus.extension.activerecord.Model");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setEntityLombokModel(true);
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
 
    }
}