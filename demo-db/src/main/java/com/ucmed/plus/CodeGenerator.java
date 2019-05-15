package com.ucmed.plus;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGenerator{

    public static void main(String[] args) {

        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("F://ja//demo//allDemoMvc//demo-db//src//main//java");
        gc.setFileOverride(false);
        gc.setEnableCache(false);
        gc.setActiveRecord(false);
        gc.setAuthor("zhch");
        mpg.setGlobalConfig(gc);

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert());
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/sys?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
        mpg.setDataSource(dsc);

        //策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude(new String[] { "sys_user" }); // 需要生成的表
//        strategy.setTablePrefix("library_");// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        mpg.setStrategy(strategy);

        //包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.ucmed.plus");
        //pc.setModuleName("test");
        mpg.setPackageInfo(pc);

        //目录配置
        TemplateConfig tc = new TemplateConfig();
        tc.setController(null);
        mpg.setTemplate(tc);

        //执行生成
        mpg.execute();
    }
}