package com.moggi.quizmini.test;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MybatisPlusAutomaticGenerator {
    public static void main(String[] args) {
        /**
         * 代码生成器对象
         */
        AutoGenerator autoGenerator = new AutoGenerator();
        /**
         * 全局配置对象
         */
        GlobalConfig globalConfig = new GlobalConfig();
        String property = System.getProperty("user.dir");// 获取当前项目的系统目录
        globalConfig.setOutputDir(property + "/src/main/java");
        globalConfig.setAuthor("wechiwin");
        globalConfig.setOpen(false);// 生成之后是否打开所在的系统目录
        globalConfig.setFileOverride(false);// 是否覆盖
        globalConfig.setServiceName("%sService");// 去掉Service的I前缀
        globalConfig.setIdType(IdType.ASSIGN_ID);
        globalConfig.setDateType(DateType.ONLY_DATE);// 日期类型，仅仅是时间
        globalConfig.setSwagger2(true);// 配置swagger文档
        autoGenerator.setGlobalConfig(globalConfig);
        /**
         * 设置数据源
         */
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:sqlite:quizmini.db");
        dataSourceConfig.setDriverName("org.sqlite.JDBC");
        dataSourceConfig.setDbType(DbType.SQLITE);
        autoGenerator.setDataSource(dataSourceConfig);
        /**
         * 包的配置
         */
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.moggi.quizmini");
        // packageConfig.setModuleName("MyPro");
        packageConfig.setEntity("entity");
        packageConfig.setMapper("mapper");
        packageConfig.setService("service");
        packageConfig.setController("controller");
        autoGenerator.setPackageInfo(packageConfig);
        /**
         * 配置策略
         */
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setInclude("folder", "card", "wrong_list");
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);// 包的名字，下划线转驼峰
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);// 列的名字，下划线转驼峰
        strategyConfig.setEntityLombokModel(true);// 自动lombok
        strategyConfig.setLogicDeleteFieldName("deleted");
        TableFill create_time = new TableFill("create_time", FieldFill.INSERT);// 自动填充配置插入
        TableFill modify_time = new TableFill("modify_time", FieldFill.INSERT_UPDATE);// 自动填充配置更新
        List<TableFill> tableFils = new CopyOnWriteArrayList<>();
        tableFils.add(create_time);
        tableFils.add(modify_time);
        strategyConfig.setTableFillList(tableFils);
        // strategyConfig.setVersionFieldName("version");// 乐观锁
        strategyConfig.setRestControllerStyle(true);// 开启Restf的风格，驼峰命名
        strategyConfig.setControllerMappingHyphenStyle(true);// localhost:8080/hello_id_2
        autoGenerator.setStrategy(strategyConfig);
        /**
         * 设置模版引擎
         */
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        /**
         * 执行
         */
        autoGenerator.execute();

    }

}
